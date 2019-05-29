package com.example.danil.cadastroaluno_danilloapp.model;

import java.io.Serializable;

public class Student implements Serializable {
    public static final String TABLE_NAME = "aluno";

    public static final String ID = "_id";
    public static final String NOME = "nome";
    public static final String EMAIL = "email";
    public static final String TELEFONE = "telefone";

    private Long id;
    private String name;
    private String email;
    private String phone;

    public static final String DATABASE_CREATE = "create table "
            + TABLE_NAME + "( "
            + ID + " integer primary key autoincrement, "
            + NOME + " text not null, "
            + EMAIL + " text not null, "
            + TELEFONE +" text not null);";


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
