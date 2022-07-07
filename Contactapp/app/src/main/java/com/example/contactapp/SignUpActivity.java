package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.AsyncQueryHandler;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import com.example.contactapp.databinding.ActivityMainBinding;
import com.example.contactapp.databinding.ActivitySignUpBinding;

import java.util.ArrayList;
import java.util.List;

public class SignUpActivity extends AppCompatActivity {
    private ActivitySignUpBinding binding;
    private  AppDatabase appDatabase;
    private  ContactDAO contactDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        appDatabase = AppDatabase.getInstance(this);
        contactDAO = appDatabase.contactDAO();

        binding.btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contact contact1 = new Contact(binding.username.getText().toString(),
                                                binding.phone.getText().toString() ,
                                                binding.email.getText().toString());
                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        contactDAO.insertAll(contact1);
                    }
                });
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
//                intent.putExtra("username" , binding.username.getText().toString());
//                intent.putExtra("phone" , binding.phone.getText().toString());
//                intent.putExtra("email" , binding.email.getText().toString());
                startActivity(intent);
            }
        });
    }

}