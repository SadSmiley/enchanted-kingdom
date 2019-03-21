package com.example.enchantedkingdom.member.buyticket;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.enchantedkingdom.R;
import com.example.enchantedkingdom.globals.BottomNavigation;

public class BuyTicketCalendar extends AppCompatActivity {
    private ImageView calendarHolder;
    private Context mContext = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_ticket_calendar);
        new BottomNavigation(this);
        calendarHolder = findViewById(R.id.calendar_holder);
        calendarHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext,BuyTicketActivity.class));
            }
        });
    }
}
