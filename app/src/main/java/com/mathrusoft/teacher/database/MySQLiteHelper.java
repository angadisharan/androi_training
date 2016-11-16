package com.mathrusoft.teacher.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.mathrusoft.teacher.model.Student;
import com.mathrusoft.teacher.model.StudentAttendancePercentage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharanangadi on 11/11/16.
 */

public class MySQLiteHelper extends SQLiteOpenHelper {

    private static final String TAG = "MYAPP";

    private static final int VERSION = 3;
    private static final String DATABASE_NAME = "teacher.db";

    private static final String TABLE_STUDENT = "student";
    private static final String CREATE_STATEMENT_STUDENT = " create table " + TABLE_STUDENT +
            " ( id INTEGER PRIMARY KEY autoincrement, name text, gender text, usn text, branch text, phone text);";


    private static final String TABLE_ATTENDANCE = "attendance";
    private static final String CREATE_TABLE_ATTENDANCE = " create table " + TABLE_ATTENDANCE
            + " ( id integer primary key autoincrement , date text, student_id integer, attendance integer ); ";

    private static MySQLiteHelper mySQLiteHelper;

    public static MySQLiteHelper getInstance(Context context) {
        if (mySQLiteHelper == null) {
            mySQLiteHelper = new MySQLiteHelper(context);
        }
        return mySQLiteHelper;
    }

    private MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "Inside DB onCreate");

        db.execSQL(CREATE_STATEMENT_STUDENT);
        db.execSQL(CREATE_TABLE_ATTENDANCE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "Inside DB onUpgrade");

        db.execSQL(" DROP table if exists " + TABLE_STUDENT);
        db.execSQL(" DROP table if exists " + TABLE_ATTENDANCE);

        onCreate(db);
    }

    public long saveStudent(Student student) {

        ContentValues contentValues = new ContentValues();

        contentValues.put("name", student.getName());
        contentValues.put("usn", student.getUsn());
        contentValues.put("branch", student.getBranch());

        SQLiteDatabase database = this.getWritableDatabase();

        long id = database.insert(TABLE_STUDENT, null, contentValues);
        database.close();
        return id;
    }


    public List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();

        String sql = " select * from " + TABLE_STUDENT + " ; ";

        SQLiteDatabase database = this.getReadableDatabase();

        Cursor cursor = database.rawQuery(sql, null);

        if (cursor != null || cursor.getCount() > 0) {

            cursor.moveToPosition(-1);

            Log.d("MYAPP", cursor.getPosition() + "");

            while (cursor.moveToNext()) {

                Student student = new Student();
                student.setName(cursor.getString(cursor.getColumnIndex("name")));
                student.setUsn(cursor.getString(cursor.getColumnIndex("usn")));
                student.setBranch(cursor.getString(cursor.getColumnIndex("branch")));
                student.setId(cursor.getInt(cursor.getColumnIndex("id")));

                studentList.add(student);
            }


        }
        database.close();

        return studentList;
    }


    public void saveAttendance(List<Student> students) {
        SQLiteDatabase database = this.getWritableDatabase();

        for (Student student : students) {
            ContentValues contentValues = new ContentValues();

            contentValues.put("date", student.getDate());
            contentValues.put("student_id", student.getId());

            int isPresent = 0;
            if (student.isPresent()) {
                isPresent = 1;
            }
            contentValues.put("attendance", isPresent);

            long id = database.insert(TABLE_ATTENDANCE, null, contentValues);

            Log.d("MYAPP", " id saved attendance: " + id);

        }

        database.close();
    }


    public List<StudentAttendancePercentage> getStudentsAttendancePercentage() {

        SQLiteDatabase database = this.getReadableDatabase();


//        select sum(a.attendance) present_class, s.name name, count(a.attendance) total
//        from student s, attendance a
//        where s._id = a.student_id
//        group by a.student_id

        List<StudentAttendancePercentage> attendanceList = new ArrayList<>();

        String sql = " select sum(a.attendance) present_class, s.name name, count(a.attendance) total" +
                " from " + TABLE_ATTENDANCE + " a, " + TABLE_STUDENT + " s " +
                " where s.id = a.student_id group by a.student_id";
        Cursor cursor = database.rawQuery(sql, null);
        cursor.moveToPosition(-1);
        while (cursor.moveToNext()) {
            StudentAttendancePercentage attendance = new StudentAttendancePercentage();
            attendance.setName(cursor.getString(cursor.getColumnIndex("name")));
            attendance.setPresentClasses(cursor.getInt(cursor.getColumnIndex("present_class")));

            int totalClass = cursor.getInt(cursor.getColumnIndex("total"));
            attendance.setPercentage((attendance.getPresentClasses() / totalClass) * 100.0f);

            attendanceList.add(attendance);
        }

        database.close();
        return attendanceList;
    }

}
