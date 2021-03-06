package com.elaytechnologies.appnotas.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.elaytechnologies.appnotas.R;
import com.elaytechnologies.appnotas.model.Student;
import com.elaytechnologies.appnotas.view.ContainerStudentActivity;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class StudentAdapterRecyclerView extends RecyclerView.Adapter<StudentAdapterRecyclerView.StudentViewHolder>{

    private ArrayList<Student> students;
    private int resource;
    private Activity activity;

    public StudentAdapterRecyclerView(ArrayList<Student> students, int resource, Activity activity) {
        this.students = students;
        this.resource = resource;
        this.activity = activity;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        final Student student = students.get(position);

        holder.textViewId.setText(student.getIdUser());
        holder.textViewNameStudent.setText(student.getNameUser());
        holder.textViewSurnameStudent.setText(student.getSurnameUser());
        holder.textViewGradeStudent.setText(student.getGradeStudent());
        holder.textViewEmailStudent.setText(student.getEmailUser());

        //Evento OnClick sobre un estudiante = Rendimiento del estudiante seleccionado
        holder.cardViewStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, ContainerStudentActivity.class);
                intent.putExtra("student",student.getNameUser());    //Titulo del nuevo Activity
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {

        private CardView cardViewStudent;
        private CircleImageView circleImageViewPictureStudent;
        private TextView textViewId;
        private TextView textViewNameStudent;
        private TextView textViewSurnameStudent;
        private TextView textViewGradeStudent;
        private TextView textViewEmailStudent;

        public StudentViewHolder(View itemView) {
            super(itemView);

            cardViewStudent = itemView.findViewById(R.id.cardviewStudent);
            circleImageViewPictureStudent = itemView.findViewById(R.id.circleImageViewPictureStudent);
            textViewId = itemView.findViewById(R.id.textViewId);
            textViewNameStudent = itemView.findViewById(R.id.textViewNameStudent);
            textViewSurnameStudent = itemView.findViewById(R.id.textViewSurnameStudent);
            textViewGradeStudent = itemView.findViewById(R.id.textViewGradeStudent);
            textViewEmailStudent = itemView.findViewById(R.id.textViewEmailStudent);
        }
    }
}
