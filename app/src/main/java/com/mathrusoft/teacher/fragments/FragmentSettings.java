package com.mathrusoft.teacher.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mathrusoft.teacher.R;

/**
 * Created by sharanangadi on 04/11/16.
 */
public class FragmentSettings extends Fragment {

    private Button mButtonSubmit;
    private EditText mEditTextName;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_settings, null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        intitViews(getView());
    }

    private void intitViews(View view) {

        mButtonSubmit = (Button) view.findViewById(R.id.submit);
        mEditTextName = (EditText) view.findViewById(R.id.name);

        mButtonSubmit.setOnClickListener(mOnClickListener);
    }

    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String name = mEditTextName.getText().toString();
            Toast.makeText(getActivity().getApplicationContext(),
                    name, Toast.LENGTH_SHORT).show();

        }


    };

}
