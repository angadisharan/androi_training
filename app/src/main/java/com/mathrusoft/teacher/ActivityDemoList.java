package com.mathrusoft.teacher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.mathrusoft.teacher.adapter.AdapterDemo;
import com.mathrusoft.teacher.model.Status;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharanangadi on 09/11/16.
 */

public class ActivityDemoList extends AppCompatActivity {

    private ListView mListView;

    List<Status> mStatuses = new ArrayList<>();
    AdapterDemo mAdapterDemo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_list);

        mListView = (ListView) findViewById(R.id.list);

        initDummmyData();


        mAdapterDemo = new AdapterDemo(this, -1, mStatuses);
        mListView.setAdapter(mAdapterDemo);

//        String names[] = {
//                "Android", "ios", "Symbian1",
//                "Android1", "ios2", "Symbian2",
//                "Android2", "ios3", "Symbian3",
//                "Android3", "ios4", "Symbian4",
//                "Android4", "ios5", "Symbian5",
//                "Android5", "ios6", "Symbian6"
//        };
//
//        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, android.R.id.text1, names);
//
//        mListView.setAdapter(mAdapter);

    }

    private void initDummmyData() {

        for (int i = 0; i < 20; i++) {
            Status status = new Status();
            status.setName("Name " + i);
            status.setStatus("Status " + i);
            status.setStatus("last seen " + i);

            mStatuses.add(status);
        }

    }


}
