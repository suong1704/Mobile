package com.example.helloworld1;

import android.widget.ArrayAdapter;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> number;
    private ArrayList<String> listNumber;
    public Integer IndexOfNum;


    public LiveData<Integer> getnumber() {
        if (number == null) {
            number = new MutableLiveData<Integer>();
            number.setValue(0);
        }
        return number;
    }

    public void increaseNumber() {
        number.setValue(number.getValue() + 1);
    }

//    public void decreaseNumber() {
//        number.setValue(number.getValue() - 1);
//    }

    public ArrayList<String> getlistNumber() {
        if (listNumber == null) {
            listNumber = new ArrayList<String>();
        }
        return listNumber;
    }

    public void setNumber(Integer integer)
    {
        listNumber.add(""+ integer);
    }


}

