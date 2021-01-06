package com.tutorial.androidtutorial.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tutorial.androidtutorial.R;
import com.tutorial.androidtutorial.model.User;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context context;
    private final ArrayList<User> users;

    public UserAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((MyViewHolder) holder).tvName.setText(users.get(position).getName());
        ((MyViewHolder) holder).tvPhone.setText(users.get(position).getPhone());

    }

    @Override
    public int getItemCount() {
        return users.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvPhone;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvPhone = (TextView) itemView.findViewById(R.id.tv_phone);
        }
    }
}
