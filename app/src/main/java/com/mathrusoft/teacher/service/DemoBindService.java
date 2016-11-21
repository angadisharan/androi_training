package com.mathrusoft.teacher.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by sharanangadi on 18/11/16.
 */

public class DemoBindService extends Service {

    public void performTask() {
        for (int i = 0; i < 100; i++) {
            Log.d("MYAPP", " from bound service" + i);
        }
    }

    private IBinder mIBinder = new MyBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mIBinder;
    }

    public class MyBinder extends Binder {
        public DemoBindService getService() {
            return DemoBindService.this;
        }
    }

}
