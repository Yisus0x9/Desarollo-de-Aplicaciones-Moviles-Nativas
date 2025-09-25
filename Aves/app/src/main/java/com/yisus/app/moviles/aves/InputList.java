package com.yisus.app.moviles.aves;

public class InputList {
    private final int imageId;
    private final String a;
    private final String d;

    public InputList(int imageId, String a, String d) {
        this.imageId = imageId;
        this.a = a;
        this.d = d;
    }

    public String get_textUp(){
        return a;
    }

    String getTextDown(){
        return d;
    }

    int getImageId(){
        return imageId;
    }
}
