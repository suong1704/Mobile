package com.example.dogapp.Model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DogDAO {
    @Query("SELECT * FROM DogBreed")
    public List<DogBreed> getAllDog();

    @Insert
    public  void insertALl(DogBreed dogBreed);
}
