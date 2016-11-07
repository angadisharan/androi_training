package com.mathrusoft.teacher;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * Created by sharanangadi on 07/11/16.
 */

public class ActivityAsyncTaskDemo extends AppCompatActivity {
    private static final String TAG = "AsynDemo";

    ProgressBar mProgressBar;
    Button mButton;

    Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_async_task_demo);

        mContext = this.getApplicationContext();

        mProgressBar = (ProgressBar) findViewById(R.id.progress);
        mButton = (Button) findViewById(R.id.show_demo);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MyAsyncTask().execute();
            }
        });

//        MyAsyncTask myAsyncTask = new MyAsyncTask();
//        myAsyncTask.execute();

    }


    class MyAsyncTask extends AsyncTask<Void, Integer, Integer> {

        @Override
        protected void onPreExecute() {
            Toast.makeText(mContext, "Download Started", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "Inside onPreExecute");
            super.onPreExecute();
        }

        @Override
        protected Integer doInBackground(Void... params) {
            Log.d(TAG, "Inside doInBackground");

            for (int i = 0; i < 10; i++) {
                doFakeWork();
                publishProgress(i);
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            mProgressBar.setProgress(values[0] * 10);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            Log.d(TAG, "Inside onPreExecute");

            Toast.makeText(mContext, R.string.download_completed, Toast.LENGTH_SHORT).show();

        }
    }

    private void doFakeWork() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
