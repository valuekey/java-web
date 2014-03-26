package com.yyq.demo.vo;

import java.util.Date;

public class Emp {
    private int empno;
    private String ename;
    private String job;
    private Date hiredate;
    private float sal;
    private String pic;
    public int getEmpno() {
        return empno;
    }
    public void setEmpno(int empno) {
        this.empno = empno;
    }
    public String getEname() {
        return ename;
    }
    public void setEname(String ename) {
        this.ename = ename;
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }
    public Date getHiredate() {
        return hiredate;
    }
    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }
    public float getSal() {
        return sal;
    }
    public void setSal(float sal) {
        this.sal = sal;
    }
    public String getPic() {
        return pic;
    }
    public void setPic(String pic) {
        this.pic = pic;
    }
}
