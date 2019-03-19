package com.example.enchantedkingdom.member.index;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.enchantedkingdom.R;
import com.example.enchantedkingdom.globals.BottomNavigation;

public class IndexActivity extends AppCompatActivity {

    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        // Add Bottom Navigation
        new BottomNavigation(mContext);
    }
}
