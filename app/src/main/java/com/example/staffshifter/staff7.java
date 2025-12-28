package com.example.staffshifter;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;

import android.os.Bundle;
import android.view.View;

import android.widget.DatePicker;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


public class staff7 extends Activity {
    TextView et1_date;
    EditText et1_notice,et1_subject;
    int year,month,day;
    String ndate1,notice1,nsubject1;
    String url1="https://aptechfatehabad.com/ashish_notice.php";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.staff7); // ✅ fixed
        et1_date = findViewById(R.id.et1_date);
        et1_notice=findViewById(R.id.et1_notice);
        et1_subject=findViewById(R.id.et1_subject);

        Calendar cal_obj = Calendar.getInstance();
        year = cal_obj.get(Calendar.YEAR);
        month = cal_obj.get(Calendar.MONTH);
        day = cal_obj.get(Calendar.DAY_OF_MONTH);


    }

    public void f1_date(View v){
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
    }
}