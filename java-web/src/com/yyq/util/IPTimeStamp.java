package com.yyq.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class IPTimeStamp {
    private SimpleDateFormat sdf = null;
    private String ip = null;
    
    
    
    public IPTimeStamp() {
        // TODO Auto-generated constructor stub
    }
    
    public IPTimeStamp(String ip) {
        // TODO Auto-generated constructor stub
        this.ip = ip;
    }
    
    public String getDate() {
        this.sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return sdf.format(new Date());
    }
    
    public String getTimeStamp() {
        this.sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return sdf.format(new Date());
    }
    
    public String getIPTimeRand() {
        StringBuffer buf = new StringBuffer();
        if (this.ip != null) {
            String[] s = this.ip.split("\\.");
            for (int i = 0; i < s.length; i++){
                buf.append(this.addZero(s[i], 3));
            }
        }
        buf.append(this.getTimeStamp());
        Random r = new Random();
        for (int i = 0; i < 3; i++) {
            buf.append(r.nextInt(10));
        }
        return buf.toString();
    }
    
    private String addZero(String str, int len) {
        StringBuffer s = new StringBuffer();
        s.append(str);
        while (s.length() < len) {
            s.insert(0, 0);
        }
        return s.toString();
    }
}
