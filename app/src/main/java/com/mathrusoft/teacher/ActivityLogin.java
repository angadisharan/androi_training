package com.mathrusoft.teacher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by sharanangadi on 24/10/16.
 */
public class ActivityLogin extends AppCompatActivity {

    private EditText mEditTextUsername;
    private EditText mEditTextPassword;
    private Button mButtonSubmit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        mEditTextUsername = (EditText) findViewById(R.id.edittext_user_name);
        mEditTextPassword = (EditText) findViewById(R.id.edittext_password);
        mButtonSubmit = (Button) findViewById(R.id.button_submit);

        mButtonSubmit.setOnClickListener(mOnClickListener);


    }

    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Log.d("ActivityLog", "Inside OnClick");

            String userName = mEditTextUsername.getText().toString();
            String password = mEditTextPassword.getText().toString();

            //make a  server call

            if (userName.equalsIgnoreCase(password)) {
                Toast.makeText(ActivityLogin.this, "User Login Success", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(ActivityLogin.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
            }

        }
    };
}
