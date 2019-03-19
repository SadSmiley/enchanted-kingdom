package com.example.enchantedkingdom.globals;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.enchantedkingdom.R;
import com.example.enchantedkingdom.member.index.IndexActivity;

public class BottomNavigation extends BottomNavigationView {

    public BottomNavigation(final Context context)
    {
        super(context);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.action_home:
                        Toast.makeText(context, "Action Home Clicked", Toast.LENGTH_SHORT).show();
                        break;
                }

                return true;
            }
        });
    }
}
