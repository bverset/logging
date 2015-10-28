package com.example.bernard.agendacontactos;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.bernard.agendacontactos.Preferences.CacheManager;

public class SplashActivity extends AppCompatActivity {

    private CacheManager cacheManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        cacheManager = new CacheManager(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i;
                if(cacheManager.isloggin()){
                    i = new Intent(SplashActivity.this, MainActivity.class);
                }
                else {
                    i = new Intent(SplashActivity.this, LoginActivity.class);
                }
                startActivity(i);
            }
        }, 3000);
    }
}
