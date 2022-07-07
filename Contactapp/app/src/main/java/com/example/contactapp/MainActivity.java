package com.example.contactapp;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import com.example.contactapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private List<Contact> contactList;
    private ContactAdapter contactAdapter;
    private  AppDatabase appDatabase;
    private  ContactDAO contactDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        Intent intent = getIntent();
        appDatabase = AppDatabase.getInstance(this);
        contactDAO = appDatabase.contactDAO();
        contactList = new ArrayList<Contact>();
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
//                Contact contact1 = new Contact("NVA", "0346587524" , "a@gmail.com");
//                Contact contact2 = new Contact("NVB", "0346582544" , "b@gmail.com");
//                contactDAO.insertAll(contact1, contact2);
                contactList = contactDAO.getAllContact();
                contactAdapter = new ContactAdapter(contactList);
                binding.rvContacts.setAdapter((contactAdapter));

            }
        });

        binding.rvContacts.setLayoutManager(new LinearLayoutManager(this));
//        contactAdapter = new ContactAdapter(contactList);
//        binding.rvContacts.setAdapter((contactAdapter));
//        binding.rvContacts.setLayoutManager(new LinearLayoutManager(this));

        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
//                startActivityForResult(intent, RESULT_PRODUCT_ACTIVITY);
            }
        });
        binding.searchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                contactAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                contactAdapter.getFilter().filter(newText);

                return false;
            }
        });
    }
}