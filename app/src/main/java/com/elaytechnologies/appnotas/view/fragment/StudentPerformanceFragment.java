package com.elaytechnologies.appnotas.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elaytechnologies.appnotas.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StudentPerformanceFragment extends Fragment {


    public StudentPerformanceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_performance, container, false);
    }

}
