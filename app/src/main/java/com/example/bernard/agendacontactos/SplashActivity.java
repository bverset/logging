package com.example.bernard.agendacontactos;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        int TIME = 3000;
        new Handler().postDelayed(new Runnable() {

            public void run() {
                Intent i = new Intent(SplashActivity.this, LoggingActivity.class);
                startActivity(i);
                finish();
            }
        }, TIME);
    }


}
