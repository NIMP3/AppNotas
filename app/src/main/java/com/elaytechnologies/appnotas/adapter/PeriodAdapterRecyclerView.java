package com.elaytechnologies.appnotas.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.elaytechnologies.appnotas.R;
import com.elaytechnologies.appnotas.model.Period;
import com.elaytechnologies.appnotas.view.fragment.SubjectListFragment;

import java.util.ArrayList;

public class PeriodAdapterRecyclerView extends RecyclerView.Adapter<PeriodAdapterRecyclerView.PeriodViewHolder> {

    //Atributos
    private ArrayList<Period> periods; //Manejar la lista de periodos
    private int resource; //Recurso para manejar el layout de cardview
    private Activity activity; //Actividad en la que se encuentra
    private FragmentManager fragmentManager;

    /*----------------------------------------------------------------------------------------------
    * Constructor*/
    public PeriodAdapterRecyclerView(ArrayList<Period> periods, int resource, Activity activity, FragmentManager fragmentManager) {
        this.periods = periods;
        this.resource = resource;
        this.activity = activity;
        this.fragmentManager = fragmentManager;
    }

    /*----------------------------------------------------------------------------------------------
    * Infla el Cardview en la vista*/
    @NonNull
    @Override
    public PeriodViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(resource, viewGroup, false);
        return new PeriodViewHolder(view);
    }

    /*----------------------------------------------------------------------------------------------
    * Carga los datos en cada Cardview*/
    @Override
    public void onBindViewHolder(@NonNull PeriodViewHolder periodViewHolder, int i) {
        //Obtenemos el perido actual
        Period period = periods.get(i);

        //Cargamos los datos en los views de cada Cardview
        periodViewHolder.tvPeriod.setText(period.getNamePeriod());
        periodViewHolder.tvDate.setText(period.getDatePerido());

        //Evento Onclick sobre un Periodo
        periodViewHolder.cardViewPeriod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchSubjectList();
            }
        });
    }

    /*----------------------------------------------------------------------------------------------
    * */
    @Override
    public int getItemCount() {
        return periods.size();
    }

    /*----------------------------------------------------------------------------------------------
    * Clase para manejar el CardView Period*/
    public class PeriodViewHolder extends RecyclerView.ViewHolder {

        //Atributos (views) del cardview Period
        private TextView tvPeriod;
        private TextView tvDate;
        private CardView cardViewPeriod;

        //Constructor
        public PeriodViewHolder(@NonNull View itemView) {
            super(itemView);

            this.tvPeriod = itemView.findViewById(R.id.tvPeriodCard);
            this.tvDate = itemView.findViewById(R.id.tvDateCard);
            this.cardViewPeriod = itemView.findViewById(R.id.cardviewPeriod);
        }
    }

    /*----------------------------------------------------------------------------------------------
     * Lanzamos el Fragment para la lista de asignaturas*/
    public void launchSubjectList() {
        SubjectListFragment subjectListFragment = new SubjectListFragment();
        fragmentManager.beginTransaction()
                .addToBackStack("Subject List")
                .replace(R.id.teacher_context, subjectListFragment)
                .setTransition(FragmentTransaction.TRANSIT_EXIT_MASK)
                .commit();
    }

}
