package com.mathrusoft.teacher.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.mathrusoft.teacher.R;
import com.mathrusoft.teacher.model.Student;

import java.util.List;

/**
 * Created by sharanangadi on 15/11/16.
 */

public class AdapterStudentList extends ArrayAdapter<Student> {

    List<Student> mStudentList;

    private Context mContext;

    public AdapterStudentList(Context context, int resource, List<Student> objects) {
        super(context, resource, objects);

        mContext = context;

        mStudentList = objects;
    }

    @Override
    public int getCount() {
        return mStudentList.size();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_student, null);
        }

        final Student student = mStudentList.get(position);

        CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.checkbox_attendance);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                student.setAttendance(isChecked);

//                if (isChecked) {
//                    student.setAttendance(true);
//                } else {
//                    student.setAttendance(false);
//                }

//                Toast.makeText(mContext, " Student " + student.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        ((TextView) convertView.findViewById(R.id.name)).setText(student.getName());
        ((TextView) convertView.findViewById(R.id.branch)).setText(student.getBranch());
        ((TextView) convertView.findViewById(R.id.usn)).setText(student.getUsn());

        return convertView;
    }


}
