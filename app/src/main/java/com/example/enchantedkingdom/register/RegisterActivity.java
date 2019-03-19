package com.example.enchantedkingdom.register;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.enchantedkingdom.Constant.INVALID_DATE;
import static com.example.enchantedkingdom.Constant.INVALID_EMAIL;
import static com.example.enchantedkingdom.Constant.PASSWORD_NOT_MATCH;
import static com.example.enchantedkingdom.Utility.isValidBirthday;
import static com.example.enchantedkingdom.Utility.showNotificationArea;

import com.example.enchantedkingdom.R;

public class RegisterActivity extends AppCompatActivity {
    private EditText firstName;
    private EditText lastName;
    private EditText email;
    private EditText birthday;
    private EditText address;
    private EditText password;
    private EditText rePassword;
    private TextView notificationArea;
    private Button createAccount;
    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initializeComponent();
    }

    private void initializeComponent(){
        firstName = findViewById(R.id.first_name);
        lastName = findViewById(R.id.last_name);
        email = findViewById(R.id.email);
        birthday = findViewById(R.id.birthday);
        address = findViewById(R.id.address);
        password = findViewById(R.id.password);
        rePassword = findViewById(R.id.re_type_password);
        createAccount = findViewById(R.id.create_account);
        notificationArea = findViewById(R.id.notification_area);

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!"".equals(firstName.getText().toString()) &&
                        !"".equals(lastName.getText().toString()) &&
                        !"".equals(email.getText().toString()) &&
                        !"".equals(birthday.getText().toString()) &&
                        !"".equals(address.getText().toString()) &&
                        !"".equals(password.getText().toString())){
                    if(!email.getText().toString().contains("@")){
                        showNotificationArea(notificationArea,INVALID_EMAIL);
                    }
                    else if(!password.getText().toString().equals(rePassword.getText().toString())){
                       showNotificationArea(notificationArea,PASSWORD_NOT_MATCH);
                    }else if(isValidBirthday(birthday.getText().toString())){
                        showNotificationArea(notificationArea,INVALID_DATE);
                    }else{
                        RegisterDAO dao = new RegisterDAO();
                        RegisterVO vo = new RegisterVO();
                        vo.setFirstName(firstName.getText().toString());
                        vo.setLastName(lastName.getText().toString());
                        vo.setAddress(address.getText().toString());
                        vo.setBirthday(birthday.getText().toString());
                        vo.setEmail(email.getText().toString());
                        vo.setPassword(password.getText().toString());
                        dao.register(mContext,createAccount,vo);
                    }
                }
            }
        });
    }

}
