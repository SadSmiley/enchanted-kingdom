package com.example.enchantedkingdom.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.Toast;

import com.example.enchantedkingdom.ApiClass;
import com.example.enchantedkingdom.MainActivity;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.message.BasicHeader;

import static com.example.enchantedkingdom.Constant.LOGGING_IN;
import static com.example.enchantedkingdom.SharedPreferences.*;
import static com.example.enchantedkingdom.Constant.API_KEY;
import static com.example.enchantedkingdom.Constant.LOGIN_URL_TEST;
import static com.example.enchantedkingdom.Constant.USER_INFORMATION;

public class LoginDAO {

    public void login(final Context context , LoginVO vo, Button login){
        ApiClass api = new ApiClass();
        RequestParams params = new RequestParams();
        params.add("username", vo.getEmail());
        params.add("password", vo.getPassword());
        params.put("client_secret", API_KEY);
        params.put("client_id", 2);
        params.put("grant_type", "password");
//        login.setText(LOGGING_IN);
//        login.setEnabled(false);
        api.postByUrl(LOGIN_URL_TEST,params,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONObject serverResp = new JSONObject(response.toString());
                    String accessToken = serverResp.getString("token_type") + " " + serverResp.getString("access_token");
                    userInformation(context,accessToken);
//                    loading.hideLoading();
                } catch (JSONException e) {
                    e.printStackTrace();
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

    private void userInformation(final Context context, final String accessToken) {
        ApiClass api = new ApiClass();
        RequestParams rp = new RequestParams();
        rp.put("Authorization", accessToken);
        List<Header> headers = new ArrayList<Header>();
        headers.add(new BasicHeader("Authorization", accessToken));
        api.getByUrlHeader(context, USER_INFORMATION,
                headers.toArray(new Header[headers.size()])
                , rp,
                new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        try {
                            JSONObject serverResp = new JSONObject(response.toString());
                            JSONObject user_information = serverResp.getJSONObject("user_information");

                            String email = serverResp.getString("email");
                            String fullName = serverResp.getString("name");
                            String userId = user_information.getString("user_id");
                            String birthday = user_information.getString("birthday");
                            String address = user_information.getString("address");

                            save("ACCESS_TOKEN",accessToken,context);
                            save("USER_ID",userId,context);
                            save("FULL_NAME",fullName,context);
                            save("BIRTHDAY",birthday,context);
                            save("EMAIL",email,context);
                            save("ADDRESS",address,context);

                            context.startActivity(new Intent(context, MainActivity.class));
                            ((Activity)context).finish();

//                            String crypt = serverResp.getString("crypt");
//                            String facebookKey = serverResp.getString("facebook_key");
//                            String googleKey = serverResp.getString("google_key");
//                            String twitterKey = serverResp.getString("twitter_key");
//                            String decrypt = serverResp.getString("decrypt");
//                            vo.setFullName(fullName);
//                            vo.setUserID(userId);
//                            vo.setEmail(email);
//
//                            save("FULL_NAME", vo.getFullName(), mContext);
//                            save("USER_ID", vo.getUserID(), mContext);
//                            save("EMAIL", vo.getEmail(), mContext);
//                            save("ACCESS_TOKEN",accessToken,mContext);
//                            save("CRYPT",crypt,mContext);
//                            save("FB_KEY",facebookKey,mContext);
//                            save("GOOGLE_KEY",googleKey,mContext);
//                            save("TWITTER_KEY",twitterKey,mContext);
//                            save("DECRYPT",decrypt,mContext);
//
//                            util.hideLoading();
//                            mContext.startActivity(new Intent(mContext, ActivityHome.class));
//                            activity.finish();

                        } catch (JSONException e) {
                            e.printStackTrace();
//                            util.hideLoading();
                        }
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                        if (null != errorResponse) {
                            JSONObject error = null;
                            try {
                                error = new JSONObject(errorResponse.toString());
//                                if (error.has("message")) {
//                                    Toast.makeText(mContext, error.getString("message"), Toast.LENGTH_LONG).show();
//                                } else {
//                                    Toast.makeText(mContext, error.getString("error"), Toast.LENGTH_LONG).show();
//                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
    }
}
