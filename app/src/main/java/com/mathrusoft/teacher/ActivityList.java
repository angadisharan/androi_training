package com.mathrusoft.teacher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by sharanangadi on 07/11/16.
 */

public class ActivityList extends AppCompatActivity {


    ListView listView;

    String strings[] = {
            "1",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = (ListView) findViewById(R.id.list_view);


        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, strings));

    }
}
