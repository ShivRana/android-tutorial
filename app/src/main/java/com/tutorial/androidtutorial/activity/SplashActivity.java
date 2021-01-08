package com.tutorial.androidtutorial.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tutorial.androidtutorial.R;
import com.tutorial.androidtutorial.model.User;
import com.tutorial.androidtutorial.prefs.MySharedPreference;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                checkCondition();
            }
        }, 2000);

    }

    private void checkCondition() {
        if (MySharedPreference.getInstance(getApplicationContext()).isUserLoggedIn()) {
            User user = MySharedPreference.getInstance(getApplicationContext()).getUser();
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra("username", user.getName());
            intent.putExtra("phone", user.getPhone());
            startActivity(intent);
            finish();
        } else {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
