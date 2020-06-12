package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.Database.Object.Partner;
import com.example.myapplication.Database.Object.Service;
import com.example.myapplication.R;

import butterknife.BindView;

public class ServiceActivity extends AppCompatActivity {
    @BindView(R.id.edt_addIdPar)
    EditText edt_name;

    @BindView(R.id.edt_addNume)
    EditText edt_Nume;

    @BindView(R.id.edt_addAdre)
    EditText edt_Adrre;

    @BindView(R.id.edt_Review)
    EditText edt_Review;

    @BindView(R.id.btn_addParner)
    Button btn_addPartner;

    @BindView(R.id.addServiceName)
    EditText addServiceName;

    @BindView(R.id.addServicePrice)
    EditText addServicePrice;

    @BindView(R.id.addServiceRegulation)
    EditText addServiceRegulation;

    @BindView(R.id.btn_addService)
    Button btn_addService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        btn_addPartner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1, address1, phoneNum1, review1;
                name1 = edt_name.getText().toString();
                address1 = edt_Adrre.getText().toString();
                phoneNum1 = edt_Nume.getText().toString();
                review1 = edt_Review.getText().toString();
                Partner p = new Partner();
                p.setNamePartner(name1);
                p.setAddressPartner(address1);
                p.setPhoneNumber(phoneNum1);
                p.setReview(review1);
                LoginActivity.myAppDatabase.myDAO().addPartner(p);
            }
        });

        btn_addService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name, price, regulation;
                name = addServiceName.getText().toString();
                price = addServicePrice.getText().toString();
                regulation = addServiceRegulation.getText().toString();
                Service s = new Service();
                s.setServiceName(name);
                s.setPrice(price);
                s.setRegulation(regulation);
                LoginActivity.myAppDatabase.myDAO().addService(s);
            }
        });
    }

}

