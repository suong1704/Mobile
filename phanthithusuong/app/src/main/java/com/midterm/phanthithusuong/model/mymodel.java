package com.midterm.phanthithusuong.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity
public class mymodel implements Serializable {
    @ColumnInfo
    @SerializedName("lat")
    String lat;
    @ColumnInfo
    @SerializedName("lng")
    String lng;

    @ColumnInfo
    @SerializedName("desc")
    String desc;

    @ColumnInfo
    @SerializedName("zip")
    String zip;

    @ColumnInfo
    @SerializedName("title")
    String title;

    @ColumnInfo
    @SerializedName("timeStamp")
    String timeStamp;

    @ColumnInfo
    @SerializedName("twp")
    String twp;

    @ColumnInfo
    @SerializedName("addr")
    String addr;

    @ColumnInfo
    @SerializedName("e")
    String e;

    @ColumnInfo
    @SerializedName("")
    String day;

    @ColumnInfo
    @SerializedName("__1")
    String __1;

    @ColumnInfo
    @SerializedName("__2")
    String __2;

    @ColumnInfo
    @SerializedName("__3")
    String __3;


    public mymodel(String lat, String lng, String desc, String zip, String title, String timeStamp, String twp, String addr, String e, String day, String __1, String __2, String __3) {
        this.lat = lat;
        this.lng = lng;
        this.desc = desc;
        this.zip = zip;
        this.title = title;
        this.timeStamp = timeStamp;
        this.twp = twp;
        this.addr = addr;
        this.e = e;
        this.day = day;
        this.__1 = __1;
        this.__2 = __2;
        this.__3 = __3;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getTwp() {
        return twp;
    }

    public void setTwp(String twp) {
        this.twp = twp;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String get__1() {
        return __1;
    }

    public void set__1(String __1) {
        this.__1 = __1;
    }

    public String get__2() {
        return __2;
    }

    public void set__2(String __2) {
        this.__2 = __2;
    }

    public String get__3() {
        return __3;
    }

    public void set__3(String __3) {
        this.__3 = __3;
    }
}
