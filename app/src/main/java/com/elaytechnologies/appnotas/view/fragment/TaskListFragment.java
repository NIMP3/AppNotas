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
import com.elaytechnologies.appnotas.adapter.TaskAdapterRecyclerView;
import com.elaytechnologies.appnotas.model.Task;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TaskListFragment extends Fragment {


    public TaskListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task_list, container, false);

        showToolbar(getResources().getString(R.string.title_tab_tasks), true,getActivity());

        RecyclerView recyclerViewTask = view.findViewById(R.id.recyclerviewTask);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewTask.setLayoutManager(linearLayoutManager);

        TaskAdapterRecyclerView taskAdapterRecyclerView =
                new TaskAdapterRecyclerView(buildTasks(),R.layout.cardview_task,getActivity());

        recyclerViewTask.setAdapter(taskAdapterRecyclerView);

        return view;
    }

    private ArrayList<Task> buildTasks() {
        ArrayList<Task> tasks = new ArrayList<>();

        tasks.add(new Task(1,"EXAMEN","Evaluara el tema de Integrales"));
        tasks.add(new Task(2,"TRABAJO","Evaluara el tema de Gauss Jordan"));
        tasks.add(new Task(3,"EXPOSICIÓN","Evaluara el tema de Conjuntos"));
        tasks.add(new Task(4,"TRABAJO","Evaluara el tema de Derivadas"));
        tasks.add(new Task(5,"TRABAJO","Evaluara el tema de Funciones"));
        tasks.add(new Task(6,"EXPOSICIÓN","Evaluara el tema de Derivadas de primero, segundo y tercer orden"));
        tasks.add(new Task(7,"EXAMEN","Evaluara el tema de Laplace"));
        tasks.add(new Task(8,"EXAMEN","Evaluara el tema de calculo multivariable"));

        return tasks;
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
