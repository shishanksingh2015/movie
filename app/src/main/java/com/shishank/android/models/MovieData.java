package com.shishank.android.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * @author shishank
 */

@Entity
public class MovieData {

    @PrimaryKey
    private int id;
    @ColumnInfo(name = "like")
    private boolean like;
    @ColumnInfo(name = "disLike")
    private boolean disLike;
    @ColumnInfo(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }

    public boolean isDisLike() {
        return disLike;
    }

    public void setDisLike(boolean disLike) {
        this.disLike = disLike;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
