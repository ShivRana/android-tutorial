package com.tutorial.androidtutorial.broadcatreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.hasExtra("username")) {
            String username = intent.getStringExtra("username");
            Toast.makeText(context, "OnReceive Called, the username is -> " + username, Toast.LENGTH_LONG).show();
        }

    }
}
