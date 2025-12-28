package com.example.staffshifter;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class staff4 extends Activity {
    int a=0;
    EditText et1_name,et2_fname,et3_pass,et4_email,et5_phone,et6_dob;
    RadioButton r1_male,r2_female;
    String url1="https://aptechfatehabad.com/ashish_signup.php";

    String name1,fname1,pass1,email1,phone1,dob1,radio1="";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.staff4);

        et1_name=findViewById(R.id.et1_name);
        et2_fname=findViewById(R.id.et2_fname);
        et3_pass=findViewById(R.id.et3_pass);
        et4_email=findViewById(R.id.et4_email);
        et5_phone=findViewById(R.id.et5_phone);
        et6_dob=findViewById(R.id.et6_dob);
        r1_male=findViewById(R.id.r1_male);
        r2_female=findViewById(R.id.r2_female);

    }
        public void f1(View v){

            name1=et1_name.getText().toString();
            fname1=et2_fname.getText().toString();
            pass1=et3_pass.getText().toString();
            email1=et4_email.getText().toString();
            phone1=et5_phone.getText().toString();
            dob1=et6_dob.getText().toString();
            if(r1_male.isChecked()){
                radio1="Male";
            }
            else if(r2_female.isChecked()) {
                radio1="Female";
            }

            StringRequest sr_obj=new StringRequest(Request.Method.POST, url1, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Toast.makeText(staff4.this, "submit successfully", Toast.LENGTH_SHORT).show();
                }
            },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("error1",error.toString());
                            Toast.makeText(staff4.this, error.toString(), Toast.LENGTH_SHORT).show();
                        }
                    })
            {
                @Nullable
                @Override
                protected Map<String, String> getParams() {
                    HashMap<String,String> param_obj=new HashMap<String,String>();
                    param_obj.put("uname",name1);
                    param_obj.put("fname",fname1);
                    param_obj.put("pass",pass1);
                    param_obj.put("email",email1);
                    param_obj.put("phone",phone1);
                    param_obj.put("dob",dob1);
                    param_obj.put("gender",radio1);
                    return param_obj;
                }
            };
            RequestQueue rq_obj= Volley.newRequestQueue(this);
            rq_obj.add(sr_obj);

        }
        public void f2(View v){
        if(a==0) {
            a=1;
            et3_pass.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        }
        else if(a==1){
            a=0;
            et3_pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

        }
        }
        public void back_button4(View v){
            overridePendingTransition(R.anim.slide,R.anim.slide2);
        finish();
        }
}
