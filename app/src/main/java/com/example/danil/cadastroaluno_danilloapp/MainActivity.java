package com.example.danil.cadastroaluno_danilloapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.danil.cadastroaluno_danilloapp.dao.StudentDAO;
import com.example.danil.cadastroaluno_danilloapp.model.Student;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private StudentAdapter studentAdapter;
    private ListView studentListView;
    private List<Student> studentsList = null;
    private StudentDAO studentDAO = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_register = findViewById(R.id.add_screen);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StudentForm.class);
                startActivity(intent);
            }
        });
        studentDAO = new StudentDAO(this);
        studentListView = (ListView) findViewById(R.id.students_list);
    }


    @Override
    protected void onResume() {
        super.onResume();

        studentsList = studentDAO.findAll();
        if (!studentsList.isEmpty() && studentsList.size() > 0) {
            studentAdapter = new StudentAdapter(studentsList, this);
            studentListView.setAdapter(studentAdapter);
        } else {
            Toast.makeText(getApplicationContext(), "Não tem alunos cadastrados" , Toast.LENGTH_LONG).show();
        }
    }
}
