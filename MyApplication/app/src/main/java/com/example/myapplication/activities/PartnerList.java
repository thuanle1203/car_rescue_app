package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.Database.Object.Partner;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PartnerList extends AppCompatActivity {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    ArrayList<Partner> partnerArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner_list);
        ButterKnife.bind(this);

        List<Partner> partnerArrayList = new ArrayList<Partner>();
        List<Integer> partnerId = LoginActivity.myAppDatabase.myDAO().getPartnerIdByServiceId(1);
        for (int i1 = 0; i1 < partnerId.size(); i1++)
        {
            Partner pn = LoginActivity.myAppDatabase.myDAO().getPartnerById(partnerId.get(i1));
            partnerArrayList.add(pn);

        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PartnerAdapter(partnerArrayList);
        recyclerView.setAdapter(adapter);
    }
}
