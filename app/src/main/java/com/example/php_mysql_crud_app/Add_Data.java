package com.example.php_mysql_crud_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Add_Data extends AppCompatActivity {

    EditText nameET, emailET, contactET, addressET;
    Button btn_insert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__data);

        nameET = findViewById(R.id.edtName);
        emailET = findViewById(R.id.edtEmail);
        contactET = findViewById(R.id.edtContact);
        addressET = findViewById(R.id.edtAddress);

        btn_insert = findViewById(R.id.btnAddData);

        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                insertData();

                nameET.setText("");
                emailET.setText("");
                contactET.setText("");
                addressET.setText("");
                
            }
        });

    }


    private void insertData() {

        final String name = nameET.getText().toString().trim();
        final String email = emailET.getText().toString().trim();
        final String contact = contactET.getText().toString().trim();
        final String address = addressET.getText().toString().trim();

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");

        if(name.isEmpty()) {
            Toast.makeText(this, "Enter Name please", Toast.LENGTH_SHORT).show();
            return;
        }
       else if(email.isEmpty()) {
            Toast.makeText(this, "Enter Email please", Toast.LENGTH_SHORT).show();
            return;
        }
       else if(contact.isEmpty()) {
            Toast.makeText(this, "Enter Contact please", Toast.LENGTH_SHORT).show();
            return;
        }
       else if(address.isEmpty()) {
            Toast.makeText(this, "Enter Address please", Toast.LENGTH_SHORT).show();
            return;
        } else {

           progressDialog.show();

           String url = "https://php-mysql-android-crud.000webhostapp.com/insert.php";
            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    if(response.equalsIgnoreCase("Data Inserted")) {
                        Toast.makeText(Add_Data.this, "Data Inserted Properly", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();

                    }
                    else {

                        Toast.makeText(Add_Data.this, response.toString(), Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();

                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(Add_Data.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }
            ){

                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String,String> params = new HashMap<String,String>();

                    params.put("name", name);
                    params.put("email", email);
                    params.put("contact", contact);
                    params.put("address", address);

                    return params;

                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(Add_Data.this);
            requestQueue.add(request);


        }

    }

}
