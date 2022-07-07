package com.pbl.pbl5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pbl.pbl5.databinding.FragmentHomeBinding;

import java.util.ArrayList;


public class HomeFragment extends Fragment {


    private FragmentHomeBinding binding;
    private UsersAdapter usersAdapter;
    private ArrayList<Users> users;


    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        return fragment;
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
        users = new ArrayList<Users>();
        users.add(new Users("Phan Thị Thu Sương" , "90" , " "));
        users.add(new Users("Phan Thị Thu Duyên" , "90" , " "));
        usersAdapter = new UsersAdapter((ArrayList<Users>) users);
        binding.rvUsers.setAdapter(usersAdapter);
        binding.rvUsers.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}