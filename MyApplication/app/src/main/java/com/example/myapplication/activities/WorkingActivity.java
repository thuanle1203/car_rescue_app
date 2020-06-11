package com.example.myapplication.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.room.RoomDatabase;

import android.Manifest;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.example.myapplication.R;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WorkingActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //    @BindView(R.id.test)
    //    TextView test;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    Menu menu;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_working);
        ButterKnife.bind(this);

        // menu main
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.nav_logout).setVisible(false);
        menu.findItem(R.id.nav_profile).setVisible(false);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle =  new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_open);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);


//        AsyncTask.execute(new Runnable() {
//            @Override
//            public void run() {
//                List<User> userList = RoomAccess.getInstance().getAccess().getUserDAO().getUsers();
//                if (!userList.isEmpty()) {
//                    updateUI(userList.get(5).getName());
//                }
//            }
//        });
    }

    //    private void updateUI(String name) {
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                test.setText(name);
//            }
//        });
//    }

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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.nav_notifi:
                Bundle bundle = getIntent().getExtras();
                Intent i = new Intent(WorkingActivity.this, ProfileActivity.class);
                i.putExtras(bundle);
                startActivity(i);
                break;
            case R.id.nav_profile:
            Intent intent = new Intent(WorkingActivity.this, LoginActivity.class);
            startActivity(intent);
            break;
//            case R.id.nav_login: menu.findItem(R.id.nav_logout).setVisible(true);
//                menu.findItem(R.id.nav_profile).setVisible(true);
//                menu.findItem(R.id.nav_login).setVisible(false);//        break;
            case R.id.nav_logout: menu.findItem(R.id.nav_logout).setVisible(false);
                menu.findItem(R.id.nav_profile).setVisible(false);
//                menu.findItem(R.id.nav_login).setVisible(true);
                break;
            case R.id.nav_share: Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
        }
        drawerLayout.closeDrawer(GravityCompat.START); return true;
    }

}
