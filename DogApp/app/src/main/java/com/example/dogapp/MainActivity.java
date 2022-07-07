package com.example.dogapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;

import com.example.dogapp.Model.AppDatabase;
import com.example.dogapp.Model.DogBreed;
import com.example.dogapp.Model.DogDAO;
import com.example.dogapp.ViewModel.DogAdapter;
import com.example.dogapp.ViewModel.DogsAPIService;
import com.example.dogapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;
    private DogsAPIService apiService;
    private DogDAO dogDAO;
    private AppDatabase appDatabase;
    private DogAdapter dogAdapter;
    private List<DogBreed> dogBreedList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

    }



}