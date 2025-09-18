package com.yisus.app.moviles.botones;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends Activity {
    FloatingActionButton jfab;

    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        jfab = (FloatingActionButton) findViewById(R.id.xfab);
        jfab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Soy un botón Flotante!",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}