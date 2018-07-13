package com.elaytechnologies.appnotas.view;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.view.MenuItem;

import com.elaytechnologies.appnotas.R;
import com.elaytechnologies.appnotas.view.fragment.SettingsFragment;
import com.elaytechnologies.appnotas.view.fragment.StudentListFragment;
import com.elaytechnologies.appnotas.view.fragment.TaskListFragment;

public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottombar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.tabTasks:
                        launchFragment(new TaskListFragment());
                        break;
                    case R.id.tabStudents:
                        launchFragment(new StudentListFragment());
                        break;
                    case R.id.tabSettings:
                        launchFragment(new SettingsFragment());
                        break;
                }
                return true;
            }
        });

        bottomNavigationView.setSelectedItemId(R.id.tabStudents);
    }

    /*----------------------------------------------------------------------------------------------
    * Lanza los fragmentos en el Activity*/
    public void launchFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contextContainer, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }
}
