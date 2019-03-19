package com.example.enchantedkingdom.login;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.enchantedkingdom.Constant.INVALID_EMAIL;
import static com.example.enchantedkingdom.Constant.PLEASE_COMPLETE_INFORMATION;
import static com.example.enchantedkingdom.Utility.showNotificationArea;

import com.example.enchantedkingdom.R;
import com.example.enchantedkingdom.register.RegisterActivity;

public class LoginActivity extends AppCompatActivity
{
    private TextView signUp;
    private Context mContext = this;
    private EditText email;
    private EditText password;
    private TextView notificationArea;
    private Button signIn;
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
        email = findViewById(R.id.email_login);
        password = findViewById(R.id.password_login);
        signIn = findViewById(R.id.sign_in);
        notificationArea = findViewById(R.id.notification_area);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext,RegisterActivity.class));
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if("".equals(email.getText().toString()) &&
                        "".equals(password.getText().toString())){
                    showNotificationArea(notificationArea,PLEASE_COMPLETE_INFORMATION);
                }else if(!email.getText().toString().contains("@")){
                    showNotificationArea(notificationArea,INVALID_EMAIL);
                }else{
                    LoginVO vo = new LoginVO();
                    LoginDAO dao = new LoginDAO();
                    vo.setEmail(email.getText().toString());
                    vo.setPassword(password.getText().toString());
                    dao.login(mContext, vo,signIn,notificationArea);
                }
            }
        });
    }

}
