package com.elaytechnologies.appnotas.view.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.elaytechnologies.appnotas.R;
import com.elaytechnologies.appnotas.adapter.SubjectAdapterRecyclerView;
import com.elaytechnologies.appnotas.model.Grade;
import com.elaytechnologies.appnotas.model.Subject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubjectListFragment extends Fragment {


    public SubjectListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_subject_list, container, false);

        showToolbar(getResources().getString(R.string.title_subjects_list),false,getActivity());

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewSubject);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);



        SubjectAdapterRecyclerView subjectAdapterRecyclerView = new SubjectAdapterRecyclerView(
                buildGrades(),
                buildSubjects(),
                R.layout.cardview_subject,
                getActivity());

        recyclerView.setAdapter(subjectAdapterRecyclerView);

        return view;
    }

    /*----------------------------------------------------------------------------------------------
    * */
    private ArrayList<Grade> buildGrades() {
        ArrayList<Grade> grades = new ArrayList<>();

        grades.add(new Grade(1, "Grado quinto",1,"5"));
        grades.add(new Grade(2, "Grado septimo",1,"7"));
        grades.add(new Grade(3, "Grado octavo",2,"8"));
        grades.add(new Grade(4, "Grado once",2,"11"));
        grades.add(new Grade(5, "Grado noveno",7,"9"));
        grades.add(new Grade(6, "Grado decimo",7,"10"));
        grades.add(new Grade(7, "Grado septimo",7,"7"));

        return grades;
    }

    /*----------------------------------------------------------------------------------------------
    * Construir el HashMap-prueba de Asignaturas*/
    private HashMap<Integer, String> buildSubjects() {
        HashMap<Integer, String> subjects = new HashMap<>();

        subjects.put(1,"RELIGIÓN");
        subjects.put(2,"ESPAÑOL");
        subjects.put(3,"BIOLOGIA");
        subjects.put(4,"GEOGRAFIA");
        subjects.put(5,"MATEMATICAS");
        subjects.put(6,"QUIMICA");
        subjects.put(7,"EDUCACIÓN FISICA");

        return subjects;
    }

    /*----------------------------------------------------------------------------------------------
    * */
    public void showToolbar(String title, Boolean upButton, Activity activity) {
        Toolbar toolbar = activity.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

        //Vinculamos el DrawerLayout con el Toolbar
        DrawerLayout drawer = activity.findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                activity,
                drawer,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

}
