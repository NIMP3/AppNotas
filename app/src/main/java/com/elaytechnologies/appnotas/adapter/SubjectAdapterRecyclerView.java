package com.elaytechnologies.appnotas.adapter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.elaytechnologies.appnotas.R;
import com.elaytechnologies.appnotas.model.Grade;
import com.elaytechnologies.appnotas.view.ContainerActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class SubjectAdapterRecyclerView extends RecyclerView.Adapter<SubjectAdapterRecyclerView.SubjectViewHolder> {

    private ArrayList<Grade> grades;
    private HashMap<Integer, String> subjects;
    private int resource;
    private Activity activity;

    public SubjectAdapterRecyclerView(ArrayList<Grade> grades, HashMap<Integer, String> subjects, int resource, Activity activity) {
        this.grades = grades;
        this.subjects = subjects;
        this.resource = resource;
        this.activity = activity;
    }

    @NonNull
    @Override
    public SubjectViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(resource, viewGroup, false);
        return new SubjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubjectViewHolder subjectViewHolder, int i) {
        Grade grade = grades.get(i);
        String nameSubject = subjects.get(grade.getSubjectGrade());

        subjectViewHolder.textViewNameSubject.setText(nameSubject);
        subjectViewHolder.textViewNameGrade.setText(grade.getNameGrade());
        subjectViewHolder.textViewNumberGrade.setText(grade.getNumberGrade());

        subjectViewHolder.cardViewSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, ContainerActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return grades.size();
    }

    class SubjectViewHolder extends RecyclerView.ViewHolder {

        //Views del Cardview Subject
        private TextView textViewNameSubject;
        private TextView textViewNameGrade;
        private TextView textViewNumberGrade;
        private CardView cardViewSubject;

        public SubjectViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewNameSubject = itemView.findViewById(R.id.textViewNameSubject);
            textViewNameGrade = itemView.findViewById(R.id.textViewNameGrade);
            textViewNumberGrade = itemView.findViewById(R.id.textViewNumberGrade);
            cardViewSubject = itemView.findViewById(R.id.cardviewSubject);
        }
    }
}
