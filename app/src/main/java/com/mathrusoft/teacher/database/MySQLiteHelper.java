package com.mathrusoft.teacher.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.mathrusoft.teacher.model.Student;

/**
 * Created by sharanangadi on 11/11/16.
 */

public class MySQLiteHelper extends SQLiteOpenHelper {

    private static final String TAG = "MYAPP";

    private static final int VERSION = 2;
    private static final String DATABASE_NAME = "teacher.db";

    private static final String TABLE_STUDENT = "student";
    private static final String CREATE_STATEMENT_STUDENT = " create table " + TABLE_STUDENT +
            " ( id INTEGER PRIMARY KEY autoincrement, name text, usn text, branch text, phone text);";



    private static MySQLiteHelper mySQLiteHelper;
    public static MySQLiteHelper getInstance(Context context){
        if (mySQLiteHelper == null){
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
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "Inside DB onUpgrade");

        db.execSQL(" DROP table if exists " + TABLE_STUDENT);

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


}
