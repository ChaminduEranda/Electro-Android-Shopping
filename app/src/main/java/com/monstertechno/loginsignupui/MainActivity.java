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
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtusernamesn, txtpasswordsn;
    private Button btnSignIn;
    private TextView txtSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        setContentView(R.layout.activity_main);

        txtusernamesn=findViewById(R.id.txt_userN);
        txtpasswordsn=findViewById(R.id.txt_pw);
        btnSignIn = findViewById(R.id.btn_signIn);
        txtSignUp = findViewById(R.id.txt_signup);


        final SQLiteDatabase mydb=openOrCreateDatabase("electro", Context.MODE_PRIVATE,null);

        btnSignIn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                if (txtusernamesn.getText().toString().trim().length() == 0) {
                    txtusernamesn.setError("Username is not entered");
                    txtusernamesn.requestFocus();
                }
                else if (txtpasswordsn.getText().toString().trim().length() == 0) {
                    txtpasswordsn.setError("Password is not entered");
                    txtpasswordsn.requestFocus();
                } else {


                    String uname, pword, un, pw;

                    uname = txtusernamesn.getText().toString();
                    pword = txtpasswordsn.getText().toString();

                    Cursor records = mydb.rawQuery("select name,username,email,password from user where username='" + uname + "' and password='" + pword + "'", null);
                    records.moveToFirst();
                    un = records.getString(1);
                    pw = records.getString(3);

                    if (un != null && pw != null) {
                        startActivity(new Intent(MainActivity.this, MainActivity1.class));
//                        Intent intent = new Intent(MainActivity.this,UserProfile.class);
//                        intent.putExtra("username",un);
                    } else {
                        Toast.makeText(MainActivity.this, "Login Fail", Toast.LENGTH_SHORT).show();
                    }


                    mydb.close();




                }
            }
        });

        txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SignupActivity.class));
            }
        });

    }


}
