package com.example.enchantedkingdom.member.home;

import android.content.Intent;
import android.net.Uri;
import android.provider.Browser;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.enchantedkingdom.R;
import com.example.enchantedkingdom.globals.BottomNavigation;

public class HomeActivity extends AppCompatActivity {
    private ImageView theMagicCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        new BottomNavigation(this);
        theMagicCard = findViewById(R.id.magic_card);
        theMagicCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.enchantedkingdom.ph"));
                intent.putExtra(Browser.EXTRA_APPLICATION_ID, getPackageName());
                startActivity(intent);
            }
        });
    }
}
