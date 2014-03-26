package com.yyq.demo.struts.form;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.yyq.common.CommonConsts;

public class RegistForm extends ActionForm{
    private String mid;
    private String password;
    private String name;
    private String address;
    private String telephone;
    private String lastdate;
    private String lockflag;
    private String zipcode;
    private String imagecode;
    @Override
    public ActionErrors validate(ActionMapping mapping,
            HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (!Pattern.matches("^[a-z0-9_-]{3,16}$", this.mid)) {
            errors.add("error", new ActionMessage("error.geshibudui",CommonConsts.STR_MID));
        }
        if (!Pattern.matches("^[a-z0-9_-]{6,18}$", this.password)) {
            errors.add("error", new ActionMessage("error.geshibudui",CommonConsts.STR_PASSWORD));
        }
        if (!Pattern.matches("^[\u4e00-\u9fa5]{2,10}$", this.name)) {
            errors.add("error", new ActionMessage("error.geshibudui", CommonConsts.STR_NAME));
        }
        if (!Pattern.matches("^\\S{1,60}", this.address)) {
            errors.add("error", new ActionMessage("error.geshibudui", CommonConsts.STR_ADDRESS));
        }
        if (!Pattern.matches("^[1-9]\\d{5}$", this.zipcode)) {
            errors.add("error", new ActionMessage("error.geshibudui", CommonConsts.STR_ZIPCODE));
        }
        if (!Pattern.matches("1\\d{10}", this.telephone)) {
            errors.add("error", new ActionMessage("error.geshibudui", CommonConsts.STR_TELEPHONE));
        }
        if (this.imagecode == null || !this.imagecode.equals(request.getSession().getAttribute("rand"))) {
            errors.add("error", new ActionMessage("error.yanzhengma"));
        }
        return errors;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getLastdate() {
        return lastdate;
    }

    public void setLastdate(String lastdate) {
        this.lastdate = lastdate;
    }

    public String getLockflag() {
        return lockflag;
    }

    public void setLockflag(String lockflag) {
        this.lockflag = lockflag;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getImagecode() {
        return imagecode;
    }

    public void setImagecode(String imagecode) {
        this.imagecode = imagecode;
    }
}
