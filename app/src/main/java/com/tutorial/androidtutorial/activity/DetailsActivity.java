package com.tutorial.androidtutorial.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.tutorial.androidtutorial.R;
import com.tutorial.androidtutorial.adapter.UserAdapter;
import com.tutorial.androidtutorial.fragment.DetailFragment;
import com.tutorial.androidtutorial.model.User;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {

    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        if (getIntent().hasExtra("username") && getIntent().hasExtra("password")) {
            username = getIntent().getStringExtra("username");
            password = getIntent().getStringExtra("password");
//            showTheList();
            //  openFragment(username);
            setRecyclerView();
        } else {
            Toast.makeText(this, "No data is received", Toast.LENGTH_SHORT).show();
        }
        Button btStartAnim = findViewById(R.id.bt_start);
        btStartAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                clockwise();
//                showProgress();
                fireEvent();
            }
        });
    }

    private void fireEvent() {
        Intent intent = new Intent("VIRENDRA");
        intent.putExtra("username", username);
        sendBroadcast(intent);
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


    public void clockwise() {
        ImageView image = (ImageView) findViewById(R.id.iv_anim);
        Animation animation1 = AnimationUtils.loadAnimation(this,
                R.anim.clockwise);
        image.startAnimation(animation1);
    }


    public void showProgress() {
        final ProgressDialog progress = new ProgressDialog(this);
        progress.setMessage("Downloading Music");
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress.setIndeterminate(false);
        progress.setProgress(0);
        progress.show();

        final int totalProgressTime = 100;
        final Thread t = new Thread() {
            @Override
            public void run() {
                int jumpTime = 0;

                while (jumpTime < totalProgressTime) {
                    try {
                        sleep(1000);
                        jumpTime += 2;
                        progress.setProgress(jumpTime);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
    }


    private void showTheList() {
        ListView listView = findViewById(R.id.listview);
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Item 1");
        arrayList.add("Item 2");
        arrayList.add("Item 3");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList);
        listView.setAdapter(adapter);

    }

    void setRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

        ArrayList<User> userArrayList = new ArrayList<>();
        userArrayList.add(new User("Ram", "8497576585"));
        userArrayList.add(new User("Shyam", "8497576585"));
        userArrayList.add(new User("Steve", "8497576585"));
        userArrayList.add(new User("John", "84975765695"));
        userArrayList.add(new User("Rahul", "849757653645"));
        userArrayList.add(new User("Vinay", "84975765655"));

        UserAdapter adapter = new UserAdapter(this, userArrayList);
        recyclerView.setAdapter(adapter);


    }
}