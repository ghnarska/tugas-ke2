package com.example.asusgita.tugas_ke2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ASUS GITA on 10/16/2016.
 */

public class StudentActivity extends AppCompatActivity {
    static ArrayList<Student> student;
    private StudentArrayAdapter studentAdapter;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(), FormStudent.class);
                startActivity(i);
            }
        });
        if(student == null) {
            student = new ArrayList<Student>();
        }
        listView = (ListView) findViewById(R.id.list_item);

    }

    private void populateStudentDummies(){
        student.add(new Student(1,"3145136203","Ghina Rosika Amalina","085716336727","ghina.rosika@gmail.com"));
        student.add(new Student(2,"3145136206","Ghina Salsabila","081334567892","ghisa@gmail.com"));
        student.add(new Student(3,"3145136204","Dian Rakasiwi","08889768904","dian@gmail.com"));
        student.add(new Student(4,"3145136205","Annisa Mutiara Ditri","081334567672","ditri@gmail.com"));
        studentAdapter = new StudentArrayAdapter(this, student);
        listView.setAdapter(studentAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_student_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.clear_list:
                student.clear();
                studentAdapter = new StudentArrayAdapter(this, student);
                listView.setAdapter(studentAdapter);
                return true;
            case R.id.create_dummy:
                populateStudentDummies();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
