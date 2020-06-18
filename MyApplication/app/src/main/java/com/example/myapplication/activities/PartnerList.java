package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.Database.Object.Partner;
import com.example.myapplication.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PartnerList extends AppCompatActivity {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    List<Partner> partnerArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner_list);
        ButterKnife.bind(this);
        partnerArrayList = LoginActivity.myAppDatabase.myDAO().getPartner();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PartnerAdapter(partnerArrayList);
        recyclerView.setAdapter(adapter);
    }
}
