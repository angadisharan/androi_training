package com.mathrusoft.teacher;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by sharanangadi on 17/11/16.
 */

public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("");
    }

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public MyIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("MYAPP", "Inside Intent service onHandle");
    }
}
