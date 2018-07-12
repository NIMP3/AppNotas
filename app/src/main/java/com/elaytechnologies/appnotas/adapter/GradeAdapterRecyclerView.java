package com.elaytechnologies.appnotas.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.elaytechnologies.appnotas.R;
import com.elaytechnologies.appnotas.model.Grade;

import java.util.ArrayList;

public class GradeAdapterRecyclerView extends RecyclerView.Adapter<GradeAdapterRecyclerView.GradeViewHolder>{

    private ArrayList<Grade> grades;
    private int resource;
    private Context context;

    public GradeAdapterRecyclerView(ArrayList<Grade> grades, int resource, Context context) {
        this.grades = grades;
        this.resource = resource;
        this.context = context;
    }

    @NonNull
    @Override
    public GradeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(resource, viewGroup,false);
        return new GradeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GradeViewHolder gradeViewHolder, int i) {
        Grade grade = grades.get(i);

        gradeViewHolder.textViewNumberGrade.setText(grade.getNumberGrade());
        gradeViewHolder.textViewNameGrade.setText(grade.getNameGrade());
    }

    @Override
    public int getItemCount() {
        return grades.size();
    }

    class GradeViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewNumberGrade;
        private TextView textViewNameGrade;

        public GradeViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewNumberGrade = itemView.findViewById(R.id.textViewNumberGrade);
            textViewNameGrade = itemView.findViewById(R.id.textViewNameGrade);
        }
    }
}
