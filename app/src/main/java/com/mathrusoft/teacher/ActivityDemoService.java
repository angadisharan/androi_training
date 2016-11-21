package com.mathrusoft.teacher;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.mathrusoft.teacher.service.DemoIntentService;
import com.mathrusoft.teacher.service.DemoService;

/**
 * Created by sharanangadi on 17/11/16.
 */

public class ActivityDemoService extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_service);


//        Intent intent = new Intent(this.getApplicationContext(), DemoService.class);
//        startService(intent);




        Intent intentService = new Intent(this.getApplicationContext(), DemoIntentService.class);

//        intentService.putExtra("NAME", "Test Name here");
//        intentService.putExtra("IS", 400);
//
//        startService(intentService);

//        Intent intent = new Intent(this.getApplicationContext(), DemoService.class);
//        startService(intent);


        Intent intent = new Intent(this.getApplicationContext(), ActivityB.class);
        intent.putExtra("NAME", "Test Name here");
        intent.putExtra("IS", 400);
        startActivity(intent);

    }

    //    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        setContentView(R.layout.activity_demo_service);
//
//        Intent intent = new Intent(this.getApplicationContext(), DemoService.class);
//        startService(intent);
//
//    }
}
