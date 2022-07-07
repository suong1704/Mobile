package com.example.dogapp2.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.dogapp2.R;
import com.example.dogapp2.databinding.FragmentDetailBinding;
import com.example.dogapp2.model.DogBreed;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {

    private FragmentDetailBinding binding;
    private static DogBreed dogBreed;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            dogBreed = (DogBreed) getArguments().getSerializable("dogBreed");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(getLayoutInflater(),
                R.layout.fragment_detail, null , false);
        View viewroot = binding.getRoot();
        binding.setDog(dogBreed);
        ImageView avtDetail = binding.detailAvt;
        Log.d("DEBUG1", dogBreed.getUrl());
        Picasso.get().load(dogBreed.getUrl()).into(avtDetail);
        return viewroot;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView avtDetail = binding.detailAvt;
        Log.d("Debug1","Debug "+ dogBreed.getUrl());
        Picasso.get()
                .load(dogBreed.getUrl())
                .error(R.mipmap.ic_launcher)
                .resize(300,200)
                .into(avtDetail);
        binding.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                Navigation.findNavController(view).navigate(R.id.listFragment,bundle);
            }
        });
    }

}