package com.elaytechnologies.appnotas.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.elaytechnologies.appnotas.R;
import com.elaytechnologies.appnotas.model.Subject;
import com.elaytechnologies.appnotas.view.fragment.GradeListFragment;

import java.util.ArrayList;

public class SubjectAdapterGridView extends BaseAdapter {

    private ArrayList<Subject> subjects;
    private int resource;
    private Context context;
    private FragmentManager fragmentManager;

    public SubjectAdapterGridView(ArrayList<Subject> subjects, int resource, Context context, FragmentManager fragmentManager) {
        this.subjects = subjects;
        this.resource = resource;
        this.context = context;
        this.fragmentManager = fragmentManager;
    }

    @Override
    public int getCount() {
        return subjects.size();
    }

    @Override
    public Object getItem(int i) {
        return subjects.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Subject subject = subjects.get(i);

        if (view == null) {
            view = LayoutInflater.from(context).inflate(resource, viewGroup, false);
        }

        ImageView imageViewSubject = view.findViewById(R.id.imageViewSubject);
        TextView textViewNameSubject = view.findViewById(R.id.textViewNameSubject);
        CardView cardViewSubject = view.findViewById(R.id.cardViewSubject);

        textViewNameSubject.setText(subject.getNameSubject());

        cardViewSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchGradeList();
            }
        });

        return view;
    }

    /*----------------------------------------------------------------------------------------------
     * Lanzamos el Fragment para la lista de grados*/
    public void launchGradeList() {
        GradeListFragment gradeListFragment = new GradeListFragment();
        fragmentManager.beginTransaction()
                .addToBackStack("Grade List")
                .replace(R.id.teacher_context, gradeListFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
    }
}
