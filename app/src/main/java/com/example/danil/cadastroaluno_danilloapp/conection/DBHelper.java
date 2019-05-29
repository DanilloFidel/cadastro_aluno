package com.example.danil.cadastroaluno_danilloapp.conection;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.danil.cadastroaluno_danilloapp.model.Student;

public class DBHelper extends SQLiteOpenHelper {
    private static String NAME = "DatabaseStudents";
    private static int VERSION = 1;

    public DBHelper(Context context) {
        super(context, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Student.DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
