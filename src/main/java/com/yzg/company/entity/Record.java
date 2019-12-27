package com.yzg.company.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Record {
    private int id;
    private int userId;
    private String rejiaos;
    private float regzjy;
    @DateTimeFormat(pattern = "yyyy-MM-DD")
    private Date redaterz;

    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserid(int userid) {
        this.userId = userId;
    }

    public String getRejiaos() {
        return rejiaos;
    }

    public void setRejiaos(String rejiaos) {
        this.rejiaos = rejiaos;
    }

    public float getRegzjy() {
        return regzjy;
    }

    public void setRegzjy(float regzjy) {
        this.regzjy = regzjy;
    }

    public Date getRedaterz() {
        return redaterz;
    }

    public void setRedaterz(Date redaterz) {
        this.redaterz = redaterz;
    }
}
