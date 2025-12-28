    package com.example.staffshifter;

    import android.app.Activity;
    import android.content.Intent;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Adapter;
    import android.widget.AdapterView;
    import android.widget.ArrayAdapter;
    import android.widget.EditText;
    import android.widget.RadioButton;
    import android.widget.Spinner;
    import android.widget.TextView;
    import android.widget.Toast;

    import androidx.annotation.Nullable;
    import androidx.annotation.StringRes;

    import com.android.volley.AuthFailureError;
    import com.android.volley.Request;
    import com.android.volley.RequestQueue;
    import com.android.volley.Response;
    import com.android.volley.VolleyError;
    import com.android.volley.toolbox.StringRequest;
    import com.android.volley.toolbox.Volley;

    import org.json.JSONArray;
    import org.json.JSONObject;

    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.Map;

    public class staff5_2 extends Activity {
        Spinner name_spin, day_spin, time_spin, class_spin, subject_spin;
        ArrayList list_name, list_day, list_class_odd, list_class_even, list_subject, list_time, list_subject_cse_1;
        ArrayAdapter adptr_name, adptr_day, adptr_time, adptr_class, adptr_subject, arr_ad1;
        String name1;

        ArrayList list_subject_odd_cse_1, list_subject_odd_cse_3, list_subject_odd_cse_5, list_subject_odd_cse_7;
        ArrayList list_subject_even_cse_2, list_subject_even_cse_4, list_subject_even_cse_6, list_subject_even_cse_8;
        ArrayList list_subject_odd_civil_1, list_subject_odd_civil_3, list_subject_odd_civil_5, list_subject_odd_civil_7;
        ArrayList list_subject_even_civil_2, list_subject_even_civil_4, list_subject_even_civil_6, list_subject_even_civil_8;
        ArrayList list_subject_odd_ece_1, list_subject_odd_ece_3, list_subject_odd_ece_5, list_subject_odd_ece_7;
        ArrayList list_subject_even_ece_2, list_subject_even_ece_4, list_subject_even_ece_6, list_subject_even_ece_8;
        ArrayList list_subject_odd_dse_1, list_subject_odd_dse_3, list_subject_odd_dse_5, list_subject_odd_dse_7;
        ArrayList list_subject_even_dse_2, list_subject_even_dse_4, list_subject_even_dse_6, list_subject_even_dse_8;
        ArrayList list_subject_odd_ee_1, list_subject_odd_ee_3, list_subject_odd_ee_5, list_subject_odd_ee_7;
        ArrayList list_subject_even_ee_2, list_subject_even_ee_4, list_subject_even_ee_6, list_subject_even_ee_8;
        ArrayList list_subject_odd_me_1, list_subject_odd_me_3, list_subject_odd_me_5, list_subject_odd_me_7;
        ArrayList list_subject_even_me_2, list_subject_even_me_4, list_subject_even_me_6, list_subject_even_me_8;
        String url1="https://aptechfatehabad.com/ashish_facultynames.php";
        String url2="https://aptechfatehabad.com/ashish_faculty.php";
        String s1, s2, s3, s4;
        RadioButton r1_even, r2_odd;

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.staff5_2);
            name_spin = findViewById(R.id.name_spin);
            day_spin = findViewById(R.id.day_spin);
            time_spin = findViewById(R.id.time_spin);
            class_spin = findViewById(R.id.class_spin);
            subject_spin = findViewById(R.id.subject_spin);
            r1_even = findViewById(R.id.r1_even);
            r2_odd = findViewById(R.id.r2_odd);


            list_name = new ArrayList();
            list_day = new ArrayList();
            list_class_odd = new ArrayList();
            list_class_even = new ArrayList();
            list_time = new ArrayList();
            list_subject = new ArrayList();

            //--------------CSE--------------

            list_subject_odd_cse_1 = new ArrayList();
            list_subject_odd_cse_3 = new ArrayList();
            list_subject_odd_cse_5 = new ArrayList();
            list_subject_odd_cse_7 = new ArrayList();

            list_subject_even_cse_2 = new ArrayList();
            list_subject_even_cse_4 = new ArrayList();
            list_subject_even_cse_6 = new ArrayList();
            list_subject_even_cse_8 = new ArrayList();

            //----------------Civil------------

            list_subject_odd_civil_1 = new ArrayList();
            list_subject_odd_civil_3 = new ArrayList();
            list_subject_odd_civil_5 = new ArrayList();
            list_subject_odd_civil_7 = new ArrayList();

            list_subject_even_civil_2 = new ArrayList();
            list_subject_even_civil_4 = new ArrayList();
            list_subject_even_civil_6 = new ArrayList();
            list_subject_even_civil_8 = new ArrayList();

            //---------------ECE--------------

            list_subject_odd_ece_1 = new ArrayList();
            list_subject_odd_ece_3 = new ArrayList();
            list_subject_odd_ece_5 = new ArrayList();
            list_subject_odd_ece_7 = new ArrayList();

            list_subject_even_ece_2 = new ArrayList();
            list_subject_even_ece_4 = new ArrayList();
            list_subject_even_ece_6 = new ArrayList();
            list_subject_even_ece_8 = new ArrayList();

            //---------------DS-CSE-----------

            list_subject_odd_dse_1 = new ArrayList();
            list_subject_odd_dse_3 = new ArrayList();
            list_subject_odd_dse_5 = new ArrayList();
            list_subject_odd_dse_7 = new ArrayList();

            list_subject_even_dse_2 = new ArrayList();
            list_subject_even_dse_4 = new ArrayList();
            list_subject_even_dse_6 = new ArrayList();
            list_subject_even_dse_8 = new ArrayList();


            //---------------EE--------------

            list_subject_odd_ee_1 = new ArrayList();
            list_subject_odd_ee_3 = new ArrayList();
            list_subject_odd_ee_5 = new ArrayList();
            list_subject_odd_ee_7 = new ArrayList();

            list_subject_even_ee_2 = new ArrayList();
            list_subject_even_ee_4 = new ArrayList();
            list_subject_even_ee_6 = new ArrayList();
            list_subject_even_ee_8 = new ArrayList();


            //---------------ME--------------

            list_subject_odd_me_1 = new ArrayList();
            list_subject_odd_me_3 = new ArrayList();
            list_subject_odd_me_5 = new ArrayList();
            list_subject_odd_me_7 = new ArrayList();

            list_subject_even_me_2 = new ArrayList();
            list_subject_even_me_4 = new ArrayList();
            list_subject_even_me_6 = new ArrayList();
            list_subject_even_me_8 = new ArrayList();

            //---------------Name--------------


            //----------------Day---------------

            list_day.add("Monday");
            list_day.add("Tuesday");
            list_day.add("Wednesday");
            list_day.add("Thursday");
            list_day.add("Friday");


            //---------------Time----------------

            list_time.add("09:00-10:00");
            list_time.add("10:00-11:00");
            list_time.add("11:00-12:00");
            list_time.add("12:40-01:40");
            list_time.add("01:40-02:40");
            list_time.add("02:40-03:40");
            list_time.add("03:40-05:00");


            //-----------------Classes odd Semester--------------

            list_class_odd.add("Computer Science Engineering(1st sem)");
            list_class_odd.add("Computer Science Engineering(3rd sem)");
            list_class_odd.add("Computer Science Engineering(5th sem)");
            list_class_odd.add("Computer Science Engineering(7th sem)");

            list_class_odd.add("Cse(DataScience)(1st sem)");
            list_class_odd.add("Cse(DataScience)(3rd sem)");
            list_class_odd.add("Cse(DataScience)(5th sem)");
            list_class_odd.add("Cse(DataScience)(7th sem)");

            list_class_odd.add("Civil Engineering(1st sem)");
            list_class_odd.add("Civil Engineering(3rd sem)");
            list_class_odd.add("Civil Engineering(5th sem)");
            list_class_odd.add("Civil Engineering(7th sem)");

            list_class_odd.add("Electrical Communication and Engineering(1st sem)");
            list_class_odd.add("Electrical Communication and Engineering(3rd sem)");
            list_class_odd.add("Electrical Communication and Engineering(5th sem)");
            list_class_odd.add("Electrical Communication and Engineering(7th sem)");

            list_class_odd.add("Electrical Engineering(1st sem)");
            list_class_odd.add("Electrical Engineering(3rd sem)");
            list_class_odd.add("Electrical Engineering(5th sem)");
            list_class_odd.add("Electrical Engineering(7th sem)");

            list_class_odd.add("Mechanical Engineering(1st sem)");
            list_class_odd.add("Mechanical Engineering(3rd sem)");
            list_class_odd.add("Mechanical Engineering(5th sem)");
            list_class_odd.add("Mechanical Engineering(7th sem)");


            //-----------------Classes Even Semester--------------

            list_class_even.add("Computer Science Engineering(2nd sem)");
            list_class_even.add("Computer Science Engineering(4th sem)");
            list_class_even.add("Computer Science Engineering(6th sem)");
            list_class_even.add("Computer Science Engineering(8th sem)");

            list_class_even.add("Cse(DataScience)(2nd sem)");
            list_class_even.add("Cse(DataScience)(4th sem)");
            list_class_even.add("Cse(DataScience)(6th sem)");
            list_class_even.add("Cse(DataScience)(8th sem)");

            list_class_even.add("Civil Engineering(2nd sem)");
            list_class_even.add("Civil Engineering(4th sem)");
            list_class_even.add("Civil Engineering(6th sem)");
            list_class_even.add("Civil Engineering(8th sem)");

            list_class_even.add("Electrical Communication and Engineering(2nd sem)");
            list_class_even.add("Electrical Communication and Engineering(4th sem)");
            list_class_even.add("Electrical Communication and Engineering(6th sem)");
            list_class_even.add("Electrical Communication and Engineering(8th sem)");

            list_class_even.add("Electrical Engineering(2nd sem)");
            list_class_even.add("Electrical Engineering(4th sem)");
            list_class_even.add("Electrical Engineering(6th sem)");
            list_class_even.add("Electrical Engineering(8th sem)");

            list_class_even.add("Mechanical Engineering(2nd sem)");
            list_class_even.add("Mechanical Engineering(4th sem)");
            list_class_even.add("Mechanical Engineering(6th sem)");
            list_class_even.add("Mechanical Engineering(8th sem)");


            //--------------------List CSE Odd Subjects----------------

            //------------------CSE-1---------------------------

            list_subject_odd_cse_1.add("Engineering Chemistry");
            list_subject_odd_cse_1.add("Engineering Mathematics I");
            list_subject_odd_cse_1.add("Programming Problem Solving using C Programming");
            list_subject_odd_cse_1.add("English");

            //------------------CSE-3----------------------------

            list_subject_odd_cse_3.add("Data Structure & Algorithms");
            list_subject_odd_cse_3.add("Engineering Mathematics III");
            list_subject_odd_cse_3.add("Computer Organisation & Architecture");
            list_subject_odd_cse_3.add("Object Oriented Programming using C++");
            list_subject_odd_cse_3.add("Discrete Mathematics");
            list_subject_odd_cse_3.add("Analog Electronic Circuits");
            list_subject_odd_cse_3.add("Environmental Science");

            //-------------------CSE-5--------------------------

            list_subject_odd_cse_5.add("Computer Graphics");
            list_subject_odd_cse_5.add("Cryptography & Network Security");
            list_subject_odd_cse_5.add("High Speed Network");
            list_subject_odd_cse_5.add("Python Programming");
            list_subject_odd_cse_5.add("Economics for Engineers");
            list_subject_odd_cse_5.add("Digital Electronics");
            list_subject_odd_cse_5.add("Essensce of Indian Traditional Knowledge");

            //-------------------CSE-7-------------------------

            list_subject_odd_cse_7.add("Neural Networks");
            list_subject_odd_cse_7.add("Open Elective-I");
            list_subject_odd_cse_7.add("Software Project / Minor Project");
            list_subject_odd_cse_7.add("Laboratory / Practical");
            list_subject_odd_cse_7.add("Elective-II");


            //--------------------List CSE Subject Even----------------

            //------------------CSE-2---------------------------

            list_subject_even_cse_2.add("Physics");
            list_subject_even_cse_2.add("Engineering Mathematics II");
            list_subject_even_cse_2.add("Workshop Practice");
            list_subject_even_cse_2.add("Basic Electrical Engineering");

            //------------------CSE-4----------------------------

            list_subject_even_cse_4.add("Computer Networks");
            list_subject_even_cse_4.add("Software Engineering");
            list_subject_even_cse_4.add("DataBase Management System");
            list_subject_even_cse_4.add("Java Programming");
            list_subject_even_cse_4.add("Microprocessor & Interface");

            //-------------------CSE-6--------------------------

            list_subject_even_cse_6.add("Machine Learning");
            list_subject_even_cse_6.add("Compiler Design");
            list_subject_even_cse_6.add("Network Security");
            list_subject_even_cse_6.add("Elective-II");
            list_subject_even_cse_6.add("Project Work");

            //-------------------CSE-8-------------------------

            list_subject_even_cse_8.add("Internet of Things");
            list_subject_even_cse_8.add("Software Project Management");
            list_subject_even_cse_8.add("Elective-IV");
            list_subject_even_cse_8.add("Web Development");
            list_subject_even_cse_8.add("Artificial Intelligence");


            //--------------------List Civil Odd Subjects----------------

            //------------------Civil-1---------------------------

            list_subject_odd_civil_1.add("Engineering Chemistry");
            list_subject_odd_civil_1.add("Engineering Mathematics I");
            list_subject_odd_civil_1.add("Engineering Physics");
            list_subject_odd_civil_1.add("Engineering Drawing");

            //------------------Civil-3----------------------------

            list_subject_odd_civil_3.add("Data Structures");
            list_subject_odd_civil_3.add("Mathematics III");
            list_subject_odd_civil_3.add("Thermodynamics");
            list_subject_odd_civil_3.add("Digital Electronics");
            list_subject_odd_civil_3.add("Mechanics of Solids");


            //-------------------Civil-5--------------------------

            list_subject_odd_civil_5.add("Fluid Mechanics");
            list_subject_odd_civil_5.add("Discrete Mathematics");
            list_subject_odd_civil_5.add("Microprocessors and Microcontrollers");
            list_subject_odd_civil_5.add("VLSI Design");
            list_subject_odd_civil_5.add("Power System");


            //-------------------Civil-7-------------------------

            list_subject_odd_civil_7.add("Design of Steel Structure-II");
            list_subject_odd_civil_7.add("Open Elective-II");
            list_subject_odd_civil_7.add("Water Resources Engineering-II");
            list_subject_odd_civil_7.add("Environmental Engineering-II");
            list_subject_odd_civil_7.add("Industrial Training");


            //--------------------List Civil Subject Even----------------

            //------------------Civil-2---------------------------

            list_subject_even_civil_2.add("Mathematics-II");
            list_subject_even_civil_2.add("Programming in C");
            list_subject_even_civil_2.add("Engineering Graphics");
            list_subject_even_civil_2.add("Basic Electrical Engineering");

            //------------------Civil-4----------------------------

            list_subject_even_civil_4.add("Engineering Materials");
            list_subject_even_civil_4.add("Engineering Machines");
            list_subject_even_civil_4.add("Mathematics-IV");
            list_subject_even_civil_4.add("Microprocessor & Interface");

            //-------------------Civil-6--------------------------

            list_subject_even_civil_6.add("Structural Analysis-II");
            list_subject_even_civil_6.add("Design of Steel Structure");
            list_subject_even_civil_6.add("Elective-II");
            list_subject_even_civil_6.add("Project Work");

            //-------------------Civil-8-------------------------

            list_subject_even_civil_8.add("Construction Management");
            list_subject_even_civil_8.add("Advance Structural Design");
            list_subject_even_civil_8.add("Pavement Materials");
            list_subject_even_civil_8.add("Industrial Materials");


            //--------------------List ECE Odd Subjects----------------

            //------------------ECE-1---------------------------

            list_subject_odd_ece_1.add("Human Values and Professional Ethics");
            list_subject_odd_ece_1.add("Engineering Physics");
            list_subject_odd_ece_1.add("Engineering Mathematics I");
            list_subject_odd_ece_1.add("Basic Electrical Engineering");
            list_subject_odd_ece_1.add("Communicative English");

            //------------------ECE-3----------------------------

            list_subject_odd_ece_3.add("Signals and Systems");
            list_subject_odd_ece_3.add("Mathematics III");
            list_subject_odd_ece_3.add("Electromagnetism");
            list_subject_odd_ece_3.add("Digital Logic Design");
            list_subject_odd_ece_3.add("Analog Electronics");


            //-------------------ECE-5--------------------------

            list_subject_odd_ece_5.add("Analog and Digital Communication");
            list_subject_odd_ece_5.add("Digital Signal Processing");
            list_subject_odd_ece_5.add("Linear Integrated Circuits");
            list_subject_odd_ece_5.add("Control System");
            list_subject_odd_ece_5.add("Minor Project(Part-I)");
            list_subject_odd_ece_5.add("Professional Elective-I");


            //-------------------ECE-7-------------------------

            list_subject_odd_ece_7.add("Computer Networks");
            list_subject_odd_ece_7.add("Embedded Systems");
            list_subject_odd_ece_7.add("Optical Communication");
            list_subject_odd_ece_7.add("Major Project(Part-I)");
            list_subject_odd_ece_7.add("Low Power Circuit Design");
            list_subject_odd_ece_7.add("Industrial Automation");


            //--------------------List ECE Subject Even----------------

            //------------------ECE-2---------------------------

            list_subject_even_ece_2.add("Mathematics-II");
            list_subject_even_ece_2.add("Programming in C");
            list_subject_even_ece_2.add("Engineering Graphics and Design");
            list_subject_even_ece_2.add("Programming for Problem");

            //------------------ECE-4----------------------------

            list_subject_even_ece_4.add("Linear Control System");
            list_subject_even_ece_4.add("Electromagnetics and Antennas");
            list_subject_even_ece_4.add("Electromagnetics Measurement and Instrumentation");
            list_subject_even_ece_4.add("Analog Communication System");

            //-------------------ECE-6--------------------------

            list_subject_even_ece_6.add("Wireless Communication");
            list_subject_even_ece_6.add("Microwaves Engineering");
            list_subject_even_ece_6.add("VLSI Design");
            list_subject_even_ece_6.add("Minor Project(Part II)");
            list_subject_even_ece_6.add("Engineering Economics & Industrial Management");

            //-------------------ECE-8-------------------------

            list_subject_even_ece_8.add("Major Project(Part-II)");
            list_subject_even_ece_8.add("Professional Elective-III");
            list_subject_even_ece_8.add("Open Elective-II");


            //--------------------List DSE Odd Subjects----------------

            //------------------DSE-1---------------------------

            list_subject_odd_dse_1.add("Engineering Mathematics");
            list_subject_odd_dse_1.add("Engineering Mathematics I");
            list_subject_odd_dse_1.add("Programming Problem Solving using C Programming");
            list_subject_odd_dse_1.add("Engineering Graphics & Design");

            //------------------DSE-3----------------------------

            list_subject_odd_dse_3.add("Database Management Systems (DBMS)");
            list_subject_odd_dse_3.add("Engineering Mathematics III");
            list_subject_odd_dse_3.add("Computer Organisation & Architecture");
            list_subject_odd_dse_3.add("Object Oriented Programming using C++");
            list_subject_odd_dse_3.add("Discrete Mathematics");
            list_subject_odd_dse_3.add("Computer Networks");
            list_subject_odd_dse_3.add("Design and Analysis of Algorithms");

            //-------------------DSE-5--------------------------

            list_subject_odd_dse_5.add("Operating Systems");
            list_subject_odd_dse_5.add("Artificial Intelligence");
            list_subject_odd_dse_5.add("Software Engineering");
            list_subject_odd_dse_5.add("Professional Elective (II)");
            list_subject_odd_dse_5.add("Economics for Engineers");

            //-------------------DSE-7-------------------------

            list_subject_odd_dse_7.add("Data Mining and Warehousing");
            list_subject_odd_dse_7.add("Big Data Analytics");
            list_subject_odd_dse_7.add("Software Project / Minor Project");
            list_subject_odd_dse_7.add("Information Security");


            //--------------------List DSE Subject Even----------------

            //------------------DSE-2---------------------------

            list_subject_even_dse_2.add("Data Structures and Algorithms");
            list_subject_even_dse_2.add("Engineering Mathematics II");
            list_subject_even_dse_2.add("Object-Oriented Programming (OOP)");
            list_subject_even_dse_2.add("Basic Electrical Engineering");
            list_subject_even_dse_2.add("Digital Electronics");


            //------------------DSE-4----------------------------

            list_subject_even_dse_4.add("Python Programming");
            list_subject_even_dse_4.add("Software Engineering");
            list_subject_even_dse_4.add("Cryptography Network & Security");
            list_subject_even_dse_4.add("Java Programming");
            list_subject_even_dse_4.add("Microprocessor & Interface");

            //-------------------DSE-6--------------------------

            list_subject_even_dse_6.add("Big Data Analytics");
            list_subject_even_dse_6.add("Compiler Design");
            list_subject_even_dse_6.add("Machine Learning");
            list_subject_even_dse_6.add("Elective-II");
            list_subject_even_dse_6.add("Cloud Computing");

            //-------------------DSE-8-------------------------

            list_subject_even_dse_8.add("Major Project (Phase II)");
            list_subject_even_dse_8.add("Professional Elective");
            list_subject_even_dse_8.add("Open Elective");


            //--------------------List EE Odd Subjects----------------

            //------------------EE-1---------------------------

            list_subject_odd_ee_1.add("Basic Electrical Engineering");
            list_subject_odd_ee_1.add("Engineering Physics");
            list_subject_odd_ee_1.add("Engineering Mathematics I");
            list_subject_odd_ee_1.add("Basic Electrical Engineering");
            list_subject_odd_ee_1.add("Programming for Problem Solving");

            //------------------EE-3----------------------------

            list_subject_odd_ee_3.add("Electrical Circuit Analysis:");
            list_subject_odd_ee_3.add("Mathematics III");
            list_subject_odd_ee_3.add("Electromagnetism");
            list_subject_odd_ee_3.add("Electrical and Electronics Measurements");
            list_subject_odd_ee_3.add("Analog Electronics");


            //-------------------EE-5--------------------------

            list_subject_odd_ee_5.add("Power System-I");
            list_subject_odd_ee_5.add("Electrical Machines-II");
            list_subject_odd_ee_5.add("Linear Integrated Circuits");
            list_subject_odd_ee_5.add("Control System");
            list_subject_odd_ee_5.add("Microprocessors & Microcontrollers");


            //-------------------EE-7-------------------------

            list_subject_odd_ee_7.add("Power System-II");
            list_subject_odd_ee_7.add("Power Electronics");
            list_subject_odd_ee_7.add("Optical Communication");
            list_subject_odd_ee_7.add("High Voltage Engineering");
            list_subject_odd_ee_7.add("Low Power Circuit Design");


            //--------------------List EE Subject Even----------------

            //------------------EE-2---------------------------

            list_subject_even_ee_2.add("Mathematics-II");
            list_subject_even_ee_2.add("Engineering Mechanics");
            list_subject_even_ee_2.add("Basic Electronics Engineering");
            list_subject_even_ee_2.add("Electrical Machines");

            //------------------EE-4----------------------------

            list_subject_even_ee_4.add("Linear Control System");
            list_subject_even_ee_4.add("Power Electronics");
            list_subject_even_ee_4.add("Digital Electronics");
            list_subject_even_ee_4.add("Control Systems");

            //-------------------EE-6--------------------------

            list_subject_even_ee_6.add("Wireless Communication");
            list_subject_even_ee_6.add("Electrical Drives");
            list_subject_even_ee_6.add("High Voltage Engineering");
            list_subject_even_ee_6.add("Engineering Economics & Industrial Management");

            //-------------------EE-8-------------------------

            list_subject_even_ee_8.add("Major Project(Part-II)");
            list_subject_even_ee_8.add("Professional Elective-III");
            list_subject_even_ee_8.add("Open Elective-II");


            //--------------------List ME Odd Subjects----------------
            //------------------ME-1---------------------------

            list_subject_odd_me_1.add("Engineering Physics");
            list_subject_odd_me_1.add("Engineering Mathematics I");
            list_subject_odd_me_1.add("Basic Electrical Engineering");
            list_subject_odd_me_1.add("Programming for Problem Solving");
            //------------------ME-3----------------------------
            list_subject_odd_me_3.add("Thermodynamics");
            list_subject_odd_me_3.add("Mathematics III");
            list_subject_odd_me_3.add("Fluid Mechanics");
            list_subject_odd_me_3.add("Manufacturing Processes");
            list_subject_odd_me_3.add("Machine Drawing");
            //-------------------ME-5--------------------------
            list_subject_odd_me_5.add("Heat Transfer");
            list_subject_odd_me_5.add("Machine Design-I:");
            list_subject_odd_me_5.add("Theory of Machines-II");
            list_subject_odd_me_5.add("Fluid Machines");
            //-------------------ME-7-------------------------
            list_subject_odd_me_7.add("Refrigeration and Air Conditioning (RAC)");
            list_subject_odd_me_7.add("Computer-Aided Design and Manufacturing (CAD/CAM)");
            list_subject_odd_me_7.add("Automobile Engineering");
            list_subject_odd_me_7.add("Power Plant Engineering");

            //--------------------List ME Subject Even----------------

            //------------------ME-2---------------------------
            list_subject_even_me_2.add("Mathematics-II");
            list_subject_even_me_2.add("Engineering Mechanics");
            list_subject_even_me_2.add("Basic Electrical Engineering");
            list_subject_even_me_2.add("Basic Electronics Engineering");
            //------------------ME-4----------------------------
            list_subject_even_me_4.add("Linear Control System");
            list_subject_even_me_4.add("Theory of Machines-I");
            list_subject_even_me_4.add("Manufacturing Processes-II");
            list_subject_even_me_4.add("Applied Thermodynamics");
            //-------------------ME-6--------------------------
            list_subject_even_me_6.add("Internal Combustion Engines (ICE)");
            list_subject_even_me_6.add("Machine Design-II");
            list_subject_even_me_6.add("Heat and Mass Transfer");
            list_subject_even_me_6.add("Automobile Engineering");
            //-------------------ME-8-------------------------
            list_subject_even_me_8.add("Major Project(Part-II)");
            list_subject_even_me_8.add("Professional Elective-III");
            list_subject_even_me_8.add("Open Elective-II");


            adptr_name = new ArrayAdapter<>(this, R.layout.text1, list_name);
            name_spin.setAdapter(adptr_name);

            StringRequest sr_obj = new StringRequest(Request.Method.POST, url1, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONArray array = new JSONArray(response);


                        for (int i = 0; i < array.length(); i++) {
                            JSONObject js_obj = array.getJSONObject(i);

                            list_name.add(js_obj.getString("uname"));
                        }
                        adptr_name.notifyDataSetChanged(); // spinner ko refresh karo

                    } catch (Exception e) {
                        Toast.makeText(staff5_2.this, e.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(staff5_2.this, "Error2", Toast.LENGTH_SHORT).show();
                }
            }) {
                @Nullable
                @Override
                protected Map<String, String> getParams() {
                    HashMap<String, String> param_obj = new HashMap<String, String>();
                    return param_obj;
                }
            };
            RequestQueue rq_obj = Volley.newRequestQueue(this);
            rq_obj.add(sr_obj);


            //---------------------Adapter Name----------------



            name_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    s1 = name_spin.getItemAtPosition(position).toString();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });


            //---------------------Adapter Day-------------------

            adptr_day = new ArrayAdapter(this, R.layout.text1, list_day);
            day_spin.setAdapter(adptr_day);

            day_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    s1 = day_spin.getItemAtPosition(position).toString();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });


            //----------------------Adapter Time-----------------

            adptr_time = new ArrayAdapter(this, R.layout.text1, list_time);
            time_spin.setAdapter(adptr_time);

            time_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    s1 = time_spin.getItemAtPosition(position).toString();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });


            //---------------------Adapter Class-CSE-----------------
            //---------------------Adapter Subject-CSE---------------


        }


        //----------------------------Back Button----------------------

        public void back_button5_2(View v){
            overridePendingTransition(R.anim.slide,R.anim.slide2);
           finish();

        }






        //---------------------------------------Odd Method---------------------------------------
        public void odd(View v) {
            adptr_class = new ArrayAdapter(this, R.layout.text1, list_class_odd);
            class_spin.setAdapter(adptr_class);

            class_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    s2 = class_spin.getItemAtPosition(position).toString();

                    //-------------------CSE-Odd-Sem--------------

                    if (s2.equals("Computer Science Engineering(1st sem)")) {
                        adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_odd_cse_1);
                    } else if (s2.equals("Computer Science Engineering(3rd sem)")) {
                        adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_odd_cse_3);
                    } else if (s2.equals("Computer Science Engineering(5th sem)")) {
                        adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_odd_cse_5);
                    } else if (s2.equals("Computer Science Engineering(7th sem)")) {
                        adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_odd_cse_7);
                    }

                    //---------------------Civil-Odd-Sem------------------

                    else if (s2.equals("Civil Engineering(1st sem)")) {
                        adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_odd_civil_1);
                    } else if (s2.equals("Civil Engineering(3rd sem)")) {
                        adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_odd_civil_3);
                    } else if (s2.equals("Civil Engineering(5th sem)")) {
                        adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_odd_civil_5);
                    } else if (s2.equals("Civil Engineering(7th sem)")) {
                        adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_odd_civil_7);
                    }

                    //---------------------ECE-Odd-Sem--------------------

                    else if (s2.equals("Electrical Communication and Engineering(1st sem)")) {
                        adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_odd_ece_1);
                    } else if (s2.equals("Electrical Communication and Engineering(3rd sem)")) {
                        adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_odd_ece_3);
                    } else if (s2.equals("Electrical Communication and Engineering(5th sem)")) {
                        adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_odd_ece_5);
                    } else if (s2.equals("Electrical Communication and Engineering(7th sem)")) {
                        adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_odd_ece_7);
                    }

                    //---------------------DS-CSE-Odd-Sem------------------

                    else if (s2.equals("Cse(DataScience)(1st sem)")) {
                        adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_odd_dse_1);
                    } else if (s2.equals("Cse(DataScience)(3rd sem)")) {
                        adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_odd_dse_3);
                    } else if (s2.equals("Cse(DataScience)(5th sem)")) {
                        adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_odd_dse_5);
                    } else if (s2.equals("Cse(DataScience)(7th sem)")) {
                        adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_odd_dse_7);
                    }


                    //---------------------EE-Odd-Sem--------------------

                    else if (s2.equals("Electrical Engineering(1st sem)")) {
                        adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_odd_ee_1);
                    } else if (s2.equals("Electrical Engineering(3rd sem)")) {
                        adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_odd_ee_3);
                    } else if (s2.equals("Electrical Engineering(5th sem)")) {
                        adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_odd_ee_5);
                    } else if (s2.equals("Electrical Engineering(7th sem)")) {
                        adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_odd_ee_7);
                    }


                    //---------------------ME-Odd-Sem--------------------

                    else if (s2.equals("Mechanical Engineering(1st sem)")) {
                        adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_odd_me_1);
                    } else if (s2.equals("Mechanical Engineering(3rd sem)")) {
                        adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_odd_me_3);
                    } else if (s2.equals("Mechanical Engineering(5th sem)")) {
                        adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_odd_me_5);
                    } else if (s2.equals("Mechanical Engineering(7th sem)")) {
                        adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_odd_me_7);
                    }


                    else {
                        Toast.makeText(staff5_2.this, "Error in Odd", Toast.LENGTH_SHORT).show();
                    }

                    subject_spin.setAdapter(adptr_subject);

                    subject_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            s3 = subject_spin.getItemAtPosition(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }

        //---------------------------------------Even Method----------------------------------
            public void even(View v) {

                adptr_class = new ArrayAdapter(this, R.layout.text1, list_class_even);
                class_spin.setAdapter(adptr_class);

                class_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        s2 = class_spin.getItemAtPosition(position).toString();

                        //------------------------CSE-Even-Sem---------------

                        if (s2.equals("Computer Science Engineering(2nd sem)")) {
                            adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_even_cse_2);
                        } else if (s2.equals("Computer Science Engineering(4th sem)")) {
                            adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_even_cse_4);
                        } else if (s2.equals("Computer Science Engineering(6th sem)")) {
                            adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_even_cse_6);
                        } else if (s2.equals("Computer Science Engineering(8th sem)")) {
                            adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_even_cse_8);
                        }

                        //-----------------------Civil-Even-Sem---------------

                        else if (s2.equals("Civil Engineering(2nd sem)")) {
                            adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_even_civil_2);
                        } else if (s2.equals("Civil Engineering(4th sem)")) {
                            adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_even_civil_4);
                        } else if (s2.equals("Civil Engineering(6th sem)")) {
                            adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_even_civil_6);
                        } else if (s2.equals("Civil Engineering(8th sem)")) {
                            adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_even_civil_8);
                        }

                        //------------------------ECE-Even-Sem-----------------

                        else if (s2.equals("Electrical Communication and Engineering(2nd sem)")) {
                            adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_even_dse_2);
                        } else if (s2.equals("Electrical Communication and Engineering(4th sem)")) {
                            adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_even_dse_4);
                        } else if (s2.equals("Electrical Communication and Engineering(6th sem)")) {
                            adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_even_dse_6);
                        } else if (s2.equals("Electrical Communication and Engineering(8th sem)")) {
                            adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_even_dse_8);
                        }

                        //-----------------------DS-CSE-Even-Sem-----------------

                        else if (s2.equals("Cse(DataScience)(2nd sem)")) {
                            adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_even_dse_2);
                        } else if (s2.equals("Cse(DataScience)(4th sem)")) {
                            adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_even_dse_4);
                        } else if (s2.equals("Cse(DataScience)(6th sem)")) {
                            adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_even_dse_6);
                        } else if (s2.equals("Cse(DataScience)(8th sem)")) {
                            adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_even_dse_8);
                        }


                        //------------------------EE-Even-Sem-----------------

                        else if (s2.equals("Electrical Engineering(2nd sem)")) {
                            adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_even_ee_2);
                        } else if (s2.equals("Electrical Engineering(4th sem)")) {
                            adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_even_ee_4);
                        } else if (s2.equals("Electrical Engineering(6th sem)")) {
                            adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_even_ee_6);
                        } else if (s2.equals("Electrical Engineering(8th sem)")) {
                            adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_even_ee_8);
                        }


                        //------------------------ME-Even-Sem-----------------

                        else if (s2.equals("Mechanical Engineering(2nd sem)")) {
                            adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_even_me_2);
                        } else if (s2.equals("Mechanical Engineering(4th sem)")) {
                            adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_even_me_4);
                        } else if (s2.equals("Mechanical Engineering(6th sem)")) {
                            adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_even_me_6);
                        } else if (s2.equals("Mechanical Engineering(8th sem)")) {
                            adptr_subject = new ArrayAdapter(staff5_2.this, R.layout.text1, list_subject_even_me_8);
                        }


                        else {
                            Toast.makeText(staff5_2.this, "Error in Even", Toast.LENGTH_SHORT).show();
                        }
                        subject_spin.setAdapter(adptr_subject);
                        subject_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                s3 = subject_spin.getItemAtPosition(position).toString();
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {
                            }
                        });
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }



        //------------------------------Save Button---------------------

        public void save1(View v){
            String name1,day1,time1,class1,subject1;

            name1=name_spin.getSelectedItem().toString();
            day1=day_spin.getSelectedItem().toString();
            time1=time_spin.getSelectedItem().toString();
            class1=class_spin.getSelectedItem().toString();
            subject1=subject_spin.getSelectedItem().toString();


            StringRequest sr_obj=new StringRequest(Request.Method.POST, url2, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Toast.makeText(staff5_2.this, "Saved Successfully", Toast.LENGTH_SHORT).show();
                }
            },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(staff5_2.this, "Error Something!", Toast.LENGTH_SHORT).show();
                        }
                    })
            {
                @Nullable
                @Override
                protected Map<String, String> getParams(){
                    HashMap<String,String> param_obj=new HashMap<String,String>();
                    param_obj.put("fname",name1);
                    param_obj.put("day",day1);
                    param_obj.put("time",time1);
                    param_obj.put("fclass",class1);
                    param_obj.put("subject",subject1);
                    return param_obj;
                }
            };
            RequestQueue rq_obj= Volley.newRequestQueue(this);
            rq_obj.add(sr_obj);


        }




        //---------------------Adapter Subject-----------------





            /*adptr_subject=new ArrayAdapter(this,R.layout.text1,list_subject);
            subject_spin.setAdapter(adptr_subject);

            subject_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    s1=subject_spin.getItemAtPosition(position).toString();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });*/

    }


