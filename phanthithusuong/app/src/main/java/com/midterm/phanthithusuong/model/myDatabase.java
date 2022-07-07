package com.midterm.phanthithusuong.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities =  {mymodel.class }, version =  1)
public abstract class myDatabase extends RoomDatabase {
public  abstract modelDao modelDao();
private static  myDatabase instance;
public static myDatabase getInstance(Context context){
        if (instance == null){
        instance = Room.databaseBuilder(context,
                myDatabase.class, "mydatabase").build();
        }
        return instance;
        }

}
