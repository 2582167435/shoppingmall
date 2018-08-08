package com.com.bean;

public class Goods {
    private int gID;                //商品编号
    private String gCode;           //商品编码
    private String gName;           //商品名称
    private int gCount;             //商品数量
    private float gPrice;           //商品价格
    private String gAddress;        //商品产地
    private String gType;           //商品类型
    private boolean isDelete;       //删除标志

    public int getgID() {
        return gID;
    }

    public void setgID(int gID) {
        this.gID = gID;
    }

    public String getgCode() {
        return gCode;
    }

    public void setgCode(String gCode) {
        this.gCode = gCode;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public int getgCount() {
        return gCount;
    }

    public void setgCount(int gCount) {
        this.gCount = gCount;
    }

    public float getgPrice() {
        return gPrice;
    }

    public void setgPrice(float gPrice) {
        this.gPrice = gPrice;
    }

    public String getgAddress() {
        return gAddress;
    }

    public void setgAddress(String gAddress) {
        this.gAddress = gAddress;
    }

    public String getgType() {
        return gType;
    }

    public void setgType(String gType) {
        this.gType = gType;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public Goods() {
    }

    public Goods(int gID, String gCode, String gName, int gCount, float gPrice, String gAddress, String gType, boolean isDelete) {
        this.gID = gID;
        this.gCode = gCode;
        this.gName = gName;
        this.gCount = gCount;
        this.gPrice = gPrice;
        this.gAddress = gAddress;
        this.gType = gType;
        this.isDelete = isDelete;
    }
}
