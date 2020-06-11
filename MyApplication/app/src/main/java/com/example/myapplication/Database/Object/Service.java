package com.example.myapplication.Database.Object;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "services")
public class Service {
    @PrimaryKey(autoGenerate = true)
    private int serviceID;
    private String serviceName;
    private int price;
    private String regulation;
    public Service(int serviceID , String serviceName, int price, String regulation){
        this.serviceID=serviceID;
        this.serviceName=serviceName;
        this.price=price;
        this.regulation=regulation;
    }
    public int getServiceID() {
        return serviceID;
    }
    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }
    public String getServiceName() {
        return serviceName;
    }
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getRegulation() {
        return regulation;
    }
    public void setRegulartion(String regulartion) {
        this.regulation = regulartion;
    }
}
