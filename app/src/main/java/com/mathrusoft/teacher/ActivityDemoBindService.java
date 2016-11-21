package com.mathrusoft.teacher;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.mathrusoft.teacher.service.DemoBindService;

/**
 * Created by sharanangadi on 18/11/16.
 */

public class ActivityDemoBindService extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this.getApplicationContext(), DemoBindService.class);
        bindService(intent, mServiceConnection2, BIND_AUTO_CREATE);
    }

    DemoBindService mDemoBindService;

    boolean isServiceConnected;


    ServiceConnection mServiceConnection2 = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            DemoBindService.MyBinder myBinder = (DemoBindService.MyBinder) binder;

            DemoBindService demoBindService = myBinder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };


    ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            DemoBindService.MyBinder myBinder = (DemoBindService.MyBinder) binder;

            isServiceConnected = true;
            Log.d("MYAPP", " inside onService Connected ");

            mDemoBindService = myBinder.getService();

            mDemoBindService.performTask();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mDemoBindService = null;
            isServiceConnected = false;

            Log.d("MYAPP", " inside onService dis Connected ");

        }
    };


    @Override
    protected void onResume() {
        super.onResume();

        Intent intent = new Intent(this.getApplicationContext(), DemoBindService.class);
        bindService(intent, mServiceConnection, BIND_AUTO_CREATE);
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (isServiceConnected) {
            unbindService(mServiceConnection);
        }
    }
}
