package com.com.bean;

public class Return {
    private int rID;            //退货业务号
    private int uID;            //用户编号
    private int gID;            //商品编号
    private int rCount;         //退货数量
    private String reason;      //退货理由
    private String rcode;       //退货编号

    public int getrID() {
        return rID;
    }

    public void setrID(int rID) {
        this.rID = rID;
    }

    public int getuID() {
        return uID;
    }

    public void setuID(int uID) {
        this.uID = uID;
    }

    public int getgID() {
        return gID;
    }

    public void setgID(int gID) {
        this.gID = gID;
    }

    public int getrCount() {
        return rCount;
    }

    public void setrCount(int rCount) {
        this.rCount = rCount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRcode() {
        return rcode;
    }

    public void setRcode(String rcode) {
        this.rcode = rcode;
    }

    public Return(int rID, int uID, int gID, int rCount, String reason, String rcode) {
        this.rID = rID;
        this.uID = uID;
        this.gID = gID;
        this.rCount = rCount;
        this.reason = reason;
        this.rcode = rcode;
    }

    public Return() {
    }
}
