package com.example.contactapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> implements Filterable{
    public ContactAdapter(List<Contact> contacts) {
        this.contacts = contacts;
        this.mcontacts = contacts;
    }

    private List<Contact> contacts;
    private List<Contact> mcontacts;


    @NonNull
    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ViewHolder holder, int position) {
        holder.tvName.setText(contacts.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    /**
     * <p>Returns a filter that can be used to constrain data with a filtering
     * pattern.</p>
     *
     * <p>This method is usually implemented by {@link Adapter}
     * classes.</p>
     *
     * @return a filter used to constrain data
     */


    //Search
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String strSearch = constraint.toString();
                if (strSearch.isEmpty()){
                    contacts = mcontacts;
                }else{
                    List<Contact> list = new ArrayList<>();
                    for(Contact contact : mcontacts){
                        if(contact.getName().toLowerCase().contains(strSearch.toLowerCase())){
                            list.add(contact);
                        }
                    }
                    contacts = list;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values=contacts;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                contacts = (List<Contact>) results.values;
                notifyDataSetChanged();
            }
        };
    }


    public static class ViewHolder extends  RecyclerView.ViewHolder{
        public TextView tvName;
        public ImageView ivAvatar;
        public ViewHolder(View view) {
            super(view);
            tvName = view.findViewById(R.id.tv_name);
            ivAvatar = view.findViewById(R.id.iv_avatar);

        }


    }
}
