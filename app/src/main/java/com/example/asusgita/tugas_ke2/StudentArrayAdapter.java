package com.example.asusgita.tugas_ke2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.asusgita.tugas_ke2.R;
import com.example.asusgita.tugas_ke2.Student;

import java.util.ArrayList;

/**
 * Created by ASUS GITA on 10/16/2016.
 */

public class StudentArrayAdapter extends ArrayAdapter<Student> {

    public StudentArrayAdapter(Context context, ArrayList<Student> student) {
        super(context, 0, student);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Student student = getItem(position);
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.student_instance, parent, false);
        }
        EditText editId = (EditText) convertView.findViewById(R.id.edit_id);
        EditText editNama = (EditText) convertView.findViewById(R.id.edit_nama);
        EditText editNim = (EditText) convertView.findViewById(R.id.edit_nim);
        EditText editEmail = (EditText) convertView.findViewById(R.id.edit_email);
        EditText editPhone = (EditText) convertView.findViewById(R.id.edit_phone);

        editId.setText(student.getId()+ "");
        editNama.setText(student.getName());
        editNim.setText(student.getNoreg());
        editEmail.setText(student.getMail());
        editPhone.setText(student.getPhone());
        return convertView;

    }
}