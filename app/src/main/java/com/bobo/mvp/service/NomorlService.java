package com.bobo.mvp.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by bobo on 2018/3/20.
 */

public class NomorlService extends Service {
    private  int aaa=1;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("NomorlService","onCreate");
        Log.d("NomorlService","onCreate,aaa="+aaa);
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d("NomorlService",intent.getAction());
        aaa=aaa+1;
        Log.d("NomorlService",(aaa)+"");
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("NomorlService","onDestroy");
    }
}
