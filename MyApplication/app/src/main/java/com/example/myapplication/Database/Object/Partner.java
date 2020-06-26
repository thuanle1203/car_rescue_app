package com.example.myapplication.Database.Object;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
    @Entity(tableName = "partners")
    public class Partner implements Comparable<Partner> {
        @PrimaryKey(autoGenerate = true)
        private int partnerID;
        private String namePartner;
        private String activePlace;
        private String review;
        private String addressPartner;
        private double latitude;
        private double longitude;
        private String phoneNumber;
        private String activeTime;
        private float distance;

        public Partner(int partnerID, String namePartner, String activePlace, String review, String addressPartner, double latitude, double longitude, String phoneNumber, String activeTime) {
            this.partnerID = partnerID;
            this.namePartner = namePartner;
            this.activePlace = activePlace;
            this.review = review;
            this.addressPartner = addressPartner;
            this.latitude = latitude;
            this.longitude = longitude;
            this.phoneNumber = phoneNumber;
            this.activeTime = activeTime;
        }

        public Partner() {
        }

        public float getDistance() {
            return distance;
        }

        public void setDistance(float distance) {
            this.distance = distance;
        }

        public String getNamePartner() {
            return namePartner;
        }

        public void setNamePartner(String namePartner) {
            this.namePartner = namePartner;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public int getPartnerID() {
            return partnerID;
        }
        public void setPartnerID(int partnerID) {
            this.partnerID = partnerID;
        }
        public String getActivePlace() {
            return activePlace;
        }
        public void setActivePlace(String activePlace) {
            this.activePlace = activePlace;
        }
        public String getAddressPartner() {
            return addressPartner;
        }
        public void setAddressPartner(String addressPartner) {
            this.addressPartner = addressPartner;
        }
        public String getReview() {
            return review;
        }
        public void setReview(String review) {
            this.review = review;
        }
        public String getPhoneNumber() {
            return phoneNumber;
        }
        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
        public String getActiveTime() {
            return activeTime;
        }
        public void setActiveTime(String activeTime) {
            this.activeTime = activeTime;
        }

        @Override
        public int compareTo(Partner o) {
            if (distance == o.distance){
                return 0;
            }
            else if(distance>o.distance)
                return 1;
            else return -1;
        }
    }
