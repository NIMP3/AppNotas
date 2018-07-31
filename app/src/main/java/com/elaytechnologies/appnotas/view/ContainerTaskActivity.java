package com.elaytechnologies.appnotas.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Transition;

import com.elaytechnologies.appnotas.R;
import com.elaytechnologies.appnotas.view.fragment.StudentListFragment;
import com.elaytechnologies.appnotas.view.fragment.TaskGraphFragment;

public class ContainerTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container_task);

        //Obtenemos el nombre de la actividad seleccionada como titulo de la descripción
        Bundle extras = getIntent().getExtras();
        String title = extras.getString("type",getResources().getString(R.string.title_info_task));

        showToolbar(title,false);

        launchFragment(new TaskGraphFragment(), R.id.containerGraphTask);
        launchFragment(new StudentListFragment(), R.id.containerListStudent);
    }

    /*----------------------------------------------------------------------------------------------
    Lanzar un fragmento determinado
     */
    public void launchFragment(Fragment fragment, int resource) {
        getSupportFragmentManager().beginTransaction()
                .replace(resource,fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    /*----------------------------------------------------------------------------------------------
    Mostrar el Toolbar con determinadas caracteristicas
     */
    public void showToolbar(String title, Boolean upButton) {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
}
