package com.example.staffshifter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.net.Authenticator;

public class staff2 extends Activity {
    EditText et1_username,et1_password;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.staff2);

        et1_username=findViewById(R.id.et1_username);
        et1_password=findViewById(R.id.et1_password);

        Authentication();

    }
    public void Authentication(){

    }

    public void f1(View v){
        Intent obj=new Intent(staff2.this,staff3.class);
        startActivity(obj);
    }
}
