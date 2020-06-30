package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.icu.text.Transliterator;
import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.Database.Object.Partner;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PartnerList extends AppCompatActivity {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    PartnerAdapter adapter;
    ArrayList<Partner> partnerArrayList;
    Bundle bundle;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner_list);
        ButterKnife.bind(this);

        intent = getIntent();
        bundle = intent.getExtras();

        Double currentLatitude = bundle.getDouble("currentLatitude");
        Double currentLongitude = bundle.getDouble("currentLongitude");
        int serviceId = bundle.getInt("serviceId");

        List<Partner> partnerArrayList = new ArrayList<Partner>();
        List<Integer> partnerId = LoginActivity.myAppDatabase.myDAO().getPartnerIdByServiceId(serviceId);


        for (int i1 = 0; i1 < partnerId.size(); i1++)
        {
            Partner pn = LoginActivity.myAppDatabase.myDAO().getPartnerById(partnerId.get(i1));
            pn.setDistance(distanceBetween(currentLatitude,currentLongitude,pn.getLatitude(),pn.getLongitude()));
            partnerArrayList.add(pn);
        }

        Collections.sort(partnerArrayList);

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
                bundle1.putString("pName", partnerArrayList.get(position).getNamePartner());
                i.putExtras(bundle1);
                startActivity(i);
                finish();
            }
        });
    }
    public static double distanceBetween (double startLatitude, double startLongitude, double endLatitude, double endLongitude){
        double result;
        Location locationA = new Location("point A");

        locationA.setLatitude(startLatitude);
        locationA.setLongitude(startLongitude);

        Location locationB = new Location("point B");

        locationB.setLatitude(endLatitude);
        locationB.setLongitude(endLongitude);

        result = locationA.distanceTo(locationB)/1000;
        return result;
    }

}
