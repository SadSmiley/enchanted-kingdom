package com.example.enchantedkingdom.member.merchant;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.enchantedkingdom.Constant;
import com.example.enchantedkingdom.R;
import com.example.enchantedkingdom.globals.BottomNavigation;

import static com.example.enchantedkingdom.Constant.SIGNIKA_BOLD_FONT_PATH;
import static com.example.enchantedkingdom.Utility.setFont;

public class MerchantActivity extends AppCompatActivity {

    private TextView textHeader;
    private Context mContext = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant);
        initializeComponent();
    }


    private void initializeComponent(){
        new BottomNavigation(mContext);
        textHeader = findViewById(R.id.text_header);
        textHeader.setTypeface(setFont(mContext,SIGNIKA_BOLD_FONT_PATH));
    }

}
