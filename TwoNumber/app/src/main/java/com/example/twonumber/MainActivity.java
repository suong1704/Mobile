package com.example.twonumber;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.twonumber.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    MyViewModel model;
    ArrayList<String> listString;
    ArrayAdapter<String> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View viewRoot = binding.getRoot();
        setContentView(viewRoot);

        listString = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listString);
        model = new ViewModelProvider(this).get(MyViewModel.class);
        listString = model.getListStr();
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listString);
        binding.listItem.setAdapter(arrayAdapter);
        model.getStr().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                model.getListStr().add(s);
                arrayAdapter.notifyDataSetChanged();
            }
        });
        binding.btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = binding.editTextA.getText() + " + " + binding.editTextB.getText();
                model.setStr(s);
//                binding.listItem.setAdapter();
            }
        });
        binding.btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = binding.editTextA.getText() + " - " + binding.editTextB.getText();
                model.setStr(s);
            }
        });
        binding.btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = binding.editTextA.getText() + " * " + binding.editTextB.getText();
                model.setStr(s);
            }
        });
        binding.btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = binding.editTextA.getText() + " / " + binding.editTextB.getText();
                model.setStr(s);
            }
        });
    }

}