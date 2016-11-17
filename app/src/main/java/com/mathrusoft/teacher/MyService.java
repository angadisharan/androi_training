package com.mathrusoft.teacher;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by sharanangadi on 17/11/16.
 */

public class MyService extends Service {


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d("MYAPP", "Inside onStart onStartCommand");

        return Service.START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mIBinder;
    }

    public final IBinder mIBinder = new MyBinder();

    public class MyBinder extends Binder {
        public MyService getService() {
            return MyService.this;
        }
    }
}
