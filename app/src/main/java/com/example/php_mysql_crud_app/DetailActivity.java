package com.example.php_mysql_crud_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView tvId, tvName, tvEmail, tvContact, tvAddress;
    int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvId = findViewById(R.id.detail_txt_id);
        tvName = findViewById(R.id.detail_txt_name);
        tvEmail = findViewById(R.id.detail_email_id);
        tvContact = findViewById(R.id.detail_txt_contact);
        tvAddress = findViewById(R.id.detail_txt_address);

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        tvId.setText("ID: "+MainActivity.employeeArrayList.get(position).getId());
        tvName.setText("Name: "+MainActivity.employeeArrayList.get(position).getName());
        tvEmail.setText("Email: "+MainActivity.employeeArrayList.get(position).getEmail());
        tvContact.setText("Contact: "+MainActivity.employeeArrayList.get(position).getContact());
        tvAddress.setText("Address: "+MainActivity.employeeArrayList.get(position).getAddress());


    }
}
