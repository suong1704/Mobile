package com.pbl.pbl5;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> implements Filterable {

    private static ArrayList<Users> usersArrayList;

    public UsersAdapter(ArrayList<Users> usersArrayList) {
        this.usersArrayList = usersArrayList;
    }

    @Override
    public Filter getFilter() {
        return null;
    }


    @NonNull
    @Override
    public UsersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from((parent.getContext()))
                .inflate(R.layout.user_item , parent , false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersAdapter.ViewHolder holder, int position) {
        holder.tv_name_item.setText(usersArrayList.get(position).getName());
        holder.tv_heartbeart_item.setText(usersArrayList.get(position).getHeartBeat() +" bpm");



    }


    @Override
    public int getItemCount() {
        return usersArrayList.size();
    }

    public static class ViewHolder extends  RecyclerView.ViewHolder{
        public TextView tv_name_item , tv_heartbeart_item ;
        public TextView  tv_name_detail , tv_heartbeart_detail;
        public ImageView avt;
        public ViewHolder(@NonNull View view) {
            super(view);
            tv_name_item = view.findViewById(R.id.tv_name);
            tv_heartbeart_item = view.findViewById(R.id.tv_heartbeat);
            avt = view.findViewById(R.id.image_avt);
            view.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceType")
                @Override
                public void onClick(View v) {
                    Users user = usersArrayList.get(getAdapterPosition());
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("user", user);
                    Navigation.findNavController(view).navigate(R.layout.fragment_detail,bundle);
                }
            });
        }
    }
}
