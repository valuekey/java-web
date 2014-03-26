package com.yyq.demo.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class HtmlTagDemoForm extends ActionForm{
    private String name;
    private String password;
    private String sex;
    private String inst[];
    private String city[];
    private String note;
    private String item;
    
    @Override
    public ActionErrors validate(ActionMapping mapping,
            HttpServletRequest request) {
        return null;
    }
    
    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        this.name = "严英权";
        this.inst = new String[]{"running","swimming"};
        this.city = new String[]{"beijing","shanghai"};
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String[] getInst() {
        return inst;
    }
    public void setInst(String[] inst) {
        this.inst = inst;
    }
    public String[] getCity() {
        return city;
    }
    public void setCity(String[] city) {
        this.city = city;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
    
    
}
