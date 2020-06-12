package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.Database.Object.Service;
import com.example.myapplication.Database.Object.User;
import com.example.myapplication.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.btn_register)
    Button btnRegister;

    @BindView(R.id.edt_create_new)
    EditText edtCreateUsername;

    @BindView(R.id.edt_password_new)
    EditText edtPassone;

    @BindView(R.id.edt_password_again)
    EditText edtPasstwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_);

        ButterKnife.bind(this);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user,pass1,pass2;
                user = edtCreateUsername.getText().toString();
                pass1 = edtPassone.getText().toString();
                pass2 = edtPasstwo.getText().toString();

                if(user.equals(""))
                {
                    Toast.makeText(RegisterActivity.this, "Username Required",Toast.LENGTH_SHORT).show();
                }
                else if (pass1.equals(""))
                {
                    Toast.makeText(RegisterActivity.this, "Password Required",Toast.LENGTH_SHORT).show();
                }
                else if(pass2.equals(""))
                {
                    Toast.makeText(RegisterActivity.this, "Password Required",Toast.LENGTH_SHORT).show();
                }
                else if (!pass1.equals(pass2))
                {
                    Toast.makeText(RegisterActivity.this, "Password must be the same",Toast.LENGTH_SHORT).show();
                }
                else {
                    // save data to dbaa
                    User user1 = new User();
                    user1.setUserName(user);
                    user1.setUserPassword(pass1);
                    //user1.setEmail(mail);
                    LoginActivity.myAppDatabase.myDAO().addUser(user1);
                    Toast.makeText(RegisterActivity.this, "Register success",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(i);
                    finish();

                }
            }
        }
        );
    }


    protected void onDestroy() {
        ButterKnife.bind(this).unbind();
        super.onDestroy();
    }
}
