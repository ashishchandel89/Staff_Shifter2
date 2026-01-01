package com.example.staffshifter;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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

import java.net.Authenticator;
import java.util.HashMap;
import java.util.Map;

public class staff2 extends Activity {
    EditText et1_username,et1_password;

    String username1,password1;
   // String url1="https://aptechfatehabad.com/ashish_authentication.php";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.staff2);

        et1_username=findViewById(R.id.et1_username);
        et1_password=findViewById(R.id.et1_password);




    }




    public void f1(View v){
        username1=et1_username.getText().toString().trim();
        password1=et1_password.getText().toString().trim();
        if(username1.equals("Ashish") && password1.equals("123")){
            Toast.makeText(this, "Login Sucessfuly", Toast.LENGTH_SHORT).show();
            Intent obj = new Intent(staff2.this, staff3.class);
            startActivity(obj);

        }
        else{
            Toast.makeText(staff2.this, "Invalid User!", Toast.LENGTH_SHORT).show();
        }

        /*StringRequest sr_obj=new StringRequest(Request.Method.POST, url1, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(staff2.this, "Invalid User!", Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() {
                HashMap<String, String> param_obj = new HashMap<String, String>();
                param_obj.put("username", username1);
                param_obj.put("password", password1);
                return param_obj;
            }
        };
            RequestQueue rq_obj= Volley.newRequestQueue(this);
            rq_obj.add(sr_obj);

*/
    }
}
