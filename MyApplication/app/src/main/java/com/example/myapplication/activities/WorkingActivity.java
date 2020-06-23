

package com.example.myapplication.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.room.RoomDatabase;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.myapplication.R;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WorkingActivity extends AppCompatActivity  {

    @BindView(R.id.Puntured)
    ImageView puntured;

    @BindView(R.id.outofgas)
    ImageView outofgas;

    @BindView(R.id.outOfElectricity)
    ImageView OutofElectricity;

    @BindView(R.id.outOfOil)
    ImageView outofOil;

    @BindView(R.id.calltaxi)
    ImageView calltaxi;

    @BindView(R.id.lostkey)
    ImageView lostkey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_working);
        ButterKnife.bind(this);

        puntured.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WorkingActivity.this, PartnerList.class);
                startActivity(i);
                finish();
            }
        });

        outofgas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WorkingActivity.this, PartnerList.class);
                startActivity(i);
                finish();
            }
        });


        outofOil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WorkingActivity.this, PartnerList.class);
                startActivity(i);
                finish();
            }
        });

        OutofElectricity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WorkingActivity.this, PartnerList.class);
                startActivity(i);
                finish();
            }
        });

        calltaxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WorkingActivity.this, PartnerList.class);
                startActivity(i);
                finish();
            }
        });

        lostkey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WorkingActivity.this, PartnerList.class);
                startActivity(i);
                finish();
            }
        });


    }
    @Override
    protected void onDestroy() {
        ButterKnife.bind(this).unbind();
        super.onDestroy();
    }

}