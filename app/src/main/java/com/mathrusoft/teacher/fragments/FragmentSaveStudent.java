package com.mathrusoft.teacher.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mathrusoft.teacher.R;
import com.mathrusoft.teacher.database.DataSource;
import com.mathrusoft.teacher.model.Student;

/**
 * Created by sharanangadi on 10/11/16.
 */

public class FragmentSaveStudent extends Fragment {

    private EditText mEditTextName;
    private EditText mEditTextUSN;
    private EditText mEditTextBranch;

    private Button mButton;

    Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_save_student, null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews(getView());
    }

    private void initViews(View view) {
        mEditTextName = (EditText) view.findViewById(R.id.name);
        mEditTextUSN = (EditText) view.findViewById(R.id.usn);
        mEditTextBranch = (EditText) view.findViewById(R.id.branch);

        mButton = (Button) view.findViewById(R.id.button_save);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(mEditTextName.getText().toString())
                        || TextUtils.isEmpty(mEditTextUSN.getText().toString())
                        || TextUtils.isEmpty(mEditTextBranch.getText().toString())) {

                    Toast.makeText(getActivity().getApplicationContext(),
                            "Please enter valid input", Toast.LENGTH_SHORT).show();
                    return;
                }

                Student student = new Student();

                student.setName(mEditTextName.getText().toString());
                student.setUsn(mEditTextUSN.getText().toString());
                student.setBranch(mEditTextBranch.getText().toString());


                doDBSaveCall(student);

            }
        });


    }

    private void doDBSaveCall(Student student) {
        //Save to DB
        DataSource dataSource = new DataSource(mContext);
        long id = dataSource.saveStudent(student);
        Toast.makeText(mContext,
                "Sutedent saved id : " + id, Toast.LENGTH_SHORT).show();
    }

}
