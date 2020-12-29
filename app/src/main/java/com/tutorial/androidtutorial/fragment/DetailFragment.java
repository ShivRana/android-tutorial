package com.tutorial.androidtutorial.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

import com.tutorial.androidtutorial.R;

public class DetailFragment extends Fragment {
    private String username;
    private Context mContext;

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        mContext = context;
        super.onAttach(context);
    }

    public static DetailFragment newInstance(Bundle bundle) {
        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            username = getArguments().getString("username");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        setWidget(rootView);
        return rootView;
    }

    private void setWidget(View rootView) {
//        TextView tvUsername = rootView.findViewById(R.id.tv_username);
//        tvUsername.setText(username);
        Button btFireEvent = rootView.findViewById(R.id.bt_fire_intent);
        btFireEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("username", username);
                intent.setAction("com.tutorial.androidtutorial.FIRE_EVENT");
                mContext.sendStickyBroadcast(intent);
            }
        });
    }
}