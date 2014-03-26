package com.yyq.demo.struts.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.yyq.demo.struts.form.UploadFileForm;

public class UploadFileAction extends Action{
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        UploadFileForm fileForm = (UploadFileForm) form;
        StringBuffer fileName = new StringBuffer();
        fileName.append(super.getServlet().getServletContext().getRealPath("/"));
        fileName.append("upload" + java.io.File.separator);
        Random rd = new Random();
        for (int i = 0; i < 10; i++) {
            fileName.append(rd.nextInt(9));
        }
        fileName.append("." + fileForm.getFile().getFileName().split("\\.")[fileForm.getFile().getFileName().split("\\.").length-1]);
        File outFile = new File(fileName.toString());
        OutputStream output = new FileOutputStream(outFile);
        InputStream input = fileForm.getFile().getInputStream();
        
        byte[] buffer = new byte[1024];
        while((input.read(buffer)) != -1){
            output.write(buffer);
        }
        output.close();
        input.close();
        return null;
    }
}
