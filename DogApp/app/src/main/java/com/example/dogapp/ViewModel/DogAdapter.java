package com.example.dogapp.ViewModel;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dogapp.Model.DogBreed;
import com.example.dogapp.R;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DogAdapter extends RecyclerView.Adapter<DogAdapter.ViewHolder> implements Filterable {
    private static ArrayList<DogBreed> dogBreeds;
    public DogAdapter(ArrayList<DogBreed> dogBreedList){
        this.dogBreeds = dogBreedList;
    }

    @Override
    public Filter getFilter() {
        return null;
    }


    @NonNull
    @Override
    public DogAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from((parent.getContext()))
                .inflate(R.layout.dog_item , parent , false);
        return  new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvName.setText(dogBreeds.get(position).getName());
        holder.tvBredfor.setText(dogBreeds.get(position).getBredfor());
        Picasso.get()
                .load(dogBreeds.get(position).getUrl())
                .into(holder.ivAvatar);

    }


    @Override
    public int getItemCount() {
        return dogBreeds.size();
    }
    public static class ViewHolder extends  RecyclerView.ViewHolder{
        public TextView tvName;
        public TextView tvBredfor;
        public ImageView ivAvatar;
        public ViewHolder(View view) {
            super(view);
            tvName = view.findViewById(R.id.tv_name);
            ivAvatar = view.findViewById(R.id.avt);
            tvBredfor = view.findViewById(R.id.tv_bredfor);
            view.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceType")
                @Override
                public void onClick(View v) {
                    DogBreed dog = dogBreeds.get(getAdapterPosition());
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("dogBreed",  dog);
                    Navigation.findNavController(view).navigate(R.id.detailFragment,bundle);
                }
            });

        }


    }

}
