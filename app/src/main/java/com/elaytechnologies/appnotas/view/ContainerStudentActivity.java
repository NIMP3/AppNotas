package com.elaytechnologies.appnotas.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.elaytechnologies.appnotas.R;
import com.elaytechnologies.appnotas.view.fragment.StudentGraphFragment;
import com.elaytechnologies.appnotas.view.fragment.StudentPerformanceFragment;

public class ContainerStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container_student);

        //Obtenemos el nombre del Estudiante seleccionado como titulo de la descripción
        Bundle extras = getIntent().getExtras();
        String title = extras.getString("student",getResources().getString(R.string.title_performance_student));

        showToolbar(title,false);

        launchFragment(new StudentPerformanceFragment(), R.id.containerInfoStudent);
        launchFragment(new StudentGraphFragment(), R.id.containerGraphStudent);

    }
    /*----------------------------------------------------------------------------------------------
    Lanzar un fragmento determinado
     */
    public void launchFragment(Fragment fragment, int resource) {
        getSupportFragmentManager().beginTransaction()
                .replace(resource, fragment)
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
