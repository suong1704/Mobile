package com.midterm.phanthithusuong.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.midterm.phanthithusuong.databinding.FragmentMainBinding;
import com.midterm.phanthithusuong.model.mymodel;
import com.midterm.phanthithusuong.viewmodel.myAPIService;
import com.midterm.phanthithusuong.viewmodel.myadapter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class MainFragment extends Fragment {

    private  FragmentMainBinding binding;
    private ArrayList<mymodel> mymodels;
    private myAPIService myAPIService;
    private myadapter myadapter;
    public MainFragment() {
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
        mymodels = new ArrayList<mymodel>();
        myAPIService = new myAPIService();
        myAPIService.getAPI()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<mymodel>>() {
                    @Override
                    public void onSuccess(@io.reactivex.rxjava3.annotations.NonNull List<mymodel> mymodels1) {
                        mymodels = (ArrayList<mymodel>) mymodels1;
                        myadapter = new myadapter(mymodels);
                        binding.myRv.setAdapter(myadapter);
                        for(mymodel model: mymodels1){
                        Log.d("1" , model.getTitle());
                        }
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                        Log.d("2" , e.getMessage());
                    }
                });
        binding.myRv.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}