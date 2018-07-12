package com.elaytechnologies.appnotas.view.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.Toolbar;

import com.elaytechnologies.appnotas.R;
import com.elaytechnologies.appnotas.adapter.GradeAdapterRecyclerView;
import com.elaytechnologies.appnotas.model.Grade;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class GradeListFragment extends Fragment {


    public GradeListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_grade_list, container, false);

        showToolbar(getResources().getString(R.string.title_grade_list),false, getActivity());

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewGrade);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        GradeAdapterRecyclerView gradeAdapterRecyclerView = new GradeAdapterRecyclerView(buildGrades(),R.layout.cardview_grade,getContext());
        recyclerView.setAdapter(gradeAdapterRecyclerView);

        return view;
    }
    /*----------------------------------------------------------------------------------------------
     * */
    private ArrayList<Grade> buildGrades() {
        ArrayList<Grade> grades = new ArrayList<>();

        grades.add(new Grade(1,"GRADO QUINTO",1,"5"));
        grades.add(new Grade(2,"GRADO SEPTIMO",1,"7"));
        grades.add(new Grade(3,"GRADO DECIMO",1,"10"));
        grades.add(new Grade(4,"GRADO ONCE",1,"11"));

        return grades;
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
