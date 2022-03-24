package com.monstertechno.loginsignupui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    private EditText txtname,txtusername,txtemail,txtpassword;
    private Button btnsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        setContentView(R.layout.activity_signup);

        txtname=findViewById(R.id.txt_name_sp);
        txtusername=findViewById(R.id.txt_un_sp);
        txtemail=findViewById(R.id.txt_email_sp);
        txtpassword=findViewById(R.id.txt_ps_sp);
        btnsignup=findViewById(R.id.btn_signUp);

        final SQLiteDatabase mydb=openOrCreateDatabase("electro", Context.MODE_PRIVATE,null);
        mydb.execSQL("create table if not exists user(name text,username text,email text,password text);");

        btnsignup.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


                // TODO Auto-generated method stub
                if (txtname.getText().toString().trim().length() == 0) {
                    txtname.setError("Name is not entered");
                    txtname.requestFocus();
                }
                else if(!txtname.getText().toString().matches("^[A-Za-z]+$"))
                {
                    txtname.setError("Accept only letters");
                    txtname.requestFocus();
                }

                else if (txtusername.getText().toString().trim().length() == 0) {
                    txtusername.setError("Username is not entered");
                    txtusername.requestFocus();
                }

                else if (txtemail.getText().toString().trim().length() == 0) {
                    txtemail.setError("Email is not entered");
                    txtemail.requestFocus();
                }

                else if(!txtemail.getText().toString().matches("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$"))
                {
                    txtemail.setError("Enter valid email address");
                    txtemail.requestFocus();
                }

                else if (txtpassword.getText().toString().trim().length() == 0) {
                    txtpassword.setError("Password is not entered");
                    txtpassword.requestFocus();
                } else {

                    String name, username, email, password, un, pw, na, em;

                    name = txtname.getText().toString();
                    username = txtusername.getText().toString();
                    email = txtemail.getText().toString();
                    password = txtpassword.getText().toString();

                    mydb.execSQL("insert into user(name,username,email,password) values('" + name + "','" + username + "','" + email + "','" + password + "');");

                    Cursor records = mydb.rawQuery("select name,username,email,password from user", null);
                    records.moveToFirst();
                    na = records.getString(0);
                    un = records.getString(1);
                    em = records.getString(2);
                    pw = records.getString(3);

                    if (na != null && un != null && em != null && pw != null) {
                        startActivity(new Intent(SignupActivity.this, MainActivity.class));
                        Toast.makeText(SignupActivity.this, "Register Success!", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(SignupActivity.this, "Register Fail", Toast.LENGTH_SHORT).show();
                    }
                    mydb.close();

                }
            }

        }

        );

    }
}
