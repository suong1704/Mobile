package com.pbl.pbl5;

import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Users implements Serializable {
    private String Name;
    private String HeartBeat;
    private String Location;

    public Users(String name, String heartBeat, String location) {
        Name = name;
        HeartBeat = heartBeat;
        Location = location;
    }



    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getHeartBeat() {
        return HeartBeat;
    }

    public void setHeartBeat(String heartBeat) {
        HeartBeat = heartBeat;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }
}
