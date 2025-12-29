package com.example.staffshifter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adapter4 extends RecyclerView.Adapter<adapter4.ViewHolder> {

    List <model4> list1;
    public adapter4(List<model4>list1){
        this.list1=list1;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView t1_absenttime,t1_absentsubject,t1_absentclass,message;
        public ViewHolder(View v){
            super(v);
            message=v.findViewById(R.id.message);
            t1_absentclass=v.findViewById(R.id.t1_absentclass);
            t1_absentsubject=v.findViewById(R.id.t1_absentsubject);
            t1_absenttime=v.findViewById(R.id.t1_absenttime);
        }

    }
    @NonNull
    @Override
    public adapter4.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.staff3_o,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull adapter4.ViewHolder holder, int position) {
    model4 obj=list1.get(position);
        String message1 = "Prof. " + obj.getAbsent_staff() + "'s lecture has been adjusted with prof. " + obj.getFree_staff();

        holder.message.setText(message1);
        holder.t1_absenttime.setText(obj.getTime1());
        holder.t1_absentclass.setText(obj.getClass1());
        holder.t1_absentsubject.setText(obj.getSubject1());

        holder.t1_absentclass.setText(obj.getClass1());
    holder.t1_absenttime.setText(obj.getTime1());
    holder.t1_absentsubject.setText(obj.getSubject1());

    }

    @Override
    public int getItemCount() {
        return list1.size();
    }


}
