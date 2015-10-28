package com.example.bernard.agendacontactos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import com.example.bernard.agendacontactos.Preferences.CacheManager;

public class MainActivity extends AppCompatActivity {

    private CacheManager cacheManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cacheManager = new CacheManager(this);
    }
}
