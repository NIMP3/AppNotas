package com.elaytechnologies.appnotas;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.elaytechnologies.appnotas.view.LoginActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        goLogin();
    }

    /*----------------------------------------------------------------------------------------------
    * Cargamos la vista de Login*/
    public void goLogin(){
        /*Despues de dos segundos de presentar el Splash Screen
          Lanzamos el Activity de Login*/
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },2000);
    }
}
