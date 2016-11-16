package com.mathrusoft.teacher.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.mathrusoft.teacher.R;
import com.mathrusoft.teacher.adapter.AdapterStudentList;
import com.mathrusoft.teacher.database.DataSource;
import com.mathrusoft.teacher.model.Student;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sharanangadi on 14/11/16.
 */

public class FragmentStudentList extends Fragment {

    List<Student> mStudentList = new ArrayList<>();

    ListView mListView;

    private Button mButtonSaveAttendance;

    DataSource mDataSource;
    Context mContext;

    AdapterStudentList mAdapterStudentList;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mDataSource = new DataSource(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_student_list, null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.d("MYAPP", " inside onActivity Creaate");


        View view = getView();

        mListView = (ListView) view.findViewById(R.id.student_list);
        mAdapterStudentList = new AdapterStudentList(mContext, -1, mStudentList);

        mButtonSaveAttendance = (Button) view.findViewById(R.id.save_attendance);
        mButtonSaveAttendance.setOnClickListener(mOnClickListener);


        mListView.setAdapter(mAdapterStudentList);

        mStudentList.addAll(mDataSource.getAllStudents());

//        for (Student student : mStudentList) {
//            Log.d("MYAPP", " Name " + student.getName());
//            Log.d("MYAPP", " Branch " + student.getBranch());
//            Log.d("MYAPP", " USN " + student.getUsn());
//            Log.d("MYAPP", " id " + student.getId());
//        }

    }


    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //DO DB call here;

            Date date = new Date();

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String text = simpleDateFormat.format(date);

            Toast.makeText(mContext, text, Toast.LENGTH_SHORT).show();

            mDataSource.saveAttendance(mStudentList);

//            String absentList = "";
//            for (Student student : mStudentList) {
//                if (!student.isPresent()) {
//                    absentList = absentList + student.getName() + " ";
//                }
//            }

//            Toast.makeText(mContext, absentList, Toast.LENGTH_SHORT).show();

        }
    };

}
