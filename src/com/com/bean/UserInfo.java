package com.com.bean;

public class UserInfo {

    private int uiid;                   //用户信息编号
    private String uiCode;              //用户信息业务编号
    private String uiName;              //姓名
    private String uiTelephone;         //电话
    private String uiAddress;           //地址
    private String uiEmail;             //电子邮件
    private boolean isDelete = false;   //删除标志

    public UserInfo(int uiid, String uiCode, String uiName, String uiTelephone, String uiAddress, String uiEmail, boolean isDelete) {
        this.uiid = uiid;
        this.uiCode = uiCode;
        this.uiName = uiName;
        this.uiTelephone = uiTelephone;
        this.uiAddress = uiAddress;
        this.uiEmail = uiEmail;
        this.isDelete = isDelete;
    }

    public UserInfo() {
    }

    public int getUiid() {
        return uiid;
    }

    public void setUiid(int uiid) {
        this.uiid = uiid;
    }

    public String getUiCode() {
        return uiCode;
    }

    public void setUiCode(String uiCode) {
        this.uiCode = uiCode;
    }

    public String getUiName() {
        return uiName;
    }

    public void setUiName(String uiName) {
        this.uiName = uiName;
    }

    public String getUiTelephone() {
        return uiTelephone;
    }

    public void setUiTelephone(String uiTelephone) {
        this.uiTelephone = uiTelephone;
    }

    public String getUiAddress() {
        return uiAddress;
    }

    public void setUiAddress(String uiAddress) {
        this.uiAddress = uiAddress;
    }

    public String getUiEmail() {
        return uiEmail;
    }

    public void setUiEmail(String uiEmail) {
        this.uiEmail = uiEmail;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
