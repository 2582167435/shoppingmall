package com.com.bean;

public class UserType {

    private int tID;            //角色编号
    private String userType;    //用户类型

    public int gettID() {
        return tID;
    }

    public void settID(int tID) {
        this.tID = tID;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public UserType(int tID, String userType) {
        this.tID = tID;
        this.userType = userType;
    }

    public UserType() {
    }
}
