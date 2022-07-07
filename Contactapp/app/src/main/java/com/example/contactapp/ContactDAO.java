package com.example.contactapp;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Dao
public interface ContactDAO {

    @Query("SELECT * FROM Contact")
    public List<Contact> getAllContact();

    @Insert
    public  void insertAll(Contact... contact);


}
