package com.com.bean;

public class Supplier {
    private int sID;                //供应商业务号
    private String sName;           //负责人名称
    private String sAddress;        //供应商地址
    private String sprerPhone;      //法人代表电话
    private String scomPhone;       //公司电话
    private String sAcount;         //供应商银行账号
    private String scomName;        //公司名称
    private String sCode;           //供应商编号
    private Boolean isDelete = false;       //删除标志

    public Supplier(int sID, String sName, String sAddress, String sprerPhone, String scomPhone, String sAcount, String scomName, String sCode, Boolean isDelete) {
        this.sID = sID;
        this.sName = sName;
        this.sAddress = sAddress;
        this.sprerPhone = sprerPhone;
        this.scomPhone = scomPhone;
        this.sAcount = sAcount;
        this.scomName = scomName;
        this.sCode = sCode;
        this.isDelete = isDelete;
    }

    public Supplier() {
    }

    public int getsID() {
        return sID;
    }

    public void setsID(int sID) {
        this.sID = sID;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsAddress() {
        return sAddress;
    }

    public void setsAddress(String sAddress) {
        this.sAddress = sAddress;
    }

    public String getSprerPhone() {
        return sprerPhone;
    }

    public void setSprerPhone(String sprerPhone) {
        this.sprerPhone = sprerPhone;
    }

    public String getScomPhone() {
        return scomPhone;
    }

    public void setScomPhone(String scomPhone) {
        this.scomPhone = scomPhone;
    }

    public String getsAcount() {
        return sAcount;
    }

    public void setsAcount(String sAcount) {
        this.sAcount = sAcount;
    }

    public String getScomName() {
        return scomName;
    }

    public void setScomName(String scomName) {
        this.scomName = scomName;
    }

    public String getsCode() {
        return sCode;
    }

    public void setsCode(String sCode) {
        this.sCode = sCode;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }
}