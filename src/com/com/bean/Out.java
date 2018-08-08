package com.com.bean;

import java.util.Date;

public class Out {
    private int oID;                        //出库单业务号
    private String oCode;                   //出库单单号
    private int gID;                        //商品编号
    private int uID;                        //用户编号
    private Date outDate;                   //出库日期
    private String outManager;              //出库管理员
    private String oWay;                    //出库方式
    private int oCount;                     //出库数量
    private boolean isVerif = false;        //审核标记
    private boolean isPass = false;         //通过标记
    private boolean isDeal = false;         //处理标记

    public int getoID() {
        return oID;
    }

    public void setoID(int oID) {
        this.oID = oID;
    }

    public String getoCode() {
        return oCode;
    }

    public void setoCode(String oCode) {
        this.oCode = oCode;
    }

    public int getgID() {
        return gID;
    }

    public void setgID(int gID) {
        this.gID = gID;
    }

    public int getuID() {
        return uID;
    }

    public void setuID(int uID) {
        this.uID = uID;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    public String getOutManager() {
        return outManager;
    }

    public void setOutManager(String outManager) {
        this.outManager = outManager;
    }

    public String getoWay() {
        return oWay;
    }

    public void setoWay(String oWay) {
        this.oWay = oWay;
    }

    public int getoCount() {
        return oCount;
    }

    public void setoCount(int oCount) {
        this.oCount = oCount;
    }

    public boolean isVerif() {
        return isVerif;
    }

    public void setVerif(boolean verif) {
        isVerif = verif;
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

    public Out(int oID, String oCode, int gID, int uID, Date outDate, String outManager, String oWay, int oCount, boolean isVerif, boolean isPass, boolean isDeal) {
        this.oID = oID;
        this.oCode = oCode;
        this.gID = gID;
        this.uID = uID;
        this.outDate = outDate;
        this.outManager = outManager;
        this.oWay = oWay;
        this.oCount = oCount;
        this.isVerif = isVerif;
        this.isPass = isPass;
        this.isDeal = isDeal;
    }

    public Out() {
    }
}