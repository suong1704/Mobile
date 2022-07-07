package com.example.helloworld;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.helloworld.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity {
    private TextView tvCount;
    private FloatingActionButton btnUp;
    private FloatingActionButton btnDown;
//    ActivityMainBinding  binding;
//    MyViewModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        View viewRoot = binding.getRoot();
//        setContentView(viewRoot);

//        MyViewModel model = new ViewModelProvider(this).get(MyViewModel.class);
//        model.getNumber().observe(this, number -> {
//            binding.tvCount.setText(number);
//        });
//        model.getNumber().observe(this, new Observer<Integer>() {
//            @Override
//            public void onChanged(Integer integer) {
////                binding.tvCount.setText("" + integer);
//                binding.tvcount.setText("" + integer);
//            }
//        });
        tvCount = findViewById(R.id.tv_count);
        btnUp = findViewById(R.id.btn_up);
//        btnDown = findViewById(R.id.btn_down);
        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                model.increaseNumber();
                int count1 = Integer.parseInt(tvCount.getText().toString());
                tvCount.setText("" + ++count1);
            }
        });
//        binding.btnUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                int count1 = Integer.parseInt(binding.tvCount.getText().toString());
////                binding.tvCount.setText("" + ++count1);
//                model.increaseNumber();
//            }
//        });

//        binding.btnDown.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int count2 = Integer.parseInt(binding.tvCount.getText().toString());
//                binding.tvCount.setText("" + --count2);
//            }
//        });
    }
}