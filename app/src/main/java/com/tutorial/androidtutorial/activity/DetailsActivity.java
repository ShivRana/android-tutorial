package com.tutorial.androidtutorial.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

import com.tutorial.androidtutorial.R;
import com.tutorial.androidtutorial.fragment.DetailFragment;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        if (getIntent().hasExtra("username") && getIntent().hasExtra("password")) {
            String username = getIntent().getStringExtra("username");
            String password = getIntent().getStringExtra("password");
            openFragment(username);
        } else {
            Toast.makeText(this, "No data is received", Toast.LENGTH_SHORT).show();
        }
    }

    private void openFragment(String username) {
        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fl_container, DetailFragment.newInstance(bundle))
//                .addToBackStack("name") // name can be null
                .commit();
    }
}