package com.example.staffshifter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adapter3 extends RecyclerView.Adapter<adapter3.ViewHolder> {

    List<model3> list1;

    public adapter3(List<model3> list1) {
        this.list1 = list1;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView t1_class, t1_time, t1_subject, t1_fclass, t1_ftime, t1_fsubject;

        public ViewHolder(@NonNull View v) {
            super(v);
            t1_class = v.findViewById(R.id.t1_class);
            t1_time = v.findViewById(R.id.t1_time);
            t1_subject = v.findViewById(R.id.t1_subject);
            t1_fclass = v.findViewById(R.id.t1_fclass);
            t1_ftime = v.findViewById(R.id.t1_ftime);
            t1_fsubject = v.findViewById(R.id.t1_fsubject);
        }
    }

    @NonNull
    @Override
    public adapter3.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.staff9, parent, false);
        return new ViewHolder(v1);
    }

    @Override
    public void onBindViewHolder(@NonNull adapter3.ViewHolder holder, int position) {
        model3 obj = list1.get(position);
        holder.t1_fclass.setText(obj.getClass1());
        holder.t1_ftime.setText(obj.getTime1());
        holder.t1_fsubject.setText(obj.getSubject1());
    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

}
