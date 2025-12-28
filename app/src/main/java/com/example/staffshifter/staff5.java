package com.example.staffshifter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class staff5 extends Activity {
    Spinner name_spin,day_spin,class_spin_09,class_spin_10,class_spin_11,class_spin_01,class_spin_02,class_spin_03,class_spin_04;
    Spinner subject_spin_09,subject_spin_10,subject_spin_11,subject_spin_01,subject_spin_02,subject_spin_03,subject_spin_04;
    ArrayList list_name,list_day,list_class,list_subject,list_subject_cse_1,list_subject_cse_2,list_subject_cse_3,list_subject_cse_4,list_subject_cse_5,list_subject_cse_6,list_subject_cse_7,list_subject_cse_8;
    ArrayAdapter adptr_name,adptr_day,adptr_class_09,adptr_class_10,adptr_class_11,adptr_class_01,adptr_class_02,adptr_class_03,adptr_class_04;
    ArrayAdapter adptr_subject_09,adptr_subject_10,adptr_subject_11,adptr_subject_01,adptr_subject_02,adptr_subject_03,adptr_subject_04;

    String s1,s2,s3,s4;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.staff5);
        name_spin = findViewById(R.id.name_spin);
        day_spin = findViewById(R.id.day_spin);

        class_spin_09=findViewById(R.id.class_spin_09);
        class_spin_10=findViewById(R.id.class_spin_10);
        class_spin_11=findViewById(R.id.class_spin_11);
        class_spin_01=findViewById(R.id.class_spin_01);
        class_spin_02=findViewById(R.id.class_spin_02);
        class_spin_03=findViewById(R.id.class_spin_03);
        class_spin_04=findViewById(R.id.class_spin_04);

        subject_spin_09=findViewById(R.id.subject_spin_09);
        subject_spin_10=findViewById(R.id.subject_spin_10);
        subject_spin_11=findViewById(R.id.subject_spin_11);
        subject_spin_01=findViewById(R.id.subject_spin_01);
        subject_spin_02=findViewById(R.id.subject_spin_02);
        subject_spin_03=findViewById(R.id.subject_spin_03);
        subject_spin_04=findViewById(R.id.subject_spin_04);



        list_name = new ArrayList();
        list_day = new ArrayList();
        list_class = new ArrayList();
        list_subject = new ArrayList();
        list_subject_cse_1 = new ArrayList();
        list_subject_cse_2 = new ArrayList();
        list_subject_cse_3 = new ArrayList();
        list_subject_cse_4 = new ArrayList();
        list_subject_cse_5 = new ArrayList();
        list_subject_cse_6 = new ArrayList();
        list_subject_cse_7 = new ArrayList();
        list_subject_cse_8 = new ArrayList();


        list_name.add("Mr.Dahiya");
        list_name.add("Mrs.Suman");
        list_name.add("Mrs.Arushi Bansal");
        list_name.add("Mrs.Ankit");


        list_day.add("Monday");
        list_day.add("Tuesday");
        list_day.add("Wednesday");
        list_day.add("Thursday");
        list_day.add("Friday");


        list_class.add("Computer Science Engineering(1st sem)");
        list_class.add("Computer Science Engineering(3rd sem)");
        list_class.add("Computer Science Engineering(5th sem)");
        list_class.add("Computer Science Engineering(7th sem)");

        list_class.add("Civil Engineering(1st sem)");
        list_class.add("Civil Engineering(3rd sem)");
        list_class.add("Civil Engineering(5th sem)");
        list_class.add("Civil Engineering(7th sem)");

        list_class.add("Electical Communication and Engineering(1st sem)");
        list_class.add("Electical Communication and Engineering(3rd sem)");
        list_class.add("Electical Communication and Engineering(5th sem)");
        list_class.add("Electical Communication and Engineering(7th sem)");

        list_class.add("Electical Engineering(1st sem)");
        list_class.add("Electical Engineering(3rd sem)");
        list_class.add("Electical Engineering(5th sem)");
        list_class.add("Electical Engineering(7th sem)");

        list_class.add("Mechanical Engineering(1st sem)");
        list_class.add("Mechanical Engineering(3rd sem)");
        list_class.add("Mechanical Engineering(5th sem)");
        list_class.add("Mechanical Engineering(7th sem)");

        list_class.add("Cse(DataScience)(1st sem)");
        list_class.add("Cse(DataScience)(3rd sem)");
        list_class.add("Cse(DataScience)(5th sem)");
        list_class.add("Cse(DataScience)(7th sem)");


        //---------------------Subject - Odd Sem-------------------

        list_subject_cse_1.add("Chemistry");
        list_subject_cse_1.add("Programing Probelm Solving");
        list_subject_cse_1.add("Mathematics-I");
        list_subject_cse_1.add("English");


        list_subject_cse_3.add("Computer Organisation & Architecture");
        list_subject_cse_3.add("Data Structure & Algorithm");
        list_subject_cse_3.add("Mathematics-III");
        list_subject_cse_3.add("Object Oriented Programming (C++)");
        list_subject_cse_3.add("Analog Electronics & Circuits");

        list_subject_cse_5.add("Computer Graphics");
        list_subject_cse_5.add("Python Programming");
        list_subject_cse_5.add("Cryptography & Network Security");
        list_subject_cse_5.add("High Speed Network");
        list_subject_cse_5.add("Digital Electronics");

        list_subject_cse_7.add("Artificial Intelligence");
        list_subject_cse_7.add("Cybersecurity");
        list_subject_cse_7.add("Blockchain Technology");
        list_subject_cse_7.add("Natural Language Processing");
        list_subject_cse_7.add("Cloud Computing");



        //---------------------Subject - Even Sem-------------------

        list_subject_cse_2.add("Physics");
        list_subject_cse_2.add("Basic Electrical Engineering ");
        list_subject_cse_2.add("Mathematics-II");
        list_subject_cse_2.add("Workshop Technology");
        list_subject_cse_2.add("Indian Constitution");


        list_subject_cse_4.add("Computer Network");
        list_subject_cse_4.add("Database Management and System");
        list_subject_cse_4.add("Microprocessor & Interface");
        list_subject_cse_4.add("Java Programming");
        list_subject_cse_4.add("Software Engineering");

        list_subject_cse_6.add("Computer Graphics");
        list_subject_cse_6.add("Python Programming");
        list_subject_cse_6.add("Cryptography & Network Security");
        list_subject_cse_6.add("High Speed Network");
        list_subject_cse_6.add("Digital Electronics");

        list_subject_cse_7.add("Artificial Intelligence");
        list_subject_cse_7.add("Cybersecurity");
        list_subject_cse_7.add("Blockchain Technology");
        list_subject_cse_7.add("Natural Language Processing");
        list_subject_cse_7.add("Cloud Computing");











        list_subject.add("Data Structure & Algorithm");
        list_subject.add("Cryptography & Network Security");
        list_subject.add("Computer Graphics");
        list_subject.add("Object Oriented Programming (C++)");
        list_subject.add("Computer Network");
        list_subject.add("Database Management and System");
        list_subject.add("Programming Problem Solving");
        list_subject.add("Java Programming");
        list_subject.add("Microprocessor & Interface");


        adptr_name = new ArrayAdapter(this, R.layout.text1, list_name);
        name_spin.setAdapter(adptr_name);

        name_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s1 = name_spin.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        adptr_day = new ArrayAdapter(this, R.layout.text1, list_day);
        day_spin.setAdapter(adptr_day);
        day_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s2 = day_spin.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        //------9------


        //-------------------------------class--------------------------

        adptr_class_09 = new ArrayAdapter(this, R.layout.text1, list_class);
        class_spin_09.setAdapter(adptr_class_09);

        class_spin_09.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s3 = class_spin_09.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        //---------------------------------------subject-----------------------------

        adptr_subject_09 = new ArrayAdapter(this, R.layout.text1, list_subject);
        subject_spin_09.setAdapter(adptr_subject_09);

        subject_spin_09.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s3 = subject_spin_09.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        //------10-----

        adptr_class_10= new ArrayAdapter(this, R.layout.text1, list_class);
        class_spin_10.setAdapter(adptr_class_10);

        class_spin_10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s3 = class_spin_10.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        //---------------------------------------subject-----------------------------

        adptr_subject_10 = new ArrayAdapter(this, R.layout.text1, list_subject);
        subject_spin_10.setAdapter(adptr_subject_09);

        subject_spin_10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s3 = subject_spin_10.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //------11------


        adptr_class_11 = new ArrayAdapter(this, R.layout.text1, list_class);
        class_spin_11.setAdapter(adptr_class_11);

        class_spin_11.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s3 = class_spin_11.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        //---------------------------------------subject-----------------------------

        adptr_subject_11 = new ArrayAdapter(this, R.layout.text1, list_subject);
        subject_spin_11.setAdapter(adptr_subject_09);

        subject_spin_11.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s3 = subject_spin_11.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        //------01------


        adptr_class_01 = new ArrayAdapter(this, R.layout.text1, list_class);
        class_spin_01.setAdapter(adptr_class_01);

        class_spin_01.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s3 = class_spin_01.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });



        //---------------------------------------subject-----------------------------

        adptr_subject_01 = new ArrayAdapter(this, R.layout.text1, list_subject);
        subject_spin_01.setAdapter(adptr_subject_09);

        subject_spin_01.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s3 = subject_spin_01.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        //---------02------


        adptr_class_02 = new ArrayAdapter(this, R.layout.text1, list_class);
        class_spin_02.setAdapter(adptr_class_02);

        class_spin_02.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s3 = class_spin_02.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        //---------------------------------------subject-----------------------------

        adptr_subject_02 = new ArrayAdapter(this, R.layout.text1, list_subject);
        subject_spin_02.setAdapter(adptr_subject_02);

        subject_spin_02.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s3 = subject_spin_02.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        //-------03------


        adptr_class_03 = new ArrayAdapter(this, R.layout.text1, list_class);
        class_spin_03.setAdapter(adptr_class_03);

        class_spin_03.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s3 = class_spin_03.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        //---------------------------------------subject-----------------------------

        adptr_subject_03 = new ArrayAdapter(this, R.layout.text1, list_subject);
        subject_spin_03.setAdapter(adptr_subject_03);

        subject_spin_03.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s3 = subject_spin_03.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        //-------04------

        adptr_class_04 = new ArrayAdapter(this, R.layout.text1, list_class);
        class_spin_04.setAdapter(adptr_class_04);

        class_spin_04.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s3 = class_spin_04.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });



        //---------------------------------------subject-----------------------------

        adptr_subject_04 = new ArrayAdapter(this, R.layout.text1, list_subject);
        subject_spin_04.setAdapter(adptr_subject_04);

        subject_spin_04.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s3 = subject_spin_04.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


    }
    public void back_button3(View v){
        Intent obj=new Intent(this,staff2.class);
        startActivity(obj);
        overridePendingTransition(R.anim.slide,R.anim.slide2);
    }
    public void back_button5(View v){
        Intent obj=new Intent(this,staff3.class);
        startActivity(obj);
        overridePendingTransition(R.anim.slide,R.anim.slide2);
    }

}


