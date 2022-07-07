package com.example.calculator;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class MyViewModel extends ViewModel {
    private MutableLiveData<String> str;
    private String string;
    public LiveData<String> getStr() {
        if (str == null) {
            str = new MutableLiveData<String>();
            str.setValue(" ");
        }
        return str;
    }
    public void setStr(String s){

        str.setValue(s);
    }

    public String getString() {
//        string = str;
        return str.getValue();
    }
}
