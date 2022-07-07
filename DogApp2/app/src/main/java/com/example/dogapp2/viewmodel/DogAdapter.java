package com.example.dogapp2.viewmodel;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dogapp2.R;
import com.example.dogapp2.model.DogBreed;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class DogAdapter extends RecyclerView.Adapter<DogAdapter.ViewHolder> implements Filterable {
    private static ArrayList<DogBreed> dogBreeds;
    private static ArrayList<DogBreed> dogBreeds1;



    public DogAdapter(ArrayList<DogBreed> dogBreedList){
        this.dogBreeds = dogBreedList;
        this.dogBreeds1 = dogBreedList;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String strSearch = constraint.toString();
                if (strSearch.isEmpty()){
                    dogBreeds = dogBreeds1;
                }else{
                    ArrayList<DogBreed> list = new ArrayList<>();
                    for(DogBreed dog : dogBreeds1){
                        if(dog.getName().toLowerCase().contains(strSearch.toLowerCase())){
                            list.add(dog);
                        }
                    }
                    dogBreeds = list;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values=dogBreeds;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                dogBreeds = (ArrayList<DogBreed>) results.values;
                notifyDataSetChanged();
            }
        };
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


        holder.sp_Name.setText("Name: " + dogBreeds.get(position).getName());
        holder.sp_BredFor.setText("Bred For: " + dogBreeds.get(position).getBredfor());
        holder.sp_Origin.setText("Origin: " + dogBreeds.get(position).getOrigin() );
        holder.sp_LifeSpan.setText("Life Span: " + dogBreeds.get(position).getLifeSpan());

    }


    @Override
    public int getItemCount() {
        return dogBreeds.size();
    }
    public static class ViewHolder extends  RecyclerView.ViewHolder{
        public TextView tvName , sp_Name , sp_Origin , sp_BredFor , sp_LifeSpan ;
        public TextView tvBredfor;
        public ImageView ivAvatar;
        public ViewHolder(View view) {
            super(view);
            tvName = view.findViewById(R.id.tv_name);
            ivAvatar = view.findViewById(R.id.avt);
            tvBredfor = view.findViewById(R.id.tv_bredfor);
            sp_Name = view.findViewById(R.id.swipe_name);
            sp_BredFor = view.findViewById(R.id.swipe_bredfor);
            sp_LifeSpan = view.findViewById(R.id.swipe_lifespan);
            sp_Origin = view.findViewById(R.id.swipe_origin);
            ivAvatar.setOnClickListener(new View.OnClickListener() {
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
