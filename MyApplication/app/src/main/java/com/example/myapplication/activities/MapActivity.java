package com.example.myapplication.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.myapplication.BuildConfig;
import com.example.myapplication.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MapActivity extends  AppCompatActivity implements OnMapReadyCallback,NavigationView.OnNavigationItemSelectedListener {
    Location currentlocation;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    Menu menu;

    @BindView(R.id.bottomNavigationView)
    BottomNavigationView bottomNavigationView;

    FusedLocationProviderClient fusedLocationProviderClient;
    private static final int REQUEST_CODE  = 101;

    LocationManager locationManager;
    String provider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        ButterKnife.bind(this);

        if (ContextCompat.checkSelfPermission(MapActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(MapActivity.this,
                    Manifest.permission.ACCESS_FINE_LOCATION)){
                ActivityCompat.requestPermissions(MapActivity.this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 101);
            }else{
                ActivityCompat.requestPermissions(MapActivity.this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 101);
            }
        }
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.sos) {
                    Intent i = new Intent(MapActivity.this, WorkingActivity.class);
                    startActivity(i);
                    finish();
                    return true;
                }
                return false;
            }
        });
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Menu menu = navigationView.getMenu();
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle =  new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_open);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        fetchLastLocation();
    }


    private void fetchLastLocation() {
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_CODE);
            return;
        }
        Task<Location> task = fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location!=null){
                    currentlocation=location;
                    Toast.makeText(getApplicationContext(),currentlocation.getLatitude()+"  "+currentlocation.getLongitude(),Toast.LENGTH_SHORT).show();
                    SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.google_map);
                    supportMapFragment.getMapAsync(MapActivity.this::onMapReady);
                }
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng lat = new LatLng(currentlocation.getLatitude(),currentlocation.getLongitude());
        MarkerOptions mk= new MarkerOptions().position(lat).title("I'm here");
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(lat,15));
        googleMap.addMarker(mk);
    }

    // @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        switch (requestCode){
//            case REQUEST_CODE:
//                if (grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
//                    fetchLastLocation();
//                }
//                break;
//        }
//    }

    ////

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults){
        switch (requestCode){
            case 101: {
                if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    if (ContextCompat.checkSelfPermission(MapActivity.this,
                            Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }


    ///
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {super.onBackPressed();
        }
    }
    @Override
    protected void onDestroy() {
        ButterKnife.bind(this).unbind();
        super.onDestroy();
    }


    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.nav_profile:
                Bundle bundle = getIntent().getExtras();
                Intent i = new Intent(MapActivity.this, ProfileActivity.class);
                i.putExtras(bundle);
                startActivity(i);
            case R.id.nav_home:
                break;

            case R.id.nav_logout:
                AlertDialog.Builder builder=new AlertDialog.Builder(MapActivity.this);
                builder.setMessage("Do you want to exit?");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        finish();
                        Intent i=new Intent();
                        i.putExtra("finish", true);
                        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // To clean up all activities
                        //startActivity(i);
                        finish();
                    }
                });

                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

                AlertDialog alert=builder.create();
                alert.show();
                break;
            case R.id.nav_payment:
                break;

            case R.id.nav_share:
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                    String shareMessage= "\nLet me recommend you this application\n\n";
                    shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID +"\n\n";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "choose one"));
                } catch(Exception e) {
                    //e.toString();
                }
        }
        drawerLayout.closeDrawer(GravityCompat.START); return true;
    }

}
