package com.example.dogapp2.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dogapp2.R;
import com.example.dogapp2.databinding.FragmentListBinding;
import com.example.dogapp2.model.DogBreed;
import com.example.dogapp2.model.DogDAO;
import com.example.dogapp2.viewmodel.DogAPIService;
import com.example.dogapp2.viewmodel.DogAdapter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ListFragment extends Fragment{



    private FragmentListBinding binding;
    private DogAPIService apiService;
    private DogDAO dogDAO;
//    private AppDatabase appDatabase;
    private DogAdapter dogAdapter;
    private List<DogBreed> dogBreedList;





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
        apiService = new DogAPIService();
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
                        Log.d("Debug1","Debug"+ e.getMessage());
                    }
                });
        binding.rvDog.setLayoutManager(new GridLayoutManager(getContext(), 2));
        binding.tvSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                dogAdapter.getFilter().filter(binding.tvSearch.getText());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                dogAdapter.getFilter().filter(binding.tvSearch.getText());
            }

            @Override
            public void afterTextChanged(Editable s) {
                dogAdapter.getFilter().filter(binding.tvSearch.getText());
            }
        });
    }
}