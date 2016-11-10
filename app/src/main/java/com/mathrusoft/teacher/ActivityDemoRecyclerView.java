package com.mathrusoft.teacher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mathrusoft.teacher.adapter.AdapterRecyclerViewDemo;
import com.mathrusoft.teacher.model.Status;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharanangadi on 10/11/16.
 */

public class ActivityDemoRecyclerView extends AppCompatActivity {

    RecyclerView mRecyclerView;

    AdapterRecyclerViewDemo adapterRecyclerViewDemo;
    List<Status> mStatuses = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recycler_demo);

        initDummmyData();

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapterRecyclerViewDemo = new AdapterRecyclerViewDemo(mStatuses);
        mRecyclerView.setAdapter(adapterRecyclerViewDemo);
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
