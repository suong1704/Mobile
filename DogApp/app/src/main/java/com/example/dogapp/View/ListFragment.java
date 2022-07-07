package com.example.dogapp.View;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dogapp.Model.AppDatabase;
import com.example.dogapp.Model.DogBreed;
import com.example.dogapp.Model.DogDAO;
import com.example.dogapp.R;
import com.example.dogapp.ViewModel.DogAdapter;
import com.example.dogapp.ViewModel.DogsAPIService;
import com.example.dogapp.databinding.FragmentListBinding;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class ListFragment extends Fragment{



    private FragmentListBinding binding;
    private DogsAPIService apiService;
    private DogDAO dogDAO;
    private AppDatabase appDatabase;
    private DogAdapter dogAdapter;
    private List<DogBreed> dogBreedList;

    public ListFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = binding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //        appDatabase = AppDatabase.getInstance(this);
//        dogDAO = appDatabase.dogDAO();
//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        View view = binding.getRoot();
//        setContentView(view);
        View rvDog = view.findViewById(R.id.rv_dog);
        dogBreedList = new ArrayList<DogBreed>();
        apiService = new DogsAPIService();
        apiService.getDogs()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<DogBreed>>() {
                    @Override
                    public void onSuccess(@io.reactivex.rxjava3.annotations.NonNull List<DogBreed> dogBreeds) {

                        for (DogBreed dog : dogBreeds) {

                            Log.d("DEBUG1", dog.getLifeSpan());
                        }
                        dogBreedList = dogBreeds;
                        dogAdapter = new DogAdapter((ArrayList<DogBreed>) dogBreedList);

                        binding.rvDog.setAdapter(dogAdapter);


                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                        Log.d("Debug1", e.getMessage());
                    }
                });
        binding.rvDog.setLayoutManager(new GridLayoutManager(getContext(), 2));

    }
}