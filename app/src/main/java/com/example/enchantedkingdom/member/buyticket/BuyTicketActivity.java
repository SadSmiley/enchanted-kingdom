package com.example.enchantedkingdom.member.buyticket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.enchantedkingdom.R;
import com.example.enchantedkingdom.globals.BottomNavigation;

public class BuyTicketActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_ticket);
        new BottomNavigation(this);
    }
}
