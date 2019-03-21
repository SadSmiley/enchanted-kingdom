package com.example.enchantedkingdom.globals;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.example.enchantedkingdom.R;
import com.example.enchantedkingdom.member.buyticket.BuyTicketCalendar;
import com.example.enchantedkingdom.member.index.IndexActivity;
import com.example.enchantedkingdom.member.merchant.MerchantActivity;
import com.example.enchantedkingdom.member.showandentertainment.ShowAndEntertainmentActivity;
import com.example.enchantedkingdom.member.parkmap.ParkMapActivity;

public class BottomNavigation extends BottomNavigationView {

    public BottomNavigation(final Context context)
    {
        super(context);

        BottomNavigationView bottomNavigationView = ((Activity)context).findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.action_home:
                        context.startActivity(new Intent(context,MerchantActivity.class));
                        break;
                    case R.id.action_map:
                        context.startActivity(new Intent(context, ParkMapActivity.class));
                        break;
                    case R.id.action_ticket:
                        context.startActivity(new Intent(context,BuyTicketCalendar.class));
                        break;
                    case R.id.action_calendar:
                        context.startActivity(new Intent(context,ShowAndEntertainmentActivity.class));
                        break;
                    case R.id.action_wand:
                        context.startActivity(new Intent(context,IndexActivity.class));
                        break;
                }

                return true;
            }
        });
    }
}
