package com.monstertechno.loginsignupui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserProfile extends AppCompatActivity {


    private TextView logout, name, username, email;
    private ImageView backUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        setContentView(R.layout.activity_main_up);

        logout = findViewById(R.id.txt_logout);
        backUp = findViewById(R.id.img_back_up);
        name = findViewById(R.id.txt_nm_up);
        username = findViewById(R.id.txt_un_up);
        email = findViewById(R.id.txt_email_up);

        final SQLiteDatabase mydb=openOrCreateDatabase("electro", Context.MODE_PRIVATE,null);

        String upName, upUname, upEmail;

    //Session can be introduced to select logged in user- Have to be implemented

        Cursor records = mydb.rawQuery("select name,username,email,password from user", null);
        records.moveToFirst();
        upName = records.getString(0);
        upUname = records.getString(1);
        upEmail = records.getString(2);

        records.close();

        name.setText(String.valueOf(upName));
        username.setText(String.valueOf(upUname));
        email.setText(String.valueOf(upEmail));



        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserProfile.this,MainActivity.class));
            }
        });

        backUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserProfile.this,MainActivity1.class));
            }
        });
    }
}
