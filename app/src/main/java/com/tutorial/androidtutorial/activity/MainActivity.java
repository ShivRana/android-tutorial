package com.tutorial.androidtutorial.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tutorial.androidtutorial.R;
import com.tutorial.androidtutorial.activity.DetailsActivity;

public class MainActivity extends Activity {
    EditText etUsername;
    EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        Button btSubmit = findViewById(R.id.bt_submit);
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
            } else {
                Toast.makeText(this, "Password is empty", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Username is empty", Toast.LENGTH_SHORT).show();
        }

    }
}
