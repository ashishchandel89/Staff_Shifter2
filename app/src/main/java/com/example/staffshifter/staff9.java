    package com.example.staffshifter;

    import android.Manifest;
    import android.app.Activity;
    import android.app.DatePickerDialog;
    import android.app.Dialog;
    import android.content.Intent;
    import android.content.pm.PackageManager;
    import android.net.Uri;
    import android.os.Bundle;
    import android.telephony.SmsManager;
    import android.util.Log;
    import android.view.View;
    import android.widget.AdapterView;
    import android.widget.ArrayAdapter;
    import android.widget.DatePicker;
    import android.widget.Spinner;
    import android.widget.TextView;
    import android.widget.Toast;

    import androidx.annotation.Nullable;
    import androidx.core.app.ActivityCompat;
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

    import java.util.ArrayList;
    import java.util.Calendar;
    import java.util.HashMap;
    import java.util.Map;

    public class staff9 extends Activity {
        TextView et1_date, et1_day;
        int year, month, day;
        ArrayAdapter<String> adptr_absent,adptr_time,adptr_free;

        String date1,day1;
        Spinner name_spin;
        Spinner time_spin;
        Spinner free_spin;
        RecyclerView recycle3;
        int hour, min;
        ArrayList list_absent ;
        ArrayList list_free;
        ArrayList list_time;
        adapter3 ad3;

        String name1,name2,time1,free1,phone1,time2;
        ArrayList<model3> l1 = new ArrayList<>();
        String url1="https://aptechfatehabad.com/ashish_absent.php";
        String url2="https://aptechfatehabad.com/ashish_timetable2.php";
        String url3="https://aptechfatehabad.com/ashish_freefaculty.php";

        String url4="https://aptechfatehabad.com/ashish_reschedule.php";
        String url5="https://aptechfatehabad.com/ashish_phoneno.php";
        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.recycle3);
            et1_date = findViewById(R.id.et1_date);
            et1_day = findViewById(R.id.et1_day);
            name_spin = findViewById(R.id.name_spin);
            time_spin=findViewById(R.id.time_spin);
            free_spin=findViewById(R.id.free_spin);
            recycle3 = findViewById(R.id.recycle3);
            recycle3.setLayoutManager(new LinearLayoutManager(this));


            list_absent=new ArrayList();
            list_time=new ArrayList();
            list_free=new ArrayList();

            Calendar cal_obj = Calendar.getInstance();
            year = cal_obj.get(Calendar.YEAR);
            month = cal_obj.get(Calendar.MONTH);
            day = cal_obj.get(Calendar.DAY_OF_MONTH);



    //--------------------------Absent-Name--------------------------

            adptr_absent=new ArrayAdapter<>(this,R.layout.text1,list_absent);
            name_spin.setAdapter(adptr_absent);

            name_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                  name1=name_spin.getItemAtPosition(position).toString();
                  show();
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });



            adptr_time=new ArrayAdapter<>(this,R.layout.text1,list_time);
            time_spin.setAdapter(adptr_time);

            time_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    time1=time_spin.getItemAtPosition(position).toString();

                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });


        }





        public void FetchAbsentFaculty(){
            StringRequest sr_obj=new StringRequest(Request.Method.POST, url1, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {

                        JSONArray array = new JSONArray(response);
                        list_absent.clear();
                   //     Toast.makeText(staff9.this, "hello", Toast.LENGTH_SHORT).show();
                        list_absent.clear();
                        for (int i = 0; i < array.length(); i++) {
                            JSONObject js_obj = array.getJSONObject(i);

                            list_absent.add(js_obj.getString("fname"));
                        }
                        adptr_absent.notifyDataSetChanged();

                    } catch (Exception e) {
                        Toast.makeText(staff9.this, "Error" + e.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
            },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(staff9.this, ""+error.toString(), Toast.LENGTH_SHORT).show();
                        }

                    })
            {
                @Nullable
                @Override
                protected Map<String, String> getParams()  {
                    HashMap<String,String> param_obj=new HashMap<String,String>();
                    param_obj.put("adate",date1);
                    Log.e("date1",date1);
                    return param_obj;
                }
            };
            RequestQueue rq_obj= Volley.newRequestQueue(this);
            rq_obj.add(sr_obj);


        }




        // ----------- Show Button Click ----------




        public void show() {
            if (name_spin.getSelectedItem() == null) {
                Toast.makeText(this, "Please select absent faculty name", Toast.LENGTH_SHORT).show();
                return;
            }

            name2 = name_spin.getSelectedItem().toString();

            StringRequest sr_obj = new StringRequest(Request.Method.POST, url2,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                l1.clear(); // old data clear
                                list_time.clear();
                                Log.d("RESPONSE_DATA", response);

                                // Check if response is valid JSON
                                if (response.trim().startsWith("<")) {
                                    Toast.makeText(staff9.this, "Invalid response from server", Toast.LENGTH_LONG).show();
                                    return;
                                }

                                JSONArray array = new JSONArray(response);

                                for (int i = 0; i < array.length(); i++) {
                                    JSONObject js_obj = array.getJSONObject(i);

                                    model3 m = new model3();
                                    m.setClass1(js_obj.getString("fclass"));
                                    m.setTime1(js_obj.getString("time"));
                                    m.setSubject1(js_obj.getString("subject"));
                                    list_time.add(js_obj.getString("time"));
                                    l1.add(m);
                                }

                                adptr_time.notifyDataSetChanged();

                                ad3 = new adapter3(l1);
                                recycle3.setAdapter(ad3);
                                ad3.notifyDataSetChanged();

                            } catch (Exception e) {
                                Toast.makeText(staff9.this, "JSON Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(staff9.this, "Volley Error: " + error.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }) {

                @Nullable
                @Override
                protected Map<String, String> getParams() {
                    HashMap<String, String> param_obj = new HashMap<>();
                    param_obj.put("day", day1);
                    param_obj.put("fname", name1);

                    Log.e("name1", name1);
                    Log.e("day1", day1);

                    return param_obj;
                }
            };

            RequestQueue rq_obj = Volley.newRequestQueue(this);
            rq_obj.add(sr_obj);

        }


    //----------------Date-------------
        public void f1_date(View v) {
            showDialog(0);
        }

        protected Dialog onCreateDialog(int id) {
            if (id == 0) {
                return new DatePickerDialog(this, obj2, year, month, day);
            } else
                return null;
        }

        DatePickerDialog.OnDateSetListener obj2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String selectedDate = year + "-" + (month + 1) + "-" + dayOfMonth;
                et1_date.setText(selectedDate);

                date1 = selectedDate; // ✅ correct

                Calendar cal_obj2 = Calendar.getInstance();
                cal_obj2.set(year, month, dayOfMonth);

                int dayOfWeek = cal_obj2.get(Calendar.DAY_OF_WEEK);
                String dayName = "";

                switch (dayOfWeek) {
                    case Calendar.SUNDAY:
                        dayName = "Sunday";
                        break;
                    case Calendar.MONDAY:
                        dayName = "Monday";
                        break;
                    case Calendar.TUESDAY:
                        dayName = "Tuesday";
                        break;
                    case Calendar.WEDNESDAY:
                        dayName = "Wednesday";
                        break;
                    case Calendar.THURSDAY:
                        dayName = "Thursday";
                        break;
                    case Calendar.FRIDAY:
                        dayName = "Friday";
                        break;
                    case Calendar.SATURDAY:
                        dayName = "Saturday";
                        break;
                }
                et1_day.setText(dayName);
                day1=et1_day.getText().toString();
                FetchAbsentFaculty();

            }




        };


    //---------------------------back button-----------------
        public void back_button5(View v) {
            overridePendingTransition(R.anim.slide, R.anim.slide2);
            finish();
        }




        //----------------View Free Staff---------------------



        public void free_staff(View v) {


            adptr_free=new ArrayAdapter<>(this,R.layout.text1,list_free);
            free_spin.setAdapter(adptr_free);

            free_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    free1 = free_spin.getItemAtPosition(position).toString();

                    StringRequest sr_obj = new StringRequest(Request.Method.POST, url5, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONArray array = new JSONArray(response);
                                for (int i = 0; i < array.length(); i++) {
                                    JSONObject js_obj = array.getJSONObject(i);
                                    phone1 = js_obj.getString("phone");
                                    Log.e("phone1",phone1);
                                }
                            } catch (Exception e) {
                                Toast.makeText(staff9.this, "Error: " + e.toString(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText(staff9.this, "Error: " + error.toString(), Toast.LENGTH_SHORT).show();
                                }
                            }) {
                        @Nullable
                        @Override
                        protected Map<String, String> getParams() {
                            HashMap<String, String> param_obj = new HashMap<String, String>();
                            param_obj.put("uname", free1);
                            return param_obj;
                        }
                    };

                    RequestQueue rq_obj=Volley.newRequestQueue(staff9.this);
                    rq_obj.add(sr_obj);
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });


            StringRequest sr_obj = new StringRequest(Request.Method.POST, url3, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONArray array = new JSONArray(response);
                        list_free.clear();
                        for (int i = 0; i < array.length(); i++) {
                            JSONObject js_obj = array.getJSONObject(i);
                            list_free.add(js_obj.getString("fname"));
                        }
                        adptr_free.notifyDataSetChanged();

                    } catch (Exception e) {
                        Toast.makeText(staff9.this, "Error" + e.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
            },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(staff9.this, "Error" + error.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }) {
                @Nullable
                @Override
                protected Map<String, String> getParams() {
                    HashMap<String, String> param_obj = new HashMap<String, String>();
                    param_obj.put("day", day1);
                    param_obj.put("adate", date1);
                    param_obj.put("time", time1);
                    return param_obj;
                }
            };
                RequestQueue rq_obj=Volley.newRequestQueue(this);
                rq_obj.add(sr_obj);
        }


        //----------------------Save Button------------------


        public void save (View v){
            StringRequest sr_obj2=new StringRequest(Request.Method.POST, url4, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Toast.makeText(staff9.this, "Staff Rescheduled Successfully", Toast.LENGTH_SHORT).show();
                }
            },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(staff9.this, "Doesn't Rescheduled", Toast.LENGTH_SHORT).show();
                        }
                    }) {
                @Nullable
                @Override
                protected Map<String, String> getParams() {
                    HashMap<String, String> param_obj = new HashMap<String, String>();
                    param_obj.put("rdate", date1);
                    param_obj.put("rday", day1);
                    param_obj.put("abname", name2);
                    param_obj.put("rtime", time1);
                    param_obj.put("freename", free1);
                    return param_obj;
                }
            };
                RequestQueue rq_obj=Volley.newRequestQueue(this);
                rq_obj.add(sr_obj2);

        }




        //-------------------Whatsapp--------------


        public void whatsapp(View v){

            time2=time_spin.getSelectedItem().toString();
        String message="Dear " +free1+" ;\nThis is to infrom you that your free lecture has been rescheduled and will now be adjusted with " +name2 +" sir's class.\nTime:- "+time2+ "\nKindly take the class accordingly.\nThank you for your cooperation.\nBest regards,\nAshish Chandel\nReceptionist";
            Intent obj=new Intent(Intent.ACTION_VIEW);
            obj.setData(Uri.parse("http://wa.me/"+phone1+"?text="+Uri.encode(message)));
            startActivity(obj);
        }




        //------------------------SMS------------------




        private void sendSMSNow() {

            time2 = time_spin.getSelectedItem().toString();

            String message = "Dear " + free1 + ";\n"
                    + "This is to inform you that your free lecture has been rescheduled "
                    + "and will now be adjusted with " + name2 + " sir's class.\n"
                    + "Time:- " + time2 + "\n"
                    + "Kindly take the class accordingly.\n"
                    + "Thank you for your cooperation.\n"
                    + "Best regards,\n"
                    + "Ashish Chandel\nReceptionist";

            try {
                SmsManager sms = SmsManager.getDefault();


                ArrayList<String> obj = sms.divideMessage(message);
                sms.sendMultipartTextMessage(phone1, null, obj, null, null);

                Toast.makeText(this, "SMS Sent", Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                Toast.makeText(this, "SMS Failed: " + e.getMessage(), Toast.LENGTH_LONG).show();
                Log.e("SMS_ERROR", e.toString());
            }
        }

        public void message(View v) {

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)
                    != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.SEND_SMS}, 1);
                return;

            } else {
                sendSMSNow();
            }
        }




        //-------------------------CALL--------------------



        public void call(View v){
            if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                    != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CALL_PHONE}, 2);
                return;
            }

            Intent obj=new Intent(Intent.ACTION_CALL);
            obj.setData(Uri.parse("tel:"+phone1));
            startActivity(obj);
        }

    }
