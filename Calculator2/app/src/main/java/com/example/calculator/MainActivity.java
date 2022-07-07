package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.calculator.databinding.ActivityMainBinding;
public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    boolean Cong = false;
    boolean Tru = false;
    boolean Nhan = false;
    boolean Chia = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = binding.tvRes.getText().toString();
                binding.tvRes.setText(text + "1");
            }
        });
        binding.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = binding.tvRes.getText().toString();
                binding.tvRes.setText(text + "2");
            }
        });
        binding.btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = binding.tvRes.getText().toString();
                binding.tvRes.setText(text + "3");
            }
        });
        binding.btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = binding.tvRes.getText().toString();
                binding.tvRes.setText(text + "4");
            }
        });
        binding.btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = binding.tvRes.getText().toString();
                binding.tvRes.setText(text + "5");
            }
        });
        binding.btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = binding.tvRes.getText().toString();
                binding.tvRes.setText(text + "6");
            }
        });
        binding.btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = binding.tvRes.getText().toString();
                binding.tvRes.setText(text + "7");
            }
        });
        binding.btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = binding.tvRes.getText().toString();
                binding.tvRes.setText(text + "8");
            }
        });
        binding.btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = binding.tvRes.getText().toString();
                binding.tvRes.setText(text + "9");
            }
        });
        binding.btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = binding.tvRes.getText().toString();
                binding.tvRes.setText(text + "0");
            }
        });
        binding.btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = binding.tvRes.getText().toString();
                binding.tvRes.setText(text + " + ");
                Cong = true;
            }
        });
        binding.btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = binding.tvRes.getText().toString();
                binding.tvRes.setText(text + " - ");
                Tru = true;
            }
        });
        binding.btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = binding.tvRes.getText().toString();
                binding.tvRes.setText(text + " * ");
                Nhan = true;
            }
        });
        binding.btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = binding.tvRes.getText().toString();
                binding.tvRes.setText(text + " / ");
                Chia = true;
            }
        });
        binding.btnBang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Cong == true){
                    String text = binding.tvRes.getText().toString();
                    String[] nums = text.split(" ");
                    binding.tvRes.setText(String.valueOf(Float.valueOf(nums[0]) + Float.valueOf(nums[2])));
                    Cong = false;
                }
                if(Tru == true){
                    String text = binding.tvRes.getText().toString();
                    String[] nums = text.split(" ");
                    binding.tvRes.setText(String.valueOf(Float.valueOf(nums[0]) - Float.valueOf(nums[2])));
                    Tru = false;
                }
                if(Nhan == true){
                    String text = binding.tvRes.getText().toString();
                    String[] nums = text.split(" ");
                    binding.tvRes.setText(String.valueOf(Float.valueOf(nums[0]) * Float.valueOf(nums[2])));
                    Nhan = false;
                }
                if(Chia == true){
                    String text = binding.tvRes.getText().toString();
                    String[] nums = text.split(" ");
                    binding.tvRes.setText(String.valueOf(Float.valueOf(nums[0]) / Float.valueOf(nums[2])));
                    Chia = false;
                }
            }
        });
    }

}