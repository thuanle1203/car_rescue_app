package com.example.myapplication.Database.Object;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "serviceOfPartner")
public class ServiceOfPartner {

        @PrimaryKey(autoGenerate = true)
        private int serviceOfPartnerID;
        private int totalPrice;
        private int serviceID;
        private int partnerID;
        public ServiceOfPartner(int serviceOfPartnerID, int totalPrice, int serviceID, int partnerID) {
            this.serviceID=serviceID;
            this.partnerID=partnerID;
            this.totalPrice=totalPrice;
        }
        public int getServiceOfPartnerID() {
            return serviceOfPartnerID;
        }
        public void setServiceOfPartnerID(int serviceOfPartnerID) {
            this.serviceOfPartnerID = serviceOfPartnerID;
        }
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

}
