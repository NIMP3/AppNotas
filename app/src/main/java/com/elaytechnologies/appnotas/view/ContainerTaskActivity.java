package com.elaytechnologies.appnotas.view;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Transition;
import android.view.View;

import com.elaytechnologies.appnotas.R;
import com.elaytechnologies.appnotas.view.fragment.StudentListFragment;
import com.elaytechnologies.appnotas.view.fragment.TaskGraphFragment;

public class ContainerTaskActivity extends AppCompatActivity implements View.OnClickListener{

    FloatingActionButton fabQualifyTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container_task);

        fabQualifyTask = findViewById(R.id.fabQualifyTask);
        fabQualifyTask.setOnClickListener(this);

        //Obtenemos el nombre de la actividad seleccionada como titulo de la descripción
        Bundle extras = getIntent().getExtras();
        String title = extras.getString("type",getResources().getString(R.string.title_info_task));

        showToolbar(title,false);

        launchFragment(new TaskGraphFragment(), R.id.containerGraphTask,null);

        //Enviamos la key=1 para ocultar el floatingActionButton y evitar el showToolbar del fragmento
        Bundle arguments = new Bundle();
        arguments.putInt("key",1);
        launchFragment(new StudentListFragment(), R.id.containerListStudent,arguments);
    }

    /*----------------------------------------------------------------------------------------------
    Lanzar un fragmento determinado
     */
    public void launchFragment(Fragment fragment, int resource, Bundle arguments) {
        fragment.setArguments(arguments); //Eviamos datos al nuevo fragmento

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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fabQualifyTask:
                Intent intent = new Intent(this,TaskQualifyActivity.class);
                startActivity(intent);
        }
    }
}
