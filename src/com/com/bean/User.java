package com.com.bean;

public class User {
    private int uID;                            //用户编号
    private int tID;                            //角色编号
    private String uName;                       //用户名
    private String uPassword;                   //用户密码
    private int uiID;                          //用户信息编号

    public int getuID() {
        return uID;
    }

    public void setuID(int uID) {
        this.uID = uID;
    }

    public int gettID() {
        return tID;
    }

    public void settID(int tID) {
        this.tID = tID;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public int getUiID() {
        return uiID;
    }

    public void setUiID(int uiID) {
        this.uiID = uiID;
    }

    public User(int uID, int tID, String uName, String uPassword, int uiID) {
        this.uID = uID;
        this.tID = tID;
        this.uName = uName;
        this.uPassword = uPassword;
        this.uiID = uiID;
    }

    public User() {
    }




}
