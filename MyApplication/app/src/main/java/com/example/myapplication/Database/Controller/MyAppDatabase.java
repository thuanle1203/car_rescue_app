package com.example.myapplication.Database.Controller;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.myapplication.Database.Object.Bill;
import com.example.myapplication.Database.Object.HistoryDB;
import com.example.myapplication.Database.Object.Partner;
import com.example.myapplication.Database.Object.Service;
import com.example.myapplication.Database.Object.ServiceOfPartner;
import com.example.myapplication.Database.Object.User;

@Database(entities = {User.class, Bill.class, Partner.class, Service.class, ServiceOfPartner.class, HistoryDB.class}, version = 2)
public abstract class MyAppDatabase extends RoomDatabase {
    public abstract MyDAO myDAO();
}