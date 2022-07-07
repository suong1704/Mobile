package com.example.twonumber;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Locale;

public class MyViewModel extends ViewModel {
    private MutableLiveData<String> str;
    private ArrayList<String> listStr;
    public LiveData<String> getStr() {
        if (str == null) {
            str = new MutableLiveData<String>();
            str.setValue(" ");
        }
        return str;
    }

//    public void setListStrStr(MutableLiveData<String> str) {
//        this.str = str;
//    }

    public void setStr(String s){
        int t = 0;
        String[] s1 = s.split(" ");


//        if(s1[1].equals("+"))  t = "+";
//        if(s1[1].equals("-"))  t = "-";
//        if(s1[1].equals("*"))  t = "*";
//        if(s1[1].equals("/"))  t = "/";

        if(s1[1].equals("+"))  t = Integer.parseInt(s1[0]) + Integer.parseInt(s1[2]);
        if(s1[1].equals("-"))  t = Integer.parseInt(s1[0]) - Integer.parseInt(s1[2]);
        if(s1[1].equals("*"))  t = Integer.parseInt(s1[0]) * Integer.parseInt(s1[2]);
        if(s1[1].equals("/") ) t = Integer.parseInt(s1[0]) / Integer.parseInt(s1[2]);
        str.setValue(s + " = " + Integer.toString(t));
    }
//    public void addListStr(String s){
//        listStr.add(s);
//    }
    public ArrayList<String> getListStr(){
        if (listStr == null) {
            listStr = new ArrayList<String>();
        }
        return listStr;
    }



//    private MutableLiveData<List<User>> users;
//    public LiveData<List<User>> getUsers() {
//        if (users == null) {
//            users = new MutableLiveData<List<User>>();
//            loadUsers();
//        }
//        return users;
//    }
//
//    private void loadUsers() {
//        // Do an asynchronous operation to fetch users.
//    }
}
