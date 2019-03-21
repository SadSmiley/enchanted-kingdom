package com.example.enchantedkingdom.member.myprofile;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.enchantedkingdom.Constant;
import com.example.enchantedkingdom.R;
import com.example.enchantedkingdom.SharedPreferences;
import com.example.enchantedkingdom.globals.BottomNavigation;

import static com.example.enchantedkingdom.Constant.SIGNIKA_BOLD_FONT_PATH;
import static com.example.enchantedkingdom.Utility.setFont;

public class MyProfileActivity extends AppCompatActivity {

    private TextView name;
    private TextView birthday;
    private TextView email;
    private TextView address;

    private TextView membershipId;
    private TextView expirationDate;
    private TextView magicPoints;

    private Context mContext = this;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        initializeComponent();
    }

    public void initializeComponent(){
        new BottomNavigation(mContext);
        name = findViewById(R.id.name);
        birthday = findViewById(R.id.birthdate);
        email = findViewById(R.id.email);
        address = findViewById(R.id.address);
        membershipId = findViewById(R.id.membership_id);
        expirationDate = findViewById(R.id.expiration_date);
        magicPoints = findViewById(R.id.magic_point);

        name.setTypeface(setFont(mContext,SIGNIKA_BOLD_FONT_PATH));
        birthday.setTypeface(setFont(mContext,SIGNIKA_BOLD_FONT_PATH));
        email.setTypeface(setFont(mContext,SIGNIKA_BOLD_FONT_PATH));
        address.setTypeface(setFont(mContext,SIGNIKA_BOLD_FONT_PATH));
        membershipId.setTypeface(setFont(mContext,SIGNIKA_BOLD_FONT_PATH));
        expirationDate.setTypeface(setFont(mContext,SIGNIKA_BOLD_FONT_PATH));
        magicPoints.setTypeface(setFont(mContext,SIGNIKA_BOLD_FONT_PATH));

        name.setText(SharedPreferences.getString("FULL_NAME",mContext));
        birthday.setText(SharedPreferences.getString("BIRTHDAY",mContext));
        email.setText(SharedPreferences.getString("EMAIL",mContext));
        address.setText(SharedPreferences.getString("ADDRESS",mContext));

        membershipId.setText("EK20190411");
        expirationDate.setText("January 21, 2025");
        magicPoints.setText("3,500 EK Points");
    }
}
