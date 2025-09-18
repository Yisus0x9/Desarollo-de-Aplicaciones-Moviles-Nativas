package com.yisus.drawable;

import android.os.Bundle;

import android.widget.Button;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button jButtonSearch,jButtonConnect,jButtonLed1On,jButtonLed1Off,jButtonLed2On,jButtonLed2Off;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initButtons();
        addListeners();
    }

    private void initButtons(){
        jButtonSearch=findViewById(R.id.xButtonSearch);
        jButtonConnect=findViewById(R.id.xButtonConnect);
        jButtonLed1On=findViewById(R.id.xButtonLed1On);
        jButtonLed1Off=findViewById(R.id.xButtonLed1Off);
        jButtonLed2On=findViewById(R.id.xButtonLed2On);
        jButtonLed2Off=findViewById(R.id.xButtonLed2Off);
    }


    private void addListeners(){
            jButtonLed1On.setOnClickListener(e->{
                Toast.makeText(this,"Se presiono el botón para encender el Led",Toast.LENGTH_LONG).show();
            });
    }
}