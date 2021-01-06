package com.tutorial.androidtutorial.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tutorial.androidtutorial.R;
import com.tutorial.androidtutorial.activity.DetailsActivity;
import com.tutorial.androidtutorial.broadcatreceiver.MyReceiver;

public class MainActivity extends Activity {
    EditText etUsername;
    EditText etPassword;
    private MyReceiver myReceiver;
    private IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        Button btSubmit = findViewById(R.id.bt_submit);
        myReceiver = new MyReceiver();
        intentFilter = new IntentFilter("VIRENDRA");
        registerReceiver(myReceiver, intentFilter);
        btSubmit.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            validate();
                                        }
                                    }
        );

    }

    private void validate() {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();
//        Log.d("AndroidTut", "credential:-> " + username + ", " + password);
//        Toast.makeText(this, "credential:-> " + username + ", " + password, Toast.LENGTH_SHORT).show();

        if (username != null && !username.isEmpty()) {
            if (password != null && !password.isEmpty()) {
                Intent intent = new Intent(this, DetailsActivity.class);
                intent.putExtra("username", username);
                intent.putExtra("password", password);
                startActivity(intent);
//                openDialog();
            } else {
                Toast.makeText(this, "Password is empty", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Username is empty", Toast.LENGTH_SHORT).show();
        }

    }

    private void openDialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        //write the code for the dialog

        dialog.setTitle("Title")
                .setMessage("Message")
                .setNegativeButton("No", null)
                .setPositiveButton("Yes", null)
                .show();

    }

//    public void openDialog() {
//        final Dialog dialog = new Dialog(this); // Context, this, etc.
//        dialog.setContentView(R.layout.dialog_demo);
//        dialog.setTitle(R.string.dialog_title);
//        dialog.show();
//    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myReceiver);
    }
}
