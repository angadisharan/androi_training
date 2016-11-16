package com.mathrusoft.teacher.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mathrusoft.teacher.R;
import com.mathrusoft.teacher.model.StudentAttendancePercentage;

import java.util.List;

/**
 * Created by sharanangadi on 16/11/16.
 */

public class AdapterAttendancePercentage extends ArrayAdapter<StudentAttendancePercentage> {

    List<StudentAttendancePercentage> mList;
    Context mContext;

    public AdapterAttendancePercentage(Context context, int resource, List<StudentAttendancePercentage> objects) {
        super(context, resource, objects);
        mContext = context;
        mList = objects;
    }

    @Override
    public int getCount() {
        return mList.size();
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_student_attendance_percentage, null);
        }

        StudentAttendancePercentage item = mList.get(position);
        ((TextView) convertView.findViewById(R.id.name)).setText(item.getName());
        ((TextView) convertView.findViewById(R.id.classes_present)).setText(item.getPresentClasses() + "");
        ((TextView) convertView.findViewById(R.id.percentage)).setText(item.getPercentage() + "%");


        return convertView;
    }


}
