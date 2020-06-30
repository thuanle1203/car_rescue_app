

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
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.example.myapplication.BuildConfig;
        import com.example.myapplication.R;
        import com.google.android.material.navigation.NavigationView;

        import java.util.ArrayList;
        import java.util.List;

        import butterknife.BindView;
        import butterknife.ButterKnife;

public class WorkingActivity extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.Puntured)
    ImageView puntured;

    @BindView(R.id.outofgas)
    ImageView outofgas;

    @BindView(R.id.rescue)
    ImageView rescue;

    @BindView(R.id.outOfElectricity)
    ImageView OutofElectricity;

    @BindView(R.id.calltaxi)
    ImageView calltaxi;

    @BindView(R.id.lostkey)
    ImageView lostkey;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    Bundle bundle;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_working);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle =  new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_open);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        puntured.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle = getIntent().getExtras();
                Intent intent1 = new Intent(WorkingActivity.this,PartnerList.class);
                bundle.putInt("serviceId", 1);
                intent1.putExtras(bundle);
                startActivity(intent1);
                finish();
            }
        });

        outofgas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(WorkingActivity.this,PartnerList.class);
                bundle.putInt("serviceId", 2);
                intent1.putExtras(bundle);
                startActivity(intent1);
                finish();
            }
        });


        rescue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(WorkingActivity.this,PartnerList.class);
                bundle.putInt("serviceId", 3);
                intent1.putExtras(bundle);
                startActivity(intent1);
                finish();
            }
        });

        OutofElectricity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(WorkingActivity.this,PartnerList.class);
                bundle.putInt("serviceId", 4);
                intent1.putExtras(bundle);
                startActivity(intent1);
                finish();
            }
        });

        calltaxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(WorkingActivity.this,PartnerList.class);
                bundle.putInt("serviceId", 5);
                intent1.putExtras(bundle);
                startActivity(intent1);
                finish();
            }
        });

        lostkey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(WorkingActivity.this,PartnerList.class);
                bundle.putInt("serviceId", 6);
                intent1.putExtras(bundle);
                startActivity(intent1);
                finish();
            }
        });

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
                bundle = getIntent().getExtras();
                i = new Intent(WorkingActivity.this, ProfileActivity.class);
                i.putExtras(bundle);
                startActivity(i);
                break;
            case R.id.nav_home:
                bundle = getIntent().getExtras();
                Intent intent  = new Intent(this,MapActivity.class);
                intent.putExtras(bundle);
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
            case R.id.nav_payment:
                bundle = getIntent().getExtras();
                i = new Intent(WorkingActivity.this, ServiceActivity.class);
                i.putExtras(bundle);
                startActivity(i);
                break;

            case R.id.nav_notification:
                Intent intent1 = new Intent(WorkingActivity.this,PartnerList.class);
                startActivity(intent1);
                finish();
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