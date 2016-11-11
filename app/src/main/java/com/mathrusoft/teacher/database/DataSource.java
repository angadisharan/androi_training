package com.mathrusoft.teacher.database;

import android.content.Context;

import com.mathrusoft.teacher.model.Student;

/**
 * Created by sharanangadi on 11/11/16.
 */

public class DataSource {

    MySQLiteHelper mySQLiteHelper;

    public DataSource(Context context) {
        mySQLiteHelper = MySQLiteHelper.getInstance(context);
    }

    public long saveStudent(Student student) {
        return mySQLiteHelper.saveStudent(student);
    }

}
