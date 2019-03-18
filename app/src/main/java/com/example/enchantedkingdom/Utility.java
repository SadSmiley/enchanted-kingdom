package com.example.enchantedkingdom;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Utility {

    public static boolean isValidBirthday(String birthday) {
        boolean accepted;
        final SimpleDateFormat BIRTHDAY_FORMAT_PARSER = new SimpleDateFormat("MM-dd-yyyy");
        Calendar calendar = Calendar.getInstance();
        BIRTHDAY_FORMAT_PARSER.setLenient(false);
        try {
            calendar.setTime(BIRTHDAY_FORMAT_PARSER.parse(birthday));
            accepted = true;
        } catch (Exception e) {
            accepted = false;
        }
        return accepted;
    }

    public static void showNotificationArea(final TextView textView, String message){
        textView.setVisibility(View.VISIBLE);
        textView.setText(message);
        new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                textView.setVisibility(View.GONE);
            }
        }.start();
    }
}
