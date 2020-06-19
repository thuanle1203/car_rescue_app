

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
        import android.widget.TextView;
        import android.widget.Toast;

        import com.example.myapplication.Database.Object.Partner;
        import com.example.myapplication.R;
        import com.google.android.material.navigation.NavigationView;

        import java.io.Serializable;
        import java.util.ArrayList;
        import java.util.List;

        import butterknife.BindView;
        import butterknife.ButterKnife;

public class WorkingActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    Menu menu;

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

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle =  new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_open);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

    }

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
            case R.id.nav_profile:
                Bundle bundle = getIntent().getExtras();
                Intent i = new Intent(WorkingActivity.this, ProfileActivity.class);
                i.putExtras(bundle);
                startActivity(i);
                break;
            case R.id.nav_home:


                Intent intent = new Intent(WorkingActivity.this, PartnerList.class);
                //intent.putExtra("partnerList", (Serializable) partnerArrayList);
                startActivity(intent);
                break;

            case R.id.nav_logout:
                AlertDialog.Builder builder=new AlertDialog.Builder(WorkingActivity.this);
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
            case R.id.nav_payment: menu.findItem(R.id.nav_payment).setVisible(false);
                break;


            case R.id.nav_share: Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
        }
        drawerLayout.closeDrawer(GravityCompat.START); return true;
    }

}