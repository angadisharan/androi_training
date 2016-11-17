package com.mathrusoft.teacher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by sharanangadi on 26/10/16.
 */
public class ActivityB extends Activity {

    private static final String TAG = "Demo_ActivityB";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "Inside onCreate");
        setContentView(R.layout.activity_b);


        Intent intent = getIntent();
        Toast.makeText(this, intent.getStringExtra("NAME") + " id " + intent.getIntExtra("ID", -11),
                Toast.LENGTH_SHORT).show();

    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
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
