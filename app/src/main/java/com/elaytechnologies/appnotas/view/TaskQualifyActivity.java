package com.elaytechnologies.appnotas.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.elaytechnologies.appnotas.R;
import com.elaytechnologies.appnotas.adapter.StudentQualifyAdapterRecyclerView;
import com.elaytechnologies.appnotas.model.Student;
import com.elaytechnologies.appnotas.model.Students;

import java.util.ArrayList;

public class TaskQualifyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_qualify);

        showToolbar(getResources().getString(R.string.title_task_qualify),false);

        RecyclerView recyclerView = findViewById(R.id.rvStudentQualifyList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getBaseContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        StudentQualifyAdapterRecyclerView adapterRecyclerView =
                new StudentQualifyAdapterRecyclerView(
                        Students.buildStudents(),
                        this,
                        R.layout.cardview_student_qualify
                );

        recyclerView.setAdapter(adapterRecyclerView);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                if (dy >= 0)
                    recyclerView.smoothScrollToPosition(layoutManager.findLastVisibleItemPosition());
                else
                    recyclerView.smoothScrollToPosition(layoutManager.findFirstVisibleItemPosition());

            }
        });
    }

    /*----------------------------------------------------------------------------------------------
    Muestra el toolbar con diferentes caracteristicas
     */
    public void showToolbar(String title, Boolean upButton) {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_student_assistance,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
