package com.example.sitharawanigasooriy.ma;

/**
 * Created by Sithara wanigasooriy on 4/29/2018.
 */

public class SellingItem extends Item {
    private int no;
    private String Total;
    //private String product_code,product_name,quantity,price,type,discount;


    public int getNo() {
        return no;
    }

    public String getTotal() {
        return Total;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setTotal(String total) {
        Total = total;
    }
}
