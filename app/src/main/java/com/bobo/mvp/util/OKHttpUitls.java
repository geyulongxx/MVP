package com.bobo.mvp.util;

import android.util.Log;

import com.bobo.mvp.net.interceptor.HeadInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by bobo on 2018/3/10.
 */

public class OKHttpUitls {
    private static OkHttpClient mOkHttpClient;
    private final static HttpLoggingInterceptor HTTP_LOGGING_INTERCEPTOR =
            new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY);

    /**
     * 因为设置了读写超时，该client不适用于上传和下载
     */
    public static OkHttpClient get() {
        if (mOkHttpClient == null) {
            mOkHttpClient = new OkHttpClient.Builder()
                    //log 拦截器
                    .addInterceptor(new HeadInterceptor())
                    .addInterceptor(HTTP_LOGGING_INTERCEPTOR)
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .build();
        }
        return mOkHttpClient;
    }
}
