package com.example.myapplication.activities;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.myapplication.Database.Controller.MyAppDatabase;
import com.example.myapplication.Database.Object.User;
import com.example.myapplication.R;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.user)
    EditText edtUsername;

    @BindView(R.id.password)
    EditText edtPassword;

    @BindView(R.id.btn_login)
    Button btnLogin;

    @BindView(R.id.sign_up)
    TextView TevSignup;

    public static MyAppDatabase myAppDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideStatusBar();
        setContentView(R.layout.activity_login);

        myAppDatabase = Room.databaseBuilder(getApplicationContext(),MyAppDatabase.class,"users").allowMainThreadQueries().build();
        ButterKnife.bind(this);

        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String user,pass, mail;
                user = edtUsername.getText().toString();
                pass = edtPassword.getText().toString();
                User user1 = myAppDatabase.myDAO().getUser(user,pass);
                if(user.equals(""))
                {
                    Toast.makeText(LoginActivity.this, "Username Required",Toast.LENGTH_SHORT).show();
                }
                else if (pass.equals(""))
                {
                    Toast.makeText(LoginActivity.this, "Password Required",Toast.LENGTH_SHORT).show();
                }
                else if (user1 != null)
                {
                    Intent i = new Intent(LoginActivity.this,MapActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    Bundle bundle = new Bundle();
                    bundle.putString("username",user.toString());
                    i.putExtras(bundle);
                    startActivity(i);
                    finish();
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "User name or password incorrect",Toast.LENGTH_SHORT).show();
                }
            }
        });
        TevSignup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this,ServiceActivity.class);
                startActivity(i);
                finish();
            }
        });

        TevSignup.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
                finish();
            }
        });

    }

    public  void hideStatusBar()
    {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }


    @Override
    protected void onDestroy() {
        ButterKnife.bind(this).unbind();
        super.onDestroy();
    }
}
