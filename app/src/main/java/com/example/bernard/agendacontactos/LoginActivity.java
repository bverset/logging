package com.example.bernard.agendacontactos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.example.bernard.agendacontactos.Preferences.CacheManager;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @Bind(R.id.et_nombre) EditText etName;
    @Bind(R.id.et_email) EditText etMail;
    @Bind(R.id.et_celular) EditText etCel;
    @Bind(R.id.et_phone) EditText etPhone;

    private CacheManager cachemanager;

    private final String emailPattern = "[a-zA-Z0-9.-_]+@[a-z]+\\.+[a-z]+";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        cachemanager = new CacheManager(this);
    }

    @OnClick(R.id.btn_login)
    public void clicklogin(View v){
        String name = etName.getText().toString().trim(); // trim est pour retirer espace avant et après
        String email = etMail.getText().toString().trim();
        String cel = etCel.getText().toString();
        String phone = etPhone.getText().toString();

        // pour retirer le clavier quand on clique sur le bouton
        InputMethodManager imn = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imn.hideSoftInputFromWindow(v.getWindowToken(), 0);

        if (name.length()>0 && email.length()> 0 && (cel.length()>0 || phone.length()>0)) {

            if (name.length()<4){
                showError("El nombre no tiene 4 caracteres",v);
            }
            else if (!email.matches(emailPattern)){ // ! est not
                showError("El email es invalido",v);
            }
            else if (cel.length()>0&&cel.length()>=10){
                showError("Cel invalido",v);
            }
            else if (phone.length()>0&&phone.length()>=10){
                    showError("Phone invalido",v);
            }
            else{

                Contact c = new Contact(name, email, cel, phone);
                cachemanager.setUser(c);
                Intent i = new Intent(this,MainActivity.class);
                startActivity(i);
            }
        }
        else{
            showError("Error, todos los campos no estan llenos",v);
        }
    }

    private void showError (String err, View v){
        Snackbar snackbar = Snackbar.make(v, err, Snackbar.LENGTH_LONG);
        snackbar.show();
    }
}
