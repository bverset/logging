package com.example.bernard.agendacontactos;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


import com.example.bernard.agendacontactos.Preferences.CacheManager;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private CacheManager cacheManager;
    String ids, name, email, cel, phone;
    Long id;
    private CoordinatorLayout coordinatorLayout;
    @Bind(R.id.tv_name)TextView tvName;
    @Bind(R.id.tv_email)TextView tvEmail;
    @Bind(R.id.tv_cel)TextView tvCel;
    @Bind(R.id.tv_phone)TextView tvPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        cacheManager = new CacheManager(this);


        Contact c = new Contact(null, null, null, null);
        cacheManager.getUser(c);
        ids = c.getIds();
        name = c.getName();
        tvName.setText("Name: " + c.getName()+ " id="+ids);
        tvEmail.setText("Email: "+c.getEmail());
        tvCel.setText("Cel: "+c.getCel());
        tvPhone.setText("Phone: "+c.getPhone());
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        Snackbar snackbar = Snackbar.make(coordinatorLayout, "name "+c.getName(), Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    @OnClick(R.id.btn_eliminar)
    public void clickeliminar(View v) {
        cacheManager.DelUser(name);
        this.clickfin(v);
    }
    @OnClick(R.id.btn_fin)
    public void clickfin(View v) {
        this.finish();
    }
}
