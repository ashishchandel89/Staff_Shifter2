package com.example.staffshifter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class staff3 extends Activity {
    TextView date2,t1_notice,t1_subject;
    String t2_date,t2_notice,t2_subject;
    String url1="https://aptechfatehabad.com/ashish_notice2.php";
    String url2="https://aptechfatehabad.com/ashish_absent.php";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.staff3);
        date2 = findViewById(R.id.date2);
        t1_notice = findViewById(R.id.t1_notice);
        t1_subject = findViewById(R.id.t1_subject);


        StringRequest sr_obj = new StringRequest(Request.Method.POST, url1, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);
                    if (array.length() > 0) {
                        JSONObject js_obj = array.getJSONObject(0);
                        t2_date = js_obj.getString("ndate");
                        t2_notice = js_obj.getString("notice");
                        t2_subject = js_obj.getString("subject");

                        date2.setText(t2_date);
                        t1_notice.setText(t2_notice);
                        t1_subject.setText(t2_subject);
                    } else {
                        t1_notice.setText("Have a nice day!");
                    }

                } catch (Exception e) {
                    Toast.makeText(staff3.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(staff3.this, "Error", Toast.LENGTH_SHORT).show();
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


        /*--------------------Latest staff adjustment-------------

            StringRequest sr_obj2 = new StringRequest(Request.Method.POST, url2, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                        JSONArray array = new JSONArray(response);

                        for (int i = 0; i < array.length(); i++) {
                            JSONObject js_obj = array.getJSONObject(i);
                        }
                    }

            },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(staff3.this, "error", Toast.LENGTH_SHORT).show();
                        }
                    }

            ) {
                HashMap<String, String> param_obj = new HashMap<String, String>();
            };
            RequestQueue rq_obj2 = Volley.newRequestQueue(this);
            rq_obj2.add(sr_obj2);*/
        }







    public void back_button3(View v){
        overridePendingTransition(R.anim.slide,R.anim.slide2);
        finish();
    }








    public void f1(View v){     // Staff's Attendance
    Intent obj=new Intent(this,staff6.class);
    startActivity(obj);
    }
    public void f2(View v){     // Manage Schedule
        Intent obj=new Intent(this,staff5_2.class);
        startActivity(obj);
    }
    public void f3(View v){     // Staff Reschedule
        Intent obj=new Intent(this,staff9.class);
        startActivity(obj);
    }
    public void f4(View v){     // Staff's TimeTable
        Intent obj=new Intent(this,staff8.class);
        startActivity(obj);
    }

    public void f5(View v){     // Staff Record
        Intent obj=new Intent(this,staff4.class);
        startActivity(obj);
    }

    public void f6(View v){     // Manage Notice
        Intent obj=new Intent(this,staff7.class);
        startActivity(obj);

    }
}
