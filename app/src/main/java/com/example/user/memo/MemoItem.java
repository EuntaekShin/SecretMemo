package com.example.user.memo;

import android.graphics.Bitmap;

/**
 * Created by user on 2017-03-16.
 */

public class MemoItem {

    String contents;
    String firendName;
    String frinedMoblie;
    String timeStamp;
    Bitmap imageBitmap;


    public MemoItem(String contents, String firendName, String frinedMoblie, String timeStamp, Bitmap imageBitmap) {
        this.contents = contents;
        this.firendName = firendName;
        this.frinedMoblie = frinedMoblie;
        this.timeStamp = timeStamp;
        this.imageBitmap = imageBitmap;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getFirendName() {
        return firendName;
    }

    public void setFirendName(String firendName) {
        this.firendName = firendName;
    }

    public String getFrinedMoblie() {
        return frinedMoblie;
    }

    public void setFrinedMoblie(String frinedMoblie) {
        this.frinedMoblie = frinedMoblie;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Bitmap getImageBitmap() {
        return imageBitmap;
    }

    public void setImageBitmap(Bitmap imageBitmap) {
        this.imageBitmap = imageBitmap;
    }
}
