package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Database.Object.User;
import com.example.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChangePassWord extends AppCompatActivity {

    @BindView((R.id.edt_oldPass))
    EditText old_pass;

    @BindView(R.id.edt_NewPass1)
    EditText newPass;

    @BindView(R.id.edt_NewPass2)
    EditText newPass2;

    @BindView(R.id.btn_savePass)
    Button bth_changePass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pass_word);

        ButterKnife.bind(this);

        bth_changePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String oldPass = old_pass.getText().toString();
                String newPass1 = newPass.getText().toString();
                String newPass12 = newPass2.getText().toString();

                if (oldPass.equals(""))
                {
                    Toast.makeText(ChangePassWord.this, "Password Required 1",Toast.LENGTH_SHORT).show();
                }
                else if (newPass1.equals(""))
                {
                    Toast.makeText(ChangePassWord.this, "Password Required 2",Toast.LENGTH_SHORT).show();
                }
                else if(newPass12.equals(""))
                {
                    Toast.makeText(ChangePassWord.this, "Password Required 3",Toast.LENGTH_SHORT).show();
                }
                else if (!newPass1.equals(newPass12))
                {
                    Toast.makeText(ChangePassWord.this, "New password must be the same",Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = getIntent();
                    Bundle bundle = intent.getExtras();

                    String usename = bundle.getString("username");
                    User user1 = LoginActivity.myAppDatabase.myDAO().getUserByUsName(usename);

                    if (!oldPass.equals(user1.getUserPassword()))
                    {
                        Toast.makeText(ChangePassWord.this, user1.getUserPassword(),Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        LoginActivity.myAppDatabase.myDAO().updatePassword(usename, newPass.getText().toString());
                        Toast.makeText(ChangePassWord.this, "Change password success",Toast.LENGTH_SHORT).show();
                    }


                }
            }
        });
    }
}
