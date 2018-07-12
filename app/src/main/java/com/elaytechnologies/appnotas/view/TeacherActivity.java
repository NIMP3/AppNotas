package com.elaytechnologies.appnotas.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.elaytechnologies.appnotas.R;
import com.elaytechnologies.appnotas.view.fragment.PeriodListFragment;
import com.elaytechnologies.appnotas.view.fragment.SubjectListFragment;

public class TeacherActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        launchPeriodsList();
    }

    /*----------------------------------------------------------------------------------------------
    * Detectamos la acción de retroceso*/
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /*----------------------------------------------------------------------------------------------
    * Procesamos las opciones del Menu del profesor*/
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks.
        switch (item.getItemId()) {
            case R.id.nav_account:
                //Account item
                break;
            case R.id.nav_settings:
                //Settings item
                break;
            case R.id.nav_about:
                //About of app item
                break;
            case R.id.nav_logout:
                //Logout item
                break;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /*----------------------------------------------------------------------------------------------
     * Lanzamos el Fragment para la lista de periodos*/
    public void launchPeriodsList() {
        PeriodListFragment periodListFragment = new PeriodListFragment();
        getSupportFragmentManager().beginTransaction()
                .addToBackStack(null)
                .add(R.id.teacher_context,periodListFragment)
                .setTransition(FragmentTransaction.TRANSIT_EXIT_MASK)
                .commit();
    }
}
