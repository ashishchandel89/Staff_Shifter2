package com.example.staffshifter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class staff6 extends Activity {
    RecyclerView recycle1;
    ArrayList<model1> l1 = new ArrayList<>();
    adapter1 ad1;
    String name1;
    TextView t2_date;
    RadioButton r1_present,r2_absent;
    String adate,fname,attendence;
    JSONArray array;

    String url1 = "https://aptechfatehabad.com/ashish_facultynames.php";
    String url2="https://aptechfatehabad.com/ashish_attendance.php";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle);

        recycle1 = findViewById(R.id.recycle1);
        t2_date=findViewById(R.id.t2_date);
        recycle1.setLayoutManager(new LinearLayoutManager(this));
        f1();
    }
    public void back_button5_2(View view) {
        overridePendingTransition(R.anim.slide,R.anim.slide2);
        finish();
    }

    public void f1() {
        try{
            Calendar cal_obj=Calendar.getInstance();
            SimpleDateFormat date_obj=new SimpleDateFormat("yyyy-MM-dd");
            String curr_date=date_obj.format(cal_obj.getTime());
            t2_date.setText(curr_date);
        }catch(Exception e1){
            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
        }

        try {
            StringRequest sr_obj = new StringRequest(Request.Method.POST, url1, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                         array = new JSONArray(response);

                        for (int i = 0; i < array.length(); i++) {
                            JSONObject obj = array.getJSONObject(i);
                            name1 = obj.getString("uname");
                            l1.add(new model1(name1));
                        }
                            ad1 = new adapter1(l1);

                            recycle1.setAdapter(ad1);
                            ad1.notifyDataSetChanged();

                    } catch (Exception e) {
                        Toast.makeText(staff6.this,"error" +e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(staff6.this, "Error", Toast.LENGTH_SHORT).show();
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
        } catch (Exception ee) {
            Toast.makeText(this, "exception" + ee.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    public void b1_save(View v){

        array=new JSONArray();
        for(int i=0;i<ad1.getList().size();i++){
            model1 model_obj=ad1.getList().get(i);
            JSONObject js_obj=new JSONObject();
            try{
                js_obj.put("fname",model_obj.getName1());
                js_obj.put("adate",t2_date.getText().toString());
                js_obj.put("attendance",model_obj.getStatus());
                array.put(js_obj);

            }catch (Exception e)
            {
                Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
            }
        }

        try{
            StringRequest sr_obj2=new StringRequest(Request.Method.POST, url2, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    Toast.makeText(staff6.this, "saved ", Toast.LENGTH_SHORT).show();

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(staff6.this, "Error: "+error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            })
            {
                @Nullable
                @Override
                protected Map<String, String> getParams() {
                    HashMap<String,String> param_obj=new HashMap<String,String>();
                    param_obj.put("data",array.toString());
                    return param_obj;
                }
            };
            RequestQueue rq_obj=Volley.newRequestQueue(this);
            rq_obj.add(sr_obj2);

        }catch(Exception e4){
            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
        }


    }


}
