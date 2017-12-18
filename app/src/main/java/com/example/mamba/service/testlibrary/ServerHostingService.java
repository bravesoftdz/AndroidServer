package com.example.mamba.service.testlibrary;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.IOException;


public class ServerHostingService extends Service {
    private static final String TAG = "ServerHostingService";
    private MyLittleServer myLittleServer;

    @Override
    public void onCreate() {
        super.onCreate();
        try {
            myLittleServer = new MyLittleServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind");
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (myLittleServer != null){
            myLittleServer.stop();
        }
        Log.d(TAG, "onDestroy");
    }
}
