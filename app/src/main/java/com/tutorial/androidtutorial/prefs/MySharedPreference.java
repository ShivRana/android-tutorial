package com.tutorial.androidtutorial.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.tutorial.androidtutorial.model.User;

public class MySharedPreference {
    private final SharedPreferences sharedPref;
    static MySharedPreference instance;

    public static MySharedPreference getInstance(Context context) {
        if (instance == null) {
            instance = new MySharedPreference(context);
        }
        return instance;
    }

    public MySharedPreference(Context context) {
        sharedPref = context.getSharedPreferences("AndroidTutorial", 0);
    }

    public void saveUser(User user) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("name", user.getName());
        editor.putString("phone", user.getPhone());
        editor.apply();
    }

    public boolean isUserLoggedIn() {
        return sharedPref.contains("name");
    }

    public User getUser() {
        String name = sharedPref.getString("name", null);
        String phone = sharedPref.getString("phone", null);
        User user = new User(name, phone);
        return user;
    }


}
