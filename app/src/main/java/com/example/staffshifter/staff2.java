package com.example.staffshifter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class staff2 extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.staff2);

    }
    public void f1(View v){
        Intent obj=new Intent(staff2.this,staff3.class);
        startActivity(obj);
    }
}
