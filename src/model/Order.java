/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import java.util.Date;

/**
 *
 * @author kien3
 */
public class Order {
    private String pcode;
    private String ccode;
    private Date odate;
    private Date sdate;
    private int quantity;

    public Order() {
    }

    public Order(String pcode, String ccode, Date odate, Date sdate, int quantity) {
        this.pcode = pcode;
        this.ccode = ccode;
        this.odate = odate;
        this.sdate = sdate;
        this.quantity = quantity;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getCcode() {
        return ccode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    public Date getOdate() {
        return odate;
    }

    public void setOdate(Date odate) {
        this.odate = odate;
    }

    public Date getSdate() {
        return sdate;
    }

    public void setSdate(Date sdate) {
        this.sdate = sdate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" + "pcode=" + pcode + ", ccode=" + ccode + ", odate=" + odate + ", sdate=" + sdate + ", quantity=" + quantity + '}';
    }

    
    


}
