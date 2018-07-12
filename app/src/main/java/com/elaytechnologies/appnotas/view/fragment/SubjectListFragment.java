package com.elaytechnologies.appnotas.view.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.elaytechnologies.appnotas.R;
import com.elaytechnologies.appnotas.adapter.SubjectAdapterGridView;
import com.elaytechnologies.appnotas.model.Subject;

import java.util.ArrayList;

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

        GridView gridView = view.findViewById(R.id.gridViewSubject);
        SubjectAdapterGridView adapterGridView = new SubjectAdapterGridView(buildSubjects(),R.layout.cardview_subject, getActivity());
        gridView.setAdapter(adapterGridView);

        return view;
    }

    /*----------------------------------------------------------------------------------------------
    * */
    private ArrayList<Subject> buildSubjects() {
        ArrayList<Subject> subjects = new ArrayList<>();

        subjects.add(new Subject(1,"MATEMATICAS","Ciencias exactas", 1,2));
        subjects.add(new Subject(2,"ESPAÑOL","Literatura", 1,2));
        subjects.add(new Subject(3,"BIOLOGIA","Ciencias exactas", 1,2));
        subjects.add(new Subject(4,"GEOGRAFIA","Ciencias exactas", 1,2));
        subjects.add(new Subject(5,"QUIMICA","Ciencias exactas", 1,2));
        subjects.add(new Subject(6,"EDU. FISICA","Ciencias exactas", 1,2));

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
