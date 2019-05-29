package com.example.danil.cadastroaluno_danilloapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.danil.cadastroaluno_danilloapp.model.Student;

import java.util.List;

public class StudentAdapter extends BaseAdapter {
    private List<Student> studentList = null;
    private Context context = null;
    private View view;

    public StudentAdapter(List<Student> studentList, Context context) {
        this.studentList = studentList;
        this.context = context;
    }

    @Override
    public int getCount() {
        if (!studentList.isEmpty()) {
            return studentList.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if (!studentList.isEmpty()) {
            return studentList.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        if (!studentList.isEmpty()) {
            return studentList.get(position).getId();
        }
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Student student = studentList.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.student_item, null);

        TextView studentDesc = (TextView) view.findViewById(R.id.student_desc);

        StringBuffer sb = new StringBuffer(1200);
        sb.append(student.getName());
        sb.append(" - ");
        sb.append(student.getPhone());
        studentDesc.setText(sb.toString());

        return view;
    }
}
