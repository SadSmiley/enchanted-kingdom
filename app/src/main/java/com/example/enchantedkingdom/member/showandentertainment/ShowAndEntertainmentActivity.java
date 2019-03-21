package com.example.enchantedkingdom.member.showandentertainment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.enchantedkingdom.R;
import com.example.enchantedkingdom.globals.BottomNavigation;

public class ShowAndEntertainmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_and_entertainment);
        new BottomNavigation(this);
    }
}
