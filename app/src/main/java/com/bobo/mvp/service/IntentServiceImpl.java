package com.bobo.mvp.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;


/**
 * Created by bobo on 2018/3/20.
 */

public class IntentServiceImpl extends IntentService {

    private  int aaa=1;
    private Handler handler= new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.d("IntentServiceImpl","handleMessage");
        }
    };
    public IntentServiceImpl() {
        super("MyIntentService");
    }
    public IntentServiceImpl(String name) {
        super(name);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("IntentServiceImpl","onCreate");
        Log.d("IntentServiceImpl","onCreate,aaa="+aaa);
    }

    @Override
    protected void onHandleIntent(@Nullable final Intent intent) {

        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.d("IntentServiceImpl",intent.getAction());
                aaa=aaa+1;
                Log.d("IntentServiceImpl",(aaa)+"");
                handler.sendEmptyMessage(1);
            }
        }.start();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("IntentServiceImpl","onDestroy");
    }
}
