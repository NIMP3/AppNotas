package com.elaytechnologies.appnotas.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.elaytechnologies.appnotas.R;
import com.elaytechnologies.appnotas.model.Student;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class StudentQualifyAdapterRecyclerView extends RecyclerView.Adapter<StudentQualifyAdapterRecyclerView.StudentViewHolder>{

    private ArrayList<Student> students;
    private Activity activity;
    private int resource;

    public StudentQualifyAdapterRecyclerView(ArrayList<Student> students, Activity activity, int resource) {
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

        holder.sbNoteValue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                float value = (float) i / 10f;
                holder.tvNoteValue.setText(String.valueOf(value));

                if (value >= 4.6 && value <= 5.0) holder.tvPerformance.setText("Desempeño Superior");
                else if (value >= 4.0 && value <= 4.5) holder.tvPerformance.setText("Desempeño Alto");
                else if (value >= 3.0 && value <= 3.9) holder.tvPerformance.setText("Desempeño Básico");
                else holder.tvPerformance.setText("Desempeño Bajo");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

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
        private TextView tvNoteValue;
        private TextView tvPerformance;
        private SeekBar sbNoteValue;

        StudentViewHolder(View itemView) {
            super(itemView);

            ivPictureStudent = itemView.findViewById(R.id.ivPictureStudent);
            tvNameStudent = itemView.findViewById(R.id.tvNameStudent);
            tvIdStudent = itemView.findViewById(R.id.tvIdStudent);
            tvNoteValue = itemView.findViewById(R.id.tvNoteValue);
            tvPerformance = itemView.findViewById(R.id.tvPerformance);
            sbNoteValue = itemView.findViewById(R.id.sbNoteValue);
        }
    }
}
