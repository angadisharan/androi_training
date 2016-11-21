package com.mathrusoft.teacher;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mathrusoft.teacher.utils.Constants;

/**
 * Created by sharanangadi on 24/10/16.
 */
public class ActivityLogin extends AppCompatActivity {

    private static final String TAG = "TA:ActivityLogin";

    private EditText mEditTextUsername;
    private EditText mEditTextPassword;
    private Button mButtonSubmit;
//    private Button mButtonCancel;

//    private TextView mTextViewMessage;

    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        mContext = this.getApplicationContext();

        mEditTextUsername = (EditText) findViewById(R.id.edittext_user_name);
        mEditTextPassword = (EditText) findViewById(R.id.edittext_password);
        mButtonSubmit = (Button) findViewById(R.id.button_submit);
//        mButtonCancel = (Button) findViewById(R.id.button_cancel);

//        mTextViewMessage = (TextView) findViewById(R.id.message);
//        mTextViewMessage.setVisibility(View.GONE);


        mButtonSubmit.setOnClickListener(mOnClickListener);
//        mButtonCancel.setOnClickListener(mOnClickListener);


        SharedPreferences sharedPreferences = getSharedPreferences(Constants.PREF_NAME, MODE_PRIVATE);
        boolean isLoggedIn = sharedPreferences.getBoolean(Constants.IS_AUTH, false);

        if (isLoggedIn) {
            Intent intent = new Intent(ActivityLogin.this, ActivityMain.class);
            startActivity(intent);
            ActivityLogin.this.finish();
        }
    }

//    View.OnClickListener mCancelClickListner = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//
//        }
//    };

    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            switch (v.getId()) {
                case R.id.button_submit:
                    submitClick();
                    break;
                case R.id.button_cancel:
                    ActivityLogin.this.finish();
//                    Toast.makeText(mContext, "Cancel Clicked ", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    public void closeActivity() {
        ActivityLogin.this.finish();
        Toast.makeText(mContext, "Cancel Clicked ", Toast.LENGTH_SHORT).show();
    }


    private void submitClick() {
        Log.d(TAG, "Inside OnClick");

        String userName = mEditTextUsername.getText().toString();
        String password = mEditTextPassword.getText().toString();


        Log.d(TAG, "Inside OnClick");

        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)) {
            Toast.makeText(mContext, "UserName or Password are Empty", Toast.LENGTH_SHORT).show();
            return;
        }

//            /data/data/<package_name>/shared_prefs/
        //make a  server call
        if (userName.equalsIgnoreCase(password)) {

            Log.d(TAG, "Inside if statement");

            SharedPreferences sharedPreferences = getSharedPreferences(Constants.PREF_NAME, MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putString(Constants.USER_NAME, userName);
            editor.putString(Constants.PASSWORD, password);
            editor.putBoolean(Constants.IS_AUTH, true);

            editor.commit();

            Intent intent = new Intent(ActivityLogin.this, ActivityMain.class);
            startActivity(intent);
            ActivityLogin.this.finish();

            Toast.makeText(mContext, "Welcome...", Toast.LENGTH_SHORT).show();
//                mTextViewMessage.setText("Welcome...");
//                mTextViewMessage.setVisibility(View.VISIBLE);
        } else {
            Log.d(TAG, "Inside else statement");
            Toast.makeText(mContext, "Invalid Credentials.....", Toast.LENGTH_SHORT).show();

//                mTextViewMessage.setText("Invalid Credentials......");
//                mTextViewMessage.setVisibility(View.VISIBLE);
        }

//            if (userName.equalsIgnoreCase(password)) {
//                Toast.makeText(ActivityLogin.this, "User Login Success", Toast.LENGTH_SHORT).show();
//            } else {
//                Toast.makeText(ActivityLogin.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
//            }

    }

}
