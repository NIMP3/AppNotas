package com.elaytechnologies.appnotas.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.Toolbar;

import com.elaytechnologies.appnotas.R;
import com.elaytechnologies.appnotas.adapter.PeriodAdapterRecyclerView;
import com.elaytechnologies.appnotas.model.Period;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PeriodsListFragment extends Fragment {


    public PeriodsListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_periods_list, container, false);

        //showToolbar(getResources().getString(R.string.title_periods_list), view);

        RecyclerView periodsRecycler = view.findViewById(R.id.rvPeriod);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        periodsRecycler.setLayoutManager(linearLayoutManager);

        PeriodAdapterRecyclerView periodAdapterRecyclerView =
                new PeriodAdapterRecyclerView(buildPeriods(),R.layout.cardview_period, getActivity());

        periodsRecycler.setAdapter(periodAdapterRecyclerView);

        return view;
    }

    private ArrayList<Period> buildPeriods() {
        ArrayList<Period> periods = new ArrayList<>();

        periods.add(new Period(4,"Primer Periodo","10/02/2018"));
        periods.add(new Period(5,"Segundo Periodo","12/06/2018"));
        periods.add(new Period(6,"Tercer Periodo","02/10/2018"));
        periods.add(new Period(1,"Primer Periodo","08/02/2017"));
        periods.add(new Period(2,"Segundo Periodo","01/06/2017"));
        periods.add(new Period(3,"Tercer Periodo","12/10/2017"));

        return periods;
    }

    /*----------------------------------------------------------------------------------------------
     * Mostramos el Toolbar y lo vinculamos con el NavigationView*/
    public void showToolbar(String title, View view) {
        //Establecemos un titulo para el toolbar
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
    }

}
