package com.yyq.common;

public class CommonConsts {
    
    public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    
    public static final String MYSQL_URL = "jdbc:mysql://180.178.57.164:3306/a0313135557";
    
    public static final String MYSQL_USER = "a0313135557";
    
    public static final String MYSQL_PASSWORD = "16547228";
    
    public static final String STR_MID = "账号ID";
    public static final String STR_PASSWORD = "密码";
    public static final String STR_NAME = "姓名";
    public static final String STR_ADDRESS = "地址";
    public static final String STR_TELEPHONE = "电话";
    public static final String STR_ZIPCODE = "邮政编码";
    
    public static final int ADDRESS_MAX_LENGTH = 60;
    
    public static final String SRSBR_CD_BASE_INFO_LOCK_MESSAGE = 
            "日程、開始時間、受講者数、会場等の情報が正しいか、ご確認をお願いします。"
            + "\n" + "なお、研修実施1週間前からは、お客様からの基本情報の変更はできなくなります。"
            + "\n" + "変更の必要が生じた場合には、お手数ですが、至急弊社担当までご連絡ください。";
    
    public static void main (String[] args) {
        System.out.println(SRSBR_CD_BASE_INFO_LOCK_MESSAGE);
    }
}
