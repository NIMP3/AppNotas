package com.elaytechnologies.appnotas.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.elaytechnologies.appnotas.R;
import com.elaytechnologies.appnotas.view.fragment.PeriodsListFragment;

public class TeacherActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        //Vinculamos el DrawerLayout con el Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

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
        PeriodsListFragment periodsListFragment = new PeriodsListFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.teacher_context,periodsListFragment)
                .setTransition(FragmentTransaction.TRANSIT_EXIT_MASK)
                .commit();
    }
}
