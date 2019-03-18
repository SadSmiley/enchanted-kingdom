package com.example.enchantedkingdom.member.index;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.enchantedkingdom.R;

public class IndexActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        // Add Bottom Navigation
        addBottomNavigation();
    }

    private void addBottomNavigation() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.action_add:
                        Toast.makeText(IndexActivity.this, "Action Add Clicked", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.action_edit:
                        Toast.makeText(IndexActivity.this, "Action Edit Clicked", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.action_remove:
                        Toast.makeText(IndexActivity.this, "Action Remove Clicked", Toast.LENGTH_SHORT).show();
                        break;
                }

                return true;
            }
        });
    }
}
