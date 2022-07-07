package com.example.dogapp.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dogapp.Model.DogBreed;
import com.example.dogapp.R;
import com.example.dogapp.databinding.FragmentDetailBinding;
import com.squareup.picasso.Picasso;


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
        return viewroot;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        Picasso.get().load(dogBreed.getUrl()).into(binding.detailAvt);
        Picasso.get().load(dogBreed.getUrl()).into(binding.detailAvt);
    }
}