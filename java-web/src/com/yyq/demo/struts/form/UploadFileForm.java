package com.yyq.demo.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

public class UploadFileForm extends ActionForm{
    private FormFile file;

    @Override
    public ActionErrors validate(ActionMapping mapping,
            HttpServletRequest request) {
        System.out.println(file.getFileName());
        System.out.println(file.getFileSize());
        System.out.println(file.getContentType());
        return null;
    }
    
    public FormFile getFile() {
        return file;
    }

    public void setFile(FormFile file) {
        this.file = file;
    }
    
}
