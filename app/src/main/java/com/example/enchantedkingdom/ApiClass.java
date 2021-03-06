package com.example.enchantedkingdom;

import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;

public class ApiClass {

    private AsyncHttpClient client = new AsyncHttpClient();

    public void getByUrl(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(url, params, responseHandler);
    }
    public void postByUrl(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(url, params, responseHandler);

    }
    public void postByUrlHeader(Context context, String url, Header[] header, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(context,url,header,params,"multipart/form-data",responseHandler);

    }
    public void postByUrlHeaderLike(Context context,String url, Header[] header, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(context,url,header,params,"application/json",responseHandler);

    }
    public void getByUrlHeader(Context context,String url, Header[] header, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(context,url, header, params, responseHandler);
    }
    public void putByUrlHeader(Context context, String url, Header[] header, HttpEntity entity, AsyncHttpResponseHandler responseHandler) {
        client.put(context,url,header,entity,"application/json",responseHandler);

    }

    public void deleteByUrlHeader(Context context, String url, Header[] header, RequestParams params, AsyncHttpResponseHandler responseHandler){
        client.delete(context,url,header,params,responseHandler);
    }
}
