package com.mathrusoft.teacher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by sharanangadi on 25/10/16.
 */
public class ActivityWidgetDemo extends AppCompatActivity {

    private RadioGroup mRadioGroupGender;

    private CheckBox mCheckBoxIPhone;
    private CheckBox mCheckBoxNokia;
    private CheckBox mCheckBoxAndroid;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.widget_demo);

        mRadioGroupGender = (RadioGroup) findViewById(R.id.radio_group_gender);

        mRadioGroupGender.setOnCheckedChangeListener(mOnCheckedChangeListener);


        mCheckBoxAndroid = (CheckBox) findViewById(R.id.checkbox_android);
        mCheckBoxIPhone = (CheckBox) findViewById(R.id.checkbox_iphone);
        mCheckBoxNokia = (CheckBox) findViewById(R.id.checkbox_nokia);

        mCheckBoxAndroid.setOnCheckedChangeListener(mOSCheckedChangeListener);
        mCheckBoxIPhone.setOnCheckedChangeListener(mOSCheckedChangeListener);
        mCheckBoxNokia.setOnCheckedChangeListener(mOSCheckedChangeListener);
    }

    CompoundButton.OnCheckedChangeListener mOSCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            Log.d("MyFirstApp", "Inside OnCheckedListener");
            Log.d("MyFirstApp", "isChecked " + isChecked);

            Log.e("MyFirstApp", "isChecked " + isChecked);
            Log.i("MyFirstApp", "isChecked " + isChecked);



            switch (buttonView.getId()) {
                case R.id.checkbox_android:
                    Toast.makeText(ActivityWidgetDemo.this, "Android selectState " + isChecked, Toast.LENGTH_SHORT).show();
                    break;

                case R.id.checkbox_iphone:
                    Toast.makeText(ActivityWidgetDemo.this, "IOS selectState " + isChecked, Toast.LENGTH_SHORT).show();
                    break;

                case R.id.checkbox_nokia:
                    Toast.makeText(ActivityWidgetDemo.this, "Symbian selectState " + isChecked, Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };


    RadioGroup.OnCheckedChangeListener mOnCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.male:
                    Toast.makeText(ActivityWidgetDemo.this, "Gender Male selected", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.female:
                    Toast.makeText(ActivityWidgetDemo.this, "Gender Female selected", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
}
