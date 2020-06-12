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

public class UpdateProfile extends AppCompatActivity {

    @BindView(R.id.tvHelloUser)
    TextView Username;

    @BindView(R.id.edt_tvEmail)
    EditText Email;

    @BindView(R.id.edt_tvAddress)
    EditText address;

    @BindView(R.id.edt_tvPhone)
    EditText phone;

    @BindView(R.id.edt_tvShowUs)
    EditText fullName;

    @BindView(R.id.btnSaveUpdate)
    Button btnSaveUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String usename = bundle.getString("username");
        User user1 = LoginActivity.myAppDatabase.myDAO().getUserByUsName(usename);

        btnSaveUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailChange = Email.getText().toString();
                String phoneChange = phone.getText().toString();
                String addressChange = address.getText().toString();
                String fullNameChange = fullName.getText().toString();

                User userUpdate = new User();

                userUpdate.setUserName(user1.getUserName());
                userUpdate.setUserPassword(user1.getUserPassword());
                userUpdate.setEmail(emailChange);
                userUpdate.setPhoneNum(phoneChange);
                userUpdate.setUserAddress(addressChange);
                userUpdate.setFullName(fullNameChange);
                userUpdate.setDateOfBirth("");
                userUpdate.setGender("");
                userUpdate.setCreditPoint("");
                userUpdate.setId(user1.getId());

                LoginActivity.myAppDatabase.myDAO().updateUser(userUpdate);

                Toast.makeText(UpdateProfile.this, "Update successfully",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
