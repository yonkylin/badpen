package com.example.badpen;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Administrator on 2017/2/17.
 */

public class AlarmReceiver extends BroadcastReceiver {
    private Intent mIntent = null ;
    private PendingIntent mPendingIntent = null;
    private Notification mNotification = null;
    private NotificationManager mNotificationManager = null;

    @Override
    public void onReceive(Context context , Intent intent){
        Log.e("AndroidBWL", "AlarmReceiver:onReceive");
        mIntent = intent;
        Bundle bundle = mIntent.getExtras();
        mNotificationManager =(NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        mIntent.setClass(context , AddBwlActivity.class);

        mPendingIntent =PendingIntent.getActivity(context,0,mIntent,0);
        mNotification= new Notification.Builder(context)
                .setTicker("烂笔头")
                .setContentTitle(bundle.getString("title"))
                .setContentText(bundle.getString("content"))
                .setContentIntent(mPendingIntent)
                .setAutoCancel(true)
                .build();

        //设置默认声音、默认振动，和默认闪光灯
        mNotification.defaults=Notification.DEFAULT_ALL;
        mNotificationManager.notify(1,mNotification);
    }
}














