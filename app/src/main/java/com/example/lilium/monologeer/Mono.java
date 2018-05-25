package com.example.lilium.monologeer;

import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.realm.RealmObject;

//import io.realm.RealmObject;



public class Mono    extends RealmObject  {

   private String content;
    private int like;

    public Mono() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }



}


