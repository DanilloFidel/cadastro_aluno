package com.example.danil.cadastroaluno_danilloapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.danil.cadastroaluno_danilloapp.conection.DBHelper;
import com.example.danil.cadastroaluno_danilloapp.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private DBHelper dbHelper = null;

    private String[] allColumns = { Student.ID, Student.NOME, Student.EMAIL,
            Student.TELEFONE};

    public StudentDAO(Context context) {
        dbHelper = new DBHelper(context);
    }

    public boolean save(Student student) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Student.NOME, student.getName());
        values.put(Student.EMAIL, student.getEmail());
        values.put(Student.TELEFONE, student.getPhone());

        long insertId = database.insert(Student.TABLE_NAME, null, values);

        return insertId > 0 ? Boolean.TRUE : Boolean.FALSE;
    }

    public Student findById(long id){
        SQLiteDatabase database = dbHelper.getReadableDatabase();

        Cursor cursor = database.query(Student.TABLE_NAME, allColumns, Student.ID + " = " +
                id, null,null, null, null);
        cursor.moveToFirst();

        Student student = new Student();

        student.setId(cursor.getLong(0));
        student.setName(cursor.getString(1));
        student.setEmail(cursor.getString(2));
        student.setPhone(cursor.getString(3));

        return student;
    }

    public List<Student> findAll(){
        SQLiteDatabase database = dbHelper.getReadableDatabase();

        Cursor cursor = database.query(Student.TABLE_NAME, allColumns, null, null,null, null, null);

        List<Student> students = new ArrayList<>();

        if (cursor.moveToFirst()) {

            int idxId = cursor.getColumnIndex(Student.ID);
            int idxNome = cursor.getColumnIndex(Student.NOME);
            int idxEmail = cursor.getColumnIndex(Student.EMAIL);
            int idxTelefone = cursor.getColumnIndex(Student.TELEFONE);

            do {
                Student aluno = new Student();
                students.add(aluno);

                if (idxId != 0)
                    aluno.setId(cursor.getLong(idxId));
                if (idxNome != 0)
                    aluno.setName(cursor.getString(idxNome));
                if (idxEmail != 0)
                    aluno.setEmail(cursor.getString(idxEmail));
                if (idxTelefone != 0)
                    aluno.setPhone(cursor.getString(idxTelefone));
            } while (cursor.moveToNext());
        }

        cursor.close();
        return students;
    }
}
