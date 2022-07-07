package com.example.helloworld1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.helloworld1.databinding.ActivityDetailBinding;
import com.example.helloworld1.databinding.ActivityMainBinding;

public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        View viewRoot = binding.getRoot();
        setContentView(viewRoot);

        Intent intent = getIntent();

        if(intent != null)
        {
            String data = intent.getStringExtra("number");
            binding.tvDetail.setText(data);
        }

        binding.btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("number",binding.tvDetail.getText().toString());
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
    }
}