package com.com.bean;

public class Order {
    private int orId;                   //业务号
    private String orCode;              //订单号
    private int gID;                    //商品编号
    private int uID;                    //用户编号
    private int orCount;                //购买数量
    private String gsaddress;           //配送地点
    private float orPrice;              //订单价格
    private String orTelephone;         //收货电话
    private String orName;              //收货人
    private boolean isOut = false;      //是否发货

    public int getOrId() {
        return orId;
    }

    public void setOrId(int orId) {
        this.orId = orId;
    }

    public String getOrCode() {
        return orCode;
    }

    public void setOrCode(String orCode) {
        this.orCode = orCode;
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

    public int getOrCount() {
        return orCount;
    }

    public void setOrCount(int orCount) {
        this.orCount = orCount;
    }

    public String getGsaddress() {
        return gsaddress;
    }

    public void setGsaddress(String gsaddress) {
        this.gsaddress = gsaddress;
    }

    public float getOrPrice() {
        return orPrice;
    }

    public void setOrPrice(float orPrice) {
        this.orPrice = orPrice;
    }

    public String getOrTelephone() {
        return orTelephone;
    }

    public void setOrTelephone(String orTelephone) {
        this.orTelephone = orTelephone;
    }

    public String getOrName() {
        return orName;
    }

    public void setOrName(String orName) {
        this.orName = orName;
    }

    public boolean isOut() {
        return isOut;
    }

    public void setOut(boolean out) {
        isOut = out;
    }

    public Order(int orId, String orCode, int gID, int uID, int orCount, String gsaddress, float orPrice, String orTelephone, String orName, boolean isOut) {
        this.orId = orId;
        this.orCode = orCode;
        this.gID = gID;
        this.uID = uID;
        this.orCount = orCount;
        this.gsaddress = gsaddress;
        this.orPrice = orPrice;
        this.orTelephone = orTelephone;
        this.orName = orName;
        this.isOut = isOut;
    }

    public Order() {
    }
}
