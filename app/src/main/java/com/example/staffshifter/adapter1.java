package com.example.staffshifter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class adapter1 extends RecyclerView.Adapter<adapter1.ViewHolder> {
    List<model1> list1;
    public adapter1(List<model1> list1){
        this.list1=list1;
    }

    public List<model1> getList1() {
        return list1;
    }

    public ArrayList<model1> getList() {
        return new ArrayList<>(list1); // convert List to ArrayList
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView t1_name;
        RadioGroup radiogroup1;
        TextView t2_date;
        RadioButton r1_present,r2_absent;
        public ViewHolder(View v){
            super(v);
            t1_name=v.findViewById(R.id.t1_name);
            radiogroup1=v.findViewById(R.id.radiogroup1);
            t2_date=v.findViewById(R.id.t2_date);
            r1_present=v.findViewById(R.id.r1_present);
            r2_absent=v.findViewById(R.id.r2_absent);

        }
    }

    @NonNull
    @Override
    public adapter1.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.staff6,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull adapter1.ViewHolder holder, int position) {
        model1 obj=list1.get(position);
        holder.t1_name.setText(obj.getName1());

        holder.radiogroup1.setOnCheckedChangeListener((group, checkedId) -> {
            if(checkedId==R.id.r1_present){

                obj.setStatus("P");
            }
            else if(checkedId==R.id.r2_absent){
                obj.setStatus("A");
            }
            else if (obj.getStatus() == null) obj.setStatus("P"); // default present
            holder.r1_present.setChecked("P".equals(obj.getStatus()));
            holder.r2_absent.setChecked("A".equals(obj.getStatus()));


        });

    }
    @Override
    public int getItemCount() {
        return list1.size();
    }




}
