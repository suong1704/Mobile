package com.midterm.phanthithusuong.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface modelDao {
    @Query("SELECT * FROM mymodel")
    public List<mymodel> getAllModel();

    @Insert
    public void insertAll(mymodel mymodels);
}
