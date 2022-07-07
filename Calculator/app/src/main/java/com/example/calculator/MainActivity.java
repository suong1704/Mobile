package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.calculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    MyViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View viewRoot = binding.getRoot();
        setContentView(viewRoot);

        model = new ViewModelProvider(this).get(MyViewModel.class);
        model.getStr().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {

                binding.editText.setText(model.getStr().getValue());
            }
        });
        binding.bt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.setStr(binding.editText.getText()+(String) binding.bt0.getText());
            }
        });
        binding.bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.setStr(binding.editText.getText()+(String) binding.bt1.getText());
            }
        });
        binding.bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.setStr(binding.editText.getText()+(String) binding.bt2.getText());
            }
        });
        binding.bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.setStr(binding.editText.getText()+(String) binding.bt3.getText());
            }
        });
        binding.bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.setStr(binding.editText.getText()+(String) binding.bt4.getText());
            }
        });
        binding.bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.setStr(binding.editText.getText()+(String) binding.bt5.getText());
            }
        });
        binding.bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.setStr(binding.editText.getText()+(String) binding.bt6.getText());
            }
        });
        binding.bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.setStr(binding.editText.getText()+(String) binding.bt7.getText());
            }
        });
        binding.bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.setStr(binding.editText.getText()+(String) binding.bt8.getText());
            }
        });
        binding.bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.setStr(binding.editText.getText()+(String) binding.bt9.getText());
            }
        });
        binding.btCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.setStr(binding.editText.getText()+(String) binding.btCong.getText());
            }
        });
        binding.btTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.setStr(binding.editText.getText()+(String) binding.btTru.getText());
            }
        });
        binding.btNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.setStr(binding.editText.getText()+(String) binding.btNhan.getText());
            }
        });
        binding.btChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.setStr(binding.editText.getText()+(String) binding.btChia.getText());
            }
        });

    }
}