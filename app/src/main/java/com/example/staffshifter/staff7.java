package com.example.staffshifter;

import android.Manifest;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;

import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

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
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


public class staff7 extends Activity {

    Spinner name_spin;
    ArrayList list_name;
    TextView t1_faculty;
    String name1,f_name1,pass1,email1,phone1,dob1,gender1;
    TextView t1_Name2,t1_fname2,t1_pass2,t1_email2,t1_phone2,t1_dob2,t1_gender2;
    ArrayAdapter adptr_name;
    String url1 = "https://aptechfatehabad.com/ashish_facultynames.php";
    String url2 = "https://aptechfatehabad.com/ashish_detail.php";
    String name2;

    /*TextView et1_date;
    EditText et1_notice,et1_subject;
    int year,month,day;
    String ndate1,notice1,nsubject1;
   String url1="https://aptechfatehabad.com/ashish_notice.php";*/

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.staff7);
        name_spin = findViewById(R.id.name_spin);
        t1_Name2=findViewById(R.id.t1_Name2);
        t1_fname2=findViewById(R.id.t1_fname2);
        t1_pass2=findViewById(R.id.t1_pass2);
        t1_email2=findViewById(R.id.t1_email2);
        t1_phone2=findViewById(R.id.t1_phone2);
        t1_dob2=findViewById(R.id.t1_dob2);
        t1_gender2=findViewById(R.id.t1_gender2);


        list_name = new ArrayList<>();
        t1_faculty=findViewById(R.id.t1_faculty);

        // Spinner adapter
        adptr_name = new ArrayAdapter<>(this, R.layout.text1, list_name);
        name_spin.setAdapter(adptr_name);

        // Fetch faculty names for spinner
        fetchFacultyNames();

        // Spinner item listener
        name_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                name2 = name_spin.getSelectedItem().toString();
                t1_faculty.setText(name2);

                StringRequest sr_obj = new StringRequest(Request.Method.POST, url2,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {

                                    Log.d("RESPONSE_DATA", response);

                                    // Check if response is valid JSON
                                    if (response.trim().startsWith("<")) {
                                        Toast.makeText(staff7.this, "Invalid response from server", Toast.LENGTH_LONG).show();
                                        return;
                                    }

                                    JSONArray array = new JSONArray(response);

                                    for (int i = 0; i < array.length(); i++) {
                                        JSONObject js_obj = array.getJSONObject(i);

                                        if(js_obj.getString("uname").trim()
                                                .equalsIgnoreCase(name2.trim())) {

                                            t1_Name2.setText(js_obj.getString("uname"));
                                            t1_fname2.setText(js_obj.getString("fname"));
                                            t1_pass2.setText(js_obj.getString("pass"));
                                            t1_email2.setText(js_obj.getString("email"));
                                            t1_phone2.setText(js_obj.getString("phone"));
                                            t1_dob2.setText(js_obj.getString("dob"));
                                            t1_gender2.setText(js_obj.getString("gender"));
                                            break;
                                        }
                                    }


                                    phone1=t1_phone2.getText().toString();



                                } catch (Exception e) {
                                    Toast.makeText(staff7.this, "JSON Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(staff7.this, "Volley Error: " + error.toString(), Toast.LENGTH_SHORT).show();
                            }
                        }) {

                    @Nullable
                    @Override
                    protected Map<String, String> getParams() {
                        HashMap<String, String> param_obj = new HashMap<>();
                        return param_obj;
                    }
                };
                RequestQueue rq_obj=Volley.newRequestQueue(staff7.this);
                rq_obj.add(sr_obj);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }
    public void back_button5(View view) {
        overridePendingTransition(R.anim.slide, R.anim.slide2);
        finish();
    }




    public void fetchFacultyNames(){
        StringRequest sr_obj = new StringRequest(Request.Method.POST, url1,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            list_name.clear();
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject js_obj = array.getJSONObject(i);
                                list_name.add(js_obj.getString("uname"));
                            }
                            adptr_name.notifyDataSetChanged();
                        } catch (Exception e) {
                            Toast.makeText(staff7.this, "JSON Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(staff7.this, "Error fetching names", Toast.LENGTH_SHORT).show();
                    }
                });

        RequestQueue rq_obj = Volley.newRequestQueue(this);
        rq_obj.add(sr_obj);
    }


    //------------------Whatsapp--------------


    public void whatsapp(View v) {

        if (phone1 != null) {
            String message="Hello "+t1_Name2;
            Intent obj = new Intent(Intent.ACTION_VIEW);
            obj.setData(Uri.parse("http://wa.me/" + phone1 + "?text=" + Uri.encode(message)));
            startActivity(obj);
        }else{
            Toast.makeText(this, "Please select free faculty", Toast.LENGTH_SHORT).show();
        }
    }


    public void call(View v) {
        if (t1_phone2 != null) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                    != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CALL_PHONE}, 2);
                return;
            }

            Intent obj = new Intent(Intent.ACTION_CALL);
            obj.setData(Uri.parse("tel:" + phone1));
            startActivity(obj);
        }
    }
    public void email(View v) {

        String to = t1_email2.getText().toString().trim();

        if (!to.isEmpty()) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("message/rfc822"); // IMPORTANT
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
            intent.putExtra(Intent.EXTRA_SUBJECT, "StaffShifter App");
            intent.putExtra(Intent.EXTRA_TEXT, "Hello " + t1_Name2.getText().toString());

            try {
                startActivity(Intent.createChooser(intent, "Choose Email App"));
            } catch (Exception e) {
                Toast.makeText(this, "No email app found", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Email not available", Toast.LENGTH_SHORT).show();
        }
    }




}















    /*public void f1_date(View v){
        showDialog(0);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if(id==0){
            return new DatePickerDialog(this,obj2,year,month,day);
        }

        else
        return null;
    }

    // Pick the Date from Calendar

    DatePickerDialog.OnDateSetListener obj2=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            // month +1 because January = 0
            String month_format = String.format("%02d", month + 1);
            String day_format = String.format("%02d", dayOfMonth);

            // yyyy-MM-dd format
            et1_date.setText(year + "-" + month_format + "-" + day_format);
        }
    };



    public void apply(View v){
        ndate1=et1_date.getText().toString();
        notice1=et1_notice.getText().toString();
        nsubject1=et1_subject.getText().toString();


        StringRequest sr_obj=new StringRequest(Request.Method.POST, url1, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(staff7.this, "Applied Successfully", Toast.LENGTH_SHORT).show();
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(staff7.this, "Error_Response", Toast.LENGTH_SHORT).show();
                    }
                })
        {
            @Nullable
            @Override
            protected Map<String, String> getParams()  {
                HashMap<String,String> param_obj=new HashMap<String,String>();
                param_obj.put("ndate",ndate1);
                param_obj.put("notice",notice1);
                param_obj.put("subject",nsubject1);
                return param_obj;
            }
        };
        RequestQueue rq_obj= Volley.newRequestQueue(this);
        rq_obj.add(sr_obj);
    }

    public void back_button5(View view) {
        overridePendingTransition(R.anim.slide, R.anim.slide2);
        finish();
    }*/
