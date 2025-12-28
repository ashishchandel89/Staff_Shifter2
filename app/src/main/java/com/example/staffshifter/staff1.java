package com.example.staffshifter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;

public class staff1 extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.staff1);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent obj=new Intent(staff1.this,staff2.class);
                startActivity(obj);
                finish();
            }
        },1000);
    }
}
