package com.yisus.app.moviles.dibujo_tactil;

import android.app.Activity;

import android.os.Bundle;



public class MainActivity extends Activity {
    Lienzo l;

    @Override
    public void onCreate(Bundle b){
        super.onCreate(b);
        l = new Lienzo(this);
        setContentView(l);
    }



}