package com.mathrusoft.teacher.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mathrusoft.teacher.R;

/**
 * Created by sharanangadi on 04/11/16.
 */
public class FragmentDemo extends Fragment {

    public FragmentDemo() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_demo_one, null);
    }


}
