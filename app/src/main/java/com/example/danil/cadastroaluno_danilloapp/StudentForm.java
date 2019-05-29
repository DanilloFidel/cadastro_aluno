package com.example.danil.cadastroaluno_danilloapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.danil.cadastroaluno_danilloapp.dao.StudentDAO;
import com.example.danil.cadastroaluno_danilloapp.model.Student;

public class StudentForm extends AppCompatActivity {
    private EditText nameTxt;
    private  EditText emailTxt;
    private EditText phoneTxt;
    private StudentDAO studentDAO = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form);

        nameTxt = findViewById(R.id.txt_name);
        emailTxt = findViewById(R.id.txt_email);
        phoneTxt = findViewById(R.id.txt_phone);
        Button btn_save = findViewById(R.id.btn_register);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameTxt.getText().toString();
                String email = emailTxt.getText().toString();
                String phone = phoneTxt.getText().toString();

                Student student = createStudent(name, email, phone);
                writeStudent(student);
                Intent intent = new Intent(StudentForm.this, MainActivity.class);
                startActivity(intent);
            }
        });


        studentDAO = new StudentDAO(this);
    }

    public void writeStudent(Student student){
        studentDAO.save(student);
        Toast.makeText(StudentForm.this,"Aluno Cadastrado com sucesso", Toast.LENGTH_LONG).show();
    }

    private Student createStudent(String nome, String email, String telefone) {
        Student student = new Student();
        student.setName(nome);
        student.setEmail(email);
        student.setPhone(telefone);
        return student;
    }


}
