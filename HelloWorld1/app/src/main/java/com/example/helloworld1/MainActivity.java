package com.example.helloworld1;

import androidx.activity.result.ActivityResultCaller;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.helloworld1.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding ;
    private MyViewModel model ;

    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> arrayList;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ( requestCode == 1 && resultCode == Activity.RESULT_OK)
        {
            String number = data.getStringExtra("number");
            model.getlistNumber().set(model.IndexOfNum,number);
            arrayAdapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View viewRoot = binding.getRoot();
        setContentView(viewRoot);

        model = new ViewModelProvider(this).get(MyViewModel.class);
        arrayList = model.getlistNumber();
        arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,arrayList);
        binding.lvCount.setAdapter(arrayAdapter);

        model.getnumber().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.tvCount.setText("" + integer);
                model.getlistNumber().add("" +integer);
                arrayAdapter.notifyDataSetChanged();
            }
        });
//        model.getlistNumber().observe(this, new Observer<ArrayList<String>>() {
//            @Override
//            public void onChanged(ArrayList<String> listNumber) {
//                //arrayAdapter = new ArrayAdapter<String>(this,
//                        //android.R.layout.simple_list_item_1,listNumber);
//            }
//        });



        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.increaseNumber();
            }
        });

//        binding.btnSub.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View view) {
//                model.decreaseNumber();
//            }
//        });

        binding.lvCount.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                arrayList.remove(i);
                arrayAdapter.notifyDataSetChanged();
                return false;
            }
        });

        binding.lvCount.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                model.IndexOfNum = i ;
                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                intent.putExtra("number",arrayList.get(i));
                //startActivity(intent);
                startActivityForResult(intent,1);
            }

        });



    }
}