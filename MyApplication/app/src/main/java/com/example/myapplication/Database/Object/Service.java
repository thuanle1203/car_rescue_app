package com.example.myapplication.Database.Object;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "services")
public class Service {
    @PrimaryKey(autoGenerate = true)
    private int serviceID;
    private String serviceName;

    private String price;

    private String regulation;

    public Service(int serviceID , String serviceName, String price, String regulation){
        this.serviceID=serviceID;
        this.serviceName=serviceName;
        this.price=price;
        this.regulation=regulation;
    }

    public Service() {
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
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    public String getRegulation() {
        return regulation;
    }

    public void setRegulation(String regulation) {
        this.regulation = regulation;
    }
}
