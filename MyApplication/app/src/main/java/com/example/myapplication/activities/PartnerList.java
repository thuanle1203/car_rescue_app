package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.icu.text.Transliterator;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.Database.Object.Partner;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PartnerList extends AppCompatActivity {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    PartnerAdapter adapter;
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
        adapter.setOnItemClickListener(new PartnerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent i = new Intent(PartnerList.this,MapActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Bundle bundle1 = new Bundle();
                bundle1.putDouble("longTitude",partnerArrayList.get(position).getLongitude());
                bundle1.putDouble("lateTitude",partnerArrayList.get(position).getLatitude());
                i.putExtras(bundle1);
                startActivity(i);
                finish();
            }
        });
    }
}
