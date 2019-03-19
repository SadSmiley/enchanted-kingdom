package com.example.enchantedkingdom.member.index;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.enchantedkingdom.R;
import com.example.enchantedkingdom.globals.BottomNavigation;
import com.example.enchantedkingdom.login.LoginActivity;
import com.example.enchantedkingdom.member.buyticket.BuyTicketActivity;
import com.example.enchantedkingdom.member.merchant.MerchantActivity;
import com.example.enchantedkingdom.member.referfriend.ReferFriendActivity;

import static com.example.enchantedkingdom.Constant.SIGNIKA_BOLD_FONT_PATH;
import static com.example.enchantedkingdom.SharedPreferences.save;
import static com.example.enchantedkingdom.Utility.setFont;

public class IndexActivity extends AppCompatActivity {

    private Context mContext = this;
    private TextView myAccount;
    private TextView merchants;
    private TextView referFriends;
    private TextView bookEvent;
    private TextView faq;
    private TextView settings;
    private TextView logout;
    private View root;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        initiateComponent();
    }

    private void initiateComponent(){
        new BottomNavigation(mContext);
        myAccount = findViewById(R.id.my_account);
        merchants = findViewById(R.id.merchants);
        referFriends = findViewById(R.id.refer_friends);
        bookEvent = findViewById(R.id.book_event);
        faq = findViewById(R.id.faq);
        settings = findViewById(R.id.settings);
        logout = findViewById(R.id.logout);

        myAccount.setTypeface(setFont(mContext,SIGNIKA_BOLD_FONT_PATH));
        merchants.setTypeface(setFont(mContext,SIGNIKA_BOLD_FONT_PATH));
        referFriends.setTypeface(setFont(mContext,SIGNIKA_BOLD_FONT_PATH));
        bookEvent.setTypeface(setFont(mContext,SIGNIKA_BOLD_FONT_PATH));
        faq.setTypeface(setFont(mContext,SIGNIKA_BOLD_FONT_PATH));
        settings.setTypeface(setFont(mContext,SIGNIKA_BOLD_FONT_PATH));
        logout.setTypeface(setFont(mContext,SIGNIKA_BOLD_FONT_PATH));

        merchants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext,MerchantActivity.class));
            }
        });
        referFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext,ReferFriendActivity.class));
            }
        });
        bookEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext,BuyTicketActivity.class));
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save("ACCESS_TOKEN","",mContext);
                save("USER_ID","",mContext);
                save("FULL_NAME","",mContext);
                save("BIRTHDAY","",mContext);
                save("EMAIL","",mContext);
                save("ADDRESS","",mContext);
                startActivity(new Intent(mContext,LoginActivity.class));
                finish();
            }
        });
    }
}
