package com.example.enchantedkingdom.member.referfriend;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.enchantedkingdom.Constant;
import com.example.enchantedkingdom.R;
import com.example.enchantedkingdom.Utility;

import static com.example.enchantedkingdom.Utility.setFont;

public class ReferFriendActivity extends AppCompatActivity {

    private Context mContext = this;
    private TextView textHeader;
    private TextView referralCode;
    private TextView bottomMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refer_friend);
        initializeComponent();
    }

    private void initializeComponent(){
        textHeader = findViewById(R.id.text_header);
        referralCode = findViewById(R.id.referral_code);
        bottomMessage = findViewById(R.id.message_bot);

        textHeader.setTypeface(setFont(mContext,Constant.SIGNIKA_BOLD_FONT_PATH));
        referralCode.setTypeface(setFont(mContext,Constant.SIGNIKA_BOLD_FONT_PATH));
        bottomMessage.setTypeface(setFont(mContext,Constant.SIGNIKA_BOLD_FONT_PATH));
    }
}
