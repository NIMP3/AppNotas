package com.elaytechnologies.appnotas.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.elaytechnologies.appnotas.R;
import com.elaytechnologies.appnotas.model.Student;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class StudentAssistanceAdapterRecyclerView extends RecyclerView.Adapter<StudentAssistanceAdapterRecyclerView.StudentViewHolder>{

    private ArrayList<Student> students;
    private Activity activity;
    private int resource;

    public StudentAssistanceAdapterRecyclerView(ArrayList<Student> students, Activity activity, int resource) {
        this.students = students;
        this.activity = activity;
        this.resource = resource;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final StudentViewHolder holder, int position) {
        Student student = students.get(position);

        Picasso.get().load(student.getAvatarUser()).into(holder.ivPictureStudent);
        holder.tvNameStudent.setText(student.getNameUser());
        holder.tvIdStudent.setText(student.getIdUser());

        holder.cbAssistance.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    holder.cbLack.setChecked(false);
                    holder.cbLackExcuse.setChecked(false);
                }
            }
        });

        holder.cbLackExcuse.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    holder.cbAssistance.setChecked(false);
                    holder.cbLack.setChecked(false);
                }
            }
        });

        holder.cbLack.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    holder.cbAssistance.setChecked(false);
                    holder.cbLackExcuse.setChecked(false);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivPictureStudent;
        private TextView tvNameStudent;
        private TextView tvIdStudent;
        private CheckBox cbAssistance;
        private CheckBox cbLack;
        private CheckBox cbLackExcuse;

        StudentViewHolder(View itemView) {
            super(itemView);

            ivPictureStudent = itemView.findViewById(R.id.ivPictureStudent);
            tvNameStudent = itemView.findViewById(R.id.tvNameStudent);
            tvIdStudent = itemView.findViewById(R.id.tvIdStudent);
            cbAssistance = itemView.findViewById(R.id.cbAssistance);
            cbLack = itemView.findViewById(R.id.cbLack);
            cbLackExcuse = itemView.findViewById(R.id.cbLackExcuse);;
        }
    }
}
