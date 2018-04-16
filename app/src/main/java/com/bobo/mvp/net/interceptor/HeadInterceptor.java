package com.bobo.mvp.net.interceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by bobo on 2018/3/10.
 */

public class HeadInterceptor implements Interceptor
{
    @Override
    public Response intercept(Chain chain) throws IOException
    {
        Request request=chain.request().newBuilder().addHeader("USERID","15").build();
        return chain.proceed(request);
    }
}