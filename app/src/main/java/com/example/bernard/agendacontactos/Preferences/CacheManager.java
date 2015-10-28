package com.example.bernard.agendacontactos.Preferences;

import android.content.Context;
import android.content.SharedPreferences;


import com.example.bernard.agendacontactos.Contact;

import java.util.UUID;


public class CacheManager {
    private final static int PRIVATE_MODE = 0 ;  // personne ne peut lire privé
    //private final static String PREF_NAME = "app.com.name.preferences";  // ou se va garder les données
    private final static String PREF_NAME = "myprefs";  // ou se va garder les données

    private SharedPreferences pref;
    private SharedPreferences.Editor mEditor;

    public CacheManager(Context context){
        this.pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        this.mEditor = pref.edit();
    }

    public void setUser(Contact contact){
        String ids = UUID.randomUUID().toString();
        mEditor.putString(KeyShared.KEY_ID, ids);
        mEditor.putString(KeyShared.KEY_NAME, contact.getName());
        mEditor.putString(KeyShared.KEY_EMAIL, contact.getEmail());
        mEditor.putString(KeyShared.KEY_CEL, contact.getCel());
        mEditor.putString(KeyShared.KEY_PHONE, contact.getPhone());
        mEditor.putBoolean(KeyShared.KEY_FIRST, true);
        mEditor.commit();
    }
    // coordinatorLayout à mettre dans main
    // faire cette méthode pour lire les données
    public void getUser(Contact contact){
        contact.setIds(pref.getString(KeyShared.KEY_ID, ""));
        contact.setName(pref.getString(KeyShared.KEY_NAME, ""));
        contact.setEmail(pref.getString(KeyShared.KEY_EMAIL, ""));
        contact.setCel(pref.getString(KeyShared.KEY_CEL, ""));
        contact.setPhone(pref.getString(KeyShared.KEY_PHONE, ""));
    }

    public void DelUser(String idsDel){
        mEditor.clear();
        //mEditor.remove(KeyShared.KEY_NAME);
        mEditor.commit();
    }

    public void clear(){
        mEditor.clear();
        mEditor.commit();
    }

    public boolean isloggin(){
        return pref.getBoolean(KeyShared.KEY_FIRST, false);
    }

    class KeyShared{

        final static String KEY_ID = "_id";
        final static String KEY_NAME = "_name";
        final static String KEY_EMAIL = "_email";
        final static String KEY_CEL = "_cel";
        final static String KEY_PHONE = "_phone";
        final static String KEY_FIRST = "_first";

    }
}


