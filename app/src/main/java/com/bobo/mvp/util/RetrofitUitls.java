package com.bobo.mvp.util;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by bobo on 2018/3/10.
 */

public class RetrofitUitls {

    private static Retrofit mRetrofit;

    public static Retrofit get() {
        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(ServerUrl.BASE_SERVER)
                    .client(OKHttpUitls.get())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return mRetrofit;
    }

    public static <T> T get(Class<T> tClass) {
        return get().create(tClass);
    }
}
