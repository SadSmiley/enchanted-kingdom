package com.example.enchantedkingdom.register;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

import com.example.enchantedkingdom.ApiClass;
import com.example.enchantedkingdom.Constant;
import com.example.enchantedkingdom.login.LoginActivity;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

import static com.example.enchantedkingdom.Constant.ENVIRONMENT;
import static com.example.enchantedkingdom.Constant.LOADING;
import static com.example.enchantedkingdom.Constant.REGISTER_URL_LIVE;
import static com.example.enchantedkingdom.Constant.REGISTER_URL_TEST;

public class RegisterDAO {

    public void register(final Context context, Button createAccount, RegisterVO vo){
        ApiClass api = new ApiClass();
        RequestParams param = new RequestParams();
        param.add("first_name",vo.getFirstName());
        param.add("last_name",vo.getLastName());
        param.add("address",vo.getAddress());
        param.add("email",vo.getEmail());
        param.add("password",vo.getPassword());
        param.add("birthday",vo.getBirthday());
        createAccount.setText(LOADING);
        api.postByUrl(ENVIRONMENT.equals("live") ? REGISTER_URL_LIVE : REGISTER_URL_TEST,param,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                if (null != response) {
                    if (statusCode == 200) {
                        context.startActivity(new Intent(context,LoginActivity.class));
                        ((Activity)context).finish();
                    }
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
            }
        });
    }
}
