package com.elaytechnologies.appnotas.view.fragment;


import android.app.Activity;
import android.os.Bundle;
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

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class StudentListFragment extends Fragment {


    public StudentListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student_list, container, false);

        showToolbar(getResources().getString(R.string.title_tab_students),true,getActivity());

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

        students.add(new Student(1,"1086434256","Martha Lucia","Suarez Jimenez","10","martha@gmail.com"));
        students.add(new Student(2,"1085145984","Carlos Joaquin","Ortega Tapia","10","carlosortega@gmail.com"));
        students.add(new Student(3,"1086233987","Jenny Lizeth","Salazar Ascuntar","10","jennysalazar@gmail.com"));
        students.add(new Student(4,"1087456097","Nathalia Katherine","Escobar Jimenez","10","nathi@gmail.com"));
        students.add(new Student(5,"1085234092","Jesus Mateo","Suarez Noguera","10","jesusmat@gmail.com"));
        students.add(new Student(6,"1086498425","Carlos Efrain","Camues Bacca","10","carloscam@gmail.com"));
        students.add(new Student(7,"1081099452","Jhoana Marcela","Quintero Suarez","10","jhoanamarce@gmail.com"));
        students.add(new Student(8,"1079453324","Jessica Jhoana","Ortiz Quiroz","10","jessi@gmail.com"));
        students.add(new Student(9,"1089456702","Juan Carlos","Orbes Montenegro","10","juanorbes@gmail.com"));
        students.add(new Student(10,"1086499411","Andres Felipe","Burbano Pantoja","10","andresfelipe@gmail.com"));

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
