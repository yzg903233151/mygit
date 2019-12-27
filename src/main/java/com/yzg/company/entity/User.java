package com.yzg.company.entity;

public class User extends Record{
    private int id ;
    private String userName;
    private int userAge ;
    private String userSection ;
    private String userPosition;
    private Double userPath;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getUserSection() {
        return userSection;
    }

    public void setUserSection(String userSection) {
        this.userSection = userSection;
    }

    public String getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(String userPosition) {
        this.userPosition = userPosition;
    }

    public Double getUserPath() {
        return userPath;
    }

    public void setUserPath(Double userPath) {
        this.userPath = userPath;
    }
}
