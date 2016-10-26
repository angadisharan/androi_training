package com.mathrusoft.teacher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by sharanangadi on 26/10/16.
 */
public class ActivityA extends Activity {

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
