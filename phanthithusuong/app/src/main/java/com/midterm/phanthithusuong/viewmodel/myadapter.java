package com.midterm.phanthithusuong.viewmodel;

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

import com.midterm.phanthithusuong.R;
import com.midterm.phanthithusuong.model.mymodel;

import java.util.ArrayList;
import java.util.List;

public class myadapter extends RecyclerView.Adapter<myadapter.ViewHolder> implements Filterable {
    private static ArrayList<mymodel> mymodels;
    private static ArrayList<mymodel> mymodel1;
    public  myadapter(ArrayList<mymodel> mymodellist){this.mymodels = mymodellist;}




    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String strSearch = constraint.toString();
                if (strSearch.isEmpty()){
                    mymodels = mymodel1;
                }else{
                    List<mymodel> list = new ArrayList<>();
                    for(mymodel model : mymodel1){
                        if(model.getZip().toLowerCase().contains(strSearch.toLowerCase())){
                            list.add(model);
                        }
                    }
                    mymodels = (ArrayList<mymodel>) list;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values=mymodels;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                mymodels = (ArrayList<mymodel>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    @NonNull
    @Override
    public myadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from((parent.getContext()))
                .inflate(R.layout.my_item , parent , false);
        return  new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTitle.setText(mymodels.get(position).getTitle());
        holder.tvdesc.setText(mymodels.get(position).getDesc());
        holder.tvtime.setText(mymodels.get(position).getTimeStamp());
    }

    @Override
    public int getItemCount() {
        return mymodels.size();
    }
public static class ViewHolder extends  RecyclerView.ViewHolder {
    public TextView tvTitle;
    public TextView tvdesc;
    public TextView tvtime;

    public ViewHolder(View view) {
        super(view);
        tvTitle = view.findViewById(R.id.tv_title1);
        tvdesc = view.findViewById(R.id.tv_desc1);
        tvtime = view.findViewById(R.id.tv_timestamp1);
        view.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                mymodel mymodel;
                mymodel = mymodels.get(getAdapterPosition());
                Bundle bundle = new Bundle();
                bundle.putSerializable("mymodel" , mymodel);
                Navigation.findNavController(view).navigate(R.id.detailFragment,bundle);
            }
        });

    }
}
}


