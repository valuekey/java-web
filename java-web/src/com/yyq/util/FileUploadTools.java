package com.yyq.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class FileUploadTools {
    private HttpServletRequest request = null;
    private List<FileItem> items = null;
    private Map<String, List<String>> params = new HashMap<String, List<String>>();
    private Map<String, FileItem> files = new HashMap<String, FileItem>();
    
    private int maxSize = 3 * 1024 * 1024;
    
    public FileUploadTools(HttpServletRequest request, int maxSize, String tempDir) throws Exception {
        this.request = request;
        
        DiskFileItemFactory factory = new DiskFileItemFactory();
        
        if (tempDir != null) {
            factory.setRepository(new File(tempDir));
        }
        
        ServletFileUpload upload = new ServletFileUpload(factory);
        
        if (maxSize > 0) {
            this.maxSize = maxSize;
        }
        
        upload.setFileSizeMax(this.maxSize);
        
        this.items = upload.parseRequest(request);
        
        this.init();
    }

    private void init() {
        // TODO Auto-generated method stub
        Iterator<FileItem> iter = this.items.iterator();
        IPTimeStamp its = new IPTimeStamp(this.request.getRemoteAddr());
        while (iter.hasNext()) {
            FileItem item = iter.next();
            if (item.isFormField()) {
                String name = item.getFieldName();
                String value = item.getString();
                List<String> temp = null;
                if (this.params.containsKey(name)) {
                    temp = this.params.get(name);
                } else {
                    temp = new ArrayList<String>();
                }
                temp.add(value);
                this.params.put(name, temp);
            } else {
                String fileName = its.getIPTimeRand() + "." + item.getName().split("\\.")[1];
                this.files.put(fileName, item);
            }
        }
    }
    
    public String getParameter(String name) {
        String ret = null;
        List<String> temp = this.params.get(name);
        if (temp != null) {
            ret = temp.get(0);
        }
        return ret;
    }
    
    public String[] getParameterValues(String name) {
        String[] ret = null;
        List<String> temp = this.params.get(name);
        if (temp != null) {
            ret = temp.toArray(new String[]{});
        }
        return ret;
    }
    
    public Map<String, FileItem> getUploadFiles() {
        return this.files;
    }
    
    public List<String> saveAll(String saveDir) throws Exception {
        List<String> names = new ArrayList<String>();
        
        if (this.files.size() > 0) {
            Set<String> keys = this.files.keySet();
            Iterator<String> iter = keys.iterator();
            File saveFile = null;
            InputStream input = null;
            OutputStream output = null;
            while (iter.hasNext()) {
                FileItem item = this.files.get(iter.next());
                String fileName = new IPTimeStamp(this.request.getRemoteAddr()).getIPTimeRand() + "." + item.getName().split("\\.")[1];
                saveFile = new File(saveDir + fileName);
                names.add(fileName);
                
                input = item.getInputStream();
                output = new FileOutputStream(saveFile);
                
                int temp = 0;
                byte[] data = new byte[512];
                
                while ((temp = input.read(data, 0, 512)) != -1) {
                    output.write(data);
                }
                input.close();
                output.close();
            }
        }
        
        return names;
    }
    
    public List<String> saveAll(Connection conn) throws Exception {
        List<String> names = new ArrayList<String>();
        
        if (this.files.size() > 0) {
            Set<String> keys = this.files.keySet();
            Iterator<String> iter = keys.iterator();
            InputStream input = null;
            PreparedStatement pstmt = null;
            while (iter.hasNext()) {
                FileItem item = this.files.get(iter.next());
                String fileName = new IPTimeStamp(this.request.getRemoteAddr()).getIPTimeRand() + "." + item.getName().split("\\.")[1];
                //saveFile = new File(saveDir + fileName);
                names.add(fileName);
                
                String sql = "insert into picstore (picname, pic) values (?,?)";
                
                pstmt = conn.prepareStatement(sql);
                
                input = item.getInputStream();
                
                pstmt.setString(1, fileName);
                pstmt.setBinaryStream(2, input);
                
                pstmt.executeUpdate();
                
                input.close();
            }
        }
        
        return names;
    }
}
