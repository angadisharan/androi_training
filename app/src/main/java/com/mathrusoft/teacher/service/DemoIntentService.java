package com.mathrusoft.teacher.service;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by sharanangadi on 17/11/16.
 */

public class DemoIntentService extends IntentService {

    public DemoIntentService() {
        super("DemoIntentService");
    }

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public DemoIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        String name = intent.getStringExtra("NAME");
        int id = intent.getIntExtra("IS", -1);


        Toast.makeText(this, " Demo Intent Srvice started data : " + name + " id " + id, Toast.LENGTH_SHORT).show();


    }
}
