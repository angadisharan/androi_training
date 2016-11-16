package com.mathrusoft.teacher.database;

import android.content.Context;

import com.mathrusoft.teacher.model.Student;
import com.mathrusoft.teacher.model.StudentAttendancePercentage;

import java.util.List;

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

    public List<Student> getAllStudents() {
        return mySQLiteHelper.getAllStudents();
    }

    public void saveAttendance(List<Student> students) {
        mySQLiteHelper.saveAttendance(students);
    }

    public List<StudentAttendancePercentage> getStudentsAttendancePercentage() {
        return mySQLiteHelper.getStudentsAttendancePercentage();
    }

}
