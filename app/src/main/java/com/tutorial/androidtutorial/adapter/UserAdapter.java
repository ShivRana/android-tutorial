package com.tutorial.androidtutorial.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tutorial.androidtutorial.R;
import com.tutorial.androidtutorial.model.User;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    private final Context context;
    private final ArrayList<User> users;
    private final OnItemClickListener onItemClickListener;

    public UserAdapter(Context context, ArrayList<User> users, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.users = users;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public UserAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.tvName.setText(users.get(position).getName());
        holder.tvPhone.setText(users.get(position).getPhone());

        holder.btShowUSer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(v, users.get(position), position);
            }
        });
        holder.tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(v, users.get(position), position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvPhone;
        Button btShowUSer;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvPhone = itemView.findViewById(R.id.tv_phone);
            btShowUSer = itemView.findViewById(R.id.bt_show_user);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, User user, int position);
    }
}
