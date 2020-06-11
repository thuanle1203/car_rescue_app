package com.example.myapplication.Database.Object;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "bills")
public class Bill {
    @PrimaryKey(autoGenerate = true)
    private int billID;
    // private Date timeBill;
    private int totalPrice;
    private int serviceID;
    private int partnerID;
    private int userID;
    public Bill(int billID, int totalPrice, int serviceID, int partnerID, int userID) {
        this.billID=billID;
        //this.timeBill=timeBill;
        this.totalPrice=totalPrice;
        this.serviceID=serviceID;
        this.partnerID=partnerID;
        this.userID=userID;
    }
    public int getBillID() {
        return billID;
    }
    public void setBillID(int billID) {
        this.billID = billID;
    }
    //public Date getTimeBill() {
    //  return timeBill;
    //}
    //public void setTimeBill(Date timeBill) {
    //this.timeBill = timeBill;
    //}
    public int getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
    public int getServiceID() {
        return serviceID;
    }
    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }
    public int getPartnerID() {
        return partnerID;
    }
    public void setPartnerID(int partnerID) {
        this.partnerID = partnerID;
    }
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
}