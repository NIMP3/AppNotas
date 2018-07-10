package com.elaytechnologies.appnotas.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.elaytechnologies.appnotas.R;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    /*----------------------------------------------------------------------------------------------
    * Cargamos la vista del Menu del Profesor*/
    public void goMenuTeacher(View view) {
        Intent intent = new Intent(this, TeacherActivity.class);
        startActivity(intent);
        finish();
    }
}
