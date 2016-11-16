package com.mathrusoft.teacher.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.mathrusoft.teacher.R;
import com.mathrusoft.teacher.adapter.AdapterAttendancePercentage;
import com.mathrusoft.teacher.database.DataSource;
import com.mathrusoft.teacher.model.StudentAttendancePercentage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharanangadi on 16/11/16.
 */

public class FragmentStudentAttendancePercentage extends Fragment {

    ListView listView;

    AdapterAttendancePercentage mAdapterAttendancePercentage;
    List<StudentAttendancePercentage> mAttenceList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragement_student_attendance_percentage, null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        View view = getView();

        listView = (ListView) view.findViewById(R.id.list_attendance);

        mAdapterAttendancePercentage = new AdapterAttendancePercentage(getActivity().getApplicationContext(),
                -1, mAttenceList);

        listView.setAdapter(mAdapterAttendancePercentage);

        initDataFromDB();

    }

    private void initDataFromDB() {

        DataSource dataSource = new DataSource(getActivity().getApplicationContext());
        mAttenceList.addAll(dataSource.getStudentsAttendancePercentage());

        mAdapterAttendancePercentage.notifyDataSetChanged();

    }
}
