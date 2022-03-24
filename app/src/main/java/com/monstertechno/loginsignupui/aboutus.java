package com.monstertechno.loginsignupui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class aboutus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
        Element adsElement = new Element();
        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setImage(R.drawable.aboutus_img)
                .setDescription("Welcome to Electro, your number one source for Electronics Items.We're dedicated to giving you the \n" +
                                "very best of Electronics Items, with a focus on dependability, customer service and uniqueness.\n" +
                                "Founded in 2022, Electro has come a long way from its beginnings in a Home Office.When store is\n" +
                                "first started out, Our passion for providing the best Electronics Items for our Customers.We now  \n" +
                                "serve customers all over the world, and are thrilled to be a part of the fair trade wing of the" +
                                "Electronics industry.We hope you enjoy our products as much as we  enjoy offering them to you.\n" +
                                "If you have any questions or comments, please don't hesitate to contact us.\n" +
                                "\n" +
                                "Sincerely,\n" +
                                 "Electro Team.")
                .addItem(new Element().setTitle("Version 1.0"))
                .addGroup("CONNECT WITH US!")
                .addEmail("inuksha.ph@gmail.com")
                .addWebsite("Your website/")
                .addFacebook("iii")
                .addYoutube("UCSMCcca90GqHdsASv5HXkFw")
                .addPlayStore("com.example.yourprojectname")
                .addInstagram("Inuksha_Prabhash")
                .addGitHub("abcd")
                .addItem(createCopyright())
                .create();
        setContentView(aboutPage);
    }
    private Element createCopyright()
    {
        Element copyright = new Element();
        @SuppressLint("DefaultLocale") final String copyrightString = String.format("Copyright %d by Electro", Calendar.getInstance().get(Calendar.YEAR));
        copyright.setTitle(copyrightString);
        // copyright.setIcon(R.mipmap.ic_launcher);
        copyright.setGravity(Gravity.CENTER);
        copyright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(aboutus.this,copyrightString,Toast.LENGTH_SHORT).show();
            }
        });
        return copyright;
    }
}