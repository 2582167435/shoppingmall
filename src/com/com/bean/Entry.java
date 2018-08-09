package com.com.bean;


import java.sql.Date;

public class Entry {
    private int eID;                        //入库单编号
    private int gID;                        //商品编号
    private int sID;                        //供应商编号
    private String entryManager;            //入库管理员
    private Date entryDate;                 //入库时间
    private int eCount;                     //入库数量
    private String eWay;                    //入库方式
    private boolean isVerify;               //审核标记
    private boolean isPass;                 //通过标记
    private boolean isDeal;                 //处理标记

    public int geteID() {
        return eID;
    }

    public void seteID(int eID) {
        this.eID = eID;
    }

    public int getgID() {
        return gID;
    }

    public void setgID(int gID) {
        this.gID = gID;
    }

    public int getsID() {
        return sID;
    }

    public void setsID(int sID) {
        this.sID = sID;
    }

    public String getEntryManager() {
        return entryManager;
    }

    public void setEntryManager(String entryManager) {
        this.entryManager = entryManager;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public int geteCount() {
        return eCount;
    }

    public void seteCount(int eCount) {
        this.eCount = eCount;
    }

    public String geteWay() {
        return eWay;
    }

    public void seteWay(String eWay) {
        this.eWay = eWay;
    }

    public boolean isVerify() {
        return isVerify;
    }

    public void setVerify(boolean verify) {
        isVerify = verify;
    }

    public boolean isPass() {
        return isPass;
    }

    public void setPass(boolean pass) {
        isPass = pass;
    }

    public boolean isDeal() {
        return isDeal;
    }

    public void setDeal(boolean deal) {
        isDeal = deal;
    }

    public Entry(int eID, int gID, int sID, String entryManager, Date entryDate, int eCount, String eWay, boolean isVerify, boolean isPass, boolean isDeal) {
        this.eID = eID;
        this.gID = gID;
        this.sID = sID;
        this.entryManager = entryManager;
        this.entryDate = entryDate;
        this.eCount = eCount;
        this.eWay = eWay;
        this.isVerify = isVerify;
        this.isPass = isPass;
        this.isDeal = isDeal;
    }

    public Entry() {
    }
}
