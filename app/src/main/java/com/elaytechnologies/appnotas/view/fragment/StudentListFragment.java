package com.elaytechnologies.appnotas.view.fragment;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elaytechnologies.appnotas.R;
import com.elaytechnologies.appnotas.adapter.StudentAdapterRecyclerView;
import com.elaytechnologies.appnotas.model.Student;
import com.elaytechnologies.appnotas.view.StudentAssistanceActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class StudentListFragment extends Fragment {

    Activity activity;
    FloatingActionButton fabCallAssistance;

    public StudentListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student_list, container, false);

        activity = getActivity();
        fabCallAssistance = view.findViewById(R.id.fabCallAssistance);

        int key = this.getArguments() != null ? this.getArguments().getInt("key") : 0;
        if (key == 0) {
            showToolbar(getResources().getString(R.string.title_tab_students),true,getActivity());

            fabCallAssistance.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(activity, StudentAssistanceActivity.class);
                    activity.startActivity(intent);
                }
            });
        }
        else fabCallAssistance.setVisibility(View.GONE);

        RecyclerView recyclerViewStudent = view.findViewById(R.id.recyclerViewStudent);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewStudent.setLayoutManager(linearLayoutManager);

        StudentAdapterRecyclerView studentAdapterRecyclerView =
                new StudentAdapterRecyclerView(buildStudents(),R.layout.cardview_student, getActivity());

        recyclerViewStudent.setAdapter(studentAdapterRecyclerView);

        return view;
    }

    private ArrayList<Student> buildStudents() {
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(1,"1086434256","Martha Lucia","Suarez Jimenez","avatar.jpg","martha@gmail.com","10", "F"));
        students.add(new Student(2,"1085145984","Carlos Joaquin","Ortega Tapia","avatar.jpg","carlosortega@gmail.com", "10", "M"));
        students.add(new Student(3,"1086233987","Jenny Lizeth","Salazar Ascuntar","avatar.jpg","jennysalazar@gmail.com", "10", "F"));
        students.add(new Student(4,"1087456097","Nathalia Katherine","Escobar Jimenez","avatar.jpg","nathi@gmail.com", "10", "F"));
        students.add(new Student(5,"1085234092","Jesus Mateo","Suarez Noguera","avatar.jpg","jesusmat@gmail.com", "10", "M"));
        students.add(new Student(6,"1086498425","Carlos Efrain","Camues Bacca","avatar.jpg","carloscam@gmail.com", "10", "M"));
        students.add(new Student(7,"1081099452","Jhoana Marcela","Quintero Suarez","avatar.jpg","jhoanamarce@gmail.com", "10", "F"));
        students.add(new Student(8,"1079453324","Jessica Jhoana","Ortiz Quiroz","avatar.jpg","jessi@gmail.com", "10", "F"));
        students.add(new Student(9,"1089456702","Juan Carlos","Orbes Montenegro","avatar.jpg","juanorbes@gmail.com", "10", "M"));
        students.add(new Student(10,"1086499411","Andres Felipe","Burbano Pantoja","avatar.jpg","andresfelipe@gmail.com", "10", "M"));

        return students;
    }

    /*----------------------------------------------------------------------------------------------
    * */
    public void showToolbar(String title, Boolean upButton, Activity activity) {
        Toolbar toolbar = activity.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
}
