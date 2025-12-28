package com.example.staffshifter;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

public class staff8 extends Activity {

    Spinner name_spin;
    RecyclerView recycle2;
    ArrayList<String> list_name;
    ArrayAdapter<String> adptr_name;
    String name2;
    ArrayList<model2> l1 = new ArrayList<>();
    adapter2 ad2;

    // URLs
    String url1 = "https://aptechfatehabad.com/ashish_facultynames.php";
    String url2 = "https://aptechfatehabad.com/ashish_timetable.php";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle2);

        // initialize
        name_spin = findViewById(R.id.name_spin);
        recycle2 = findViewById(R.id.recycle2);
        recycle2.setLayoutManager(new LinearLayoutManager(this));
        list_name = new ArrayList<>();

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
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }

    // ----------- Fetch Faculty Names ----------
    private void fetchFacultyNames() {
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
                            Toast.makeText(staff8.this, "JSON Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(staff8.this, "Error fetching names", Toast.LENGTH_SHORT).show();
                    }
                });

        RequestQueue rq_obj = Volley.newRequestQueue(this);
        rq_obj.add(sr_obj);
    }

    // ----------- Show Button Click ----------
    public void show(View v) {
        if (name_spin.getSelectedItem() == null) {
            Toast.makeText(this, "Please select a faculty name", Toast.LENGTH_SHORT).show();
            return;
        }

        name2 = name_spin.getSelectedItem().toString();

        StringRequest sr_obj = new StringRequest(Request.Method.POST, url2,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            l1.clear(); // old data clear
                            Log.d("RESPONSE_DATA", response);

                            // Check if response is valid JSON
                            if (response.trim().startsWith("<")) {
                                Toast.makeText(staff8.this, "Invalid response from server", Toast.LENGTH_LONG).show();
                                return;
                            }

                            JSONArray array = new JSONArray(response);

                            for (int i = 0; i < array.length(); i++) {
                                JSONObject js_obj = array.getJSONObject(i);

                                model2 m = new model2();
                                m.setName1(js_obj.getString("fname"));
                                m.setDay1(js_obj.getString("day"));
                                m.setTime1(js_obj.getString("time"));
                                m.setClass1(js_obj.getString("fclass"));
                                m.setSubject1(js_obj.getString("subject"));

                                l1.add(m);
                            }

                            ad2 = new adapter2(l1);
                            recycle2.setAdapter(ad2);
                            ad2.notifyDataSetChanged();

                        } catch (Exception e) {
                            Toast.makeText(staff8.this, "JSON Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(staff8.this, "Volley Error: " + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }) {

            @Nullable
            @Override
            protected Map<String, String> getParams() {
                HashMap<String, String> param_obj = new HashMap<>();
                param_obj.put("fname", name2);
                return param_obj;
            }
        };

        RequestQueue rq_obj = Volley.newRequestQueue(this);
        rq_obj.add(sr_obj);
    }

    public void back_button5(View v) {
        overridePendingTransition(R.anim.slide, R.anim.slide2);
        finish();
    }
}
