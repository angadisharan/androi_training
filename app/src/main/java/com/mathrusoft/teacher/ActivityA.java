package com.mathrusoft.teacher;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by sharanangadi on 26/10/16.
 */
public class ActivityA extends AppCompatActivity {

    private static final String TAG = "Demo_ActivityA";

    private Button mButtonLaunchB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "Inside onCreate");

        setContentView(R.layout.activity_a);
        mButtonLaunchB = (Button) findViewById(R.id.button_launch_activity_b);

        mButtonLaunchB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityA.this, ActivityB.class);
                ActivityA.this.startActivity(intent);
            }
        });

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_holder, new MyFragment());
        fragmentTransaction.commit();
    }



    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Inside onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "Inside onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Inside onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Inside onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Inside onDestroy");
    }

}
