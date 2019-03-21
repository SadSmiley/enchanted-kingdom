package com.example.enchantedkingdom.globals;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.enchantedkingdom.R;
import com.example.enchantedkingdom.member.index.IndexActivity;
import com.example.enchantedkingdom.member.parkmap.ParkMapActivity;
import com.example.enchantedkingdom.register.RegisterActivity;

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
                        Toast.makeText(context, "Action Home Clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_map:
                        context.startActivity(new Intent(context, ParkMapActivity.class));
                        break;
                    case R.id.action_ticket:
                        Toast.makeText(context, "Action Ticket Clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_calendar:
                        Toast.makeText(context, "Action Cakendar Clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_wand:
                        Toast.makeText(context, "Action Wand Clicked", Toast.LENGTH_SHORT).show();
                        break;
                }

                return true;
            }
        });
    }
}
