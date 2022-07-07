package com.example.dogapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dogapp2.databinding.ActivityMainBinding;
import com.example.dogapp2.model.DogBreed;
import com.example.dogapp2.model.DogDAO;
import com.example.dogapp2.viewmodel.DogAPIService;
import com.example.dogapp2.viewmodel.DogAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;
    private DogAPIService apiService;
    private DogDAO dogDAO;
//    private AppDatabase appDatabase;
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