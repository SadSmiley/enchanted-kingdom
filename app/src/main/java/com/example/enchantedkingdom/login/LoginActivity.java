package com.example.enchantedkingdom.login;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.enchantedkingdom.R;
import com.example.enchantedkingdom.member.index.IndexActivity;
import com.example.enchantedkingdom.register.RegisterActivity;

public class LoginActivity extends AppCompatActivity
{
    private TextView signUp;
    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initializeComponent();
    }

    private void initializeComponent()
    {
        signUp = findViewById(R.id.sign_up);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext,RegisterActivity.class));
            }
        });
    }

}
