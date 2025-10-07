package com.yisus.app.moviles.ejemplo_examen_grafico;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.*;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText tamanoCuadrado,repeticiones;
    private Spinner colores;
    private Button draw;
    private Bundle dto;
    private Intent intent;
    private Display display;
    private DisplayMetrics metrics;
    private int size,color,repet;



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
        display = getWindowManager().getDefaultDisplay();
        metrics= new DisplayMetrics();
        display.getMetrics(metrics);
        tamanoCuadrado= findViewById(R.id.editTextTextSize);
        repeticiones=findViewById(R.id.editTextNumberTimes);
        colores=findViewById(R.id.spinnerColors);
        draw=findViewById(R.id.buttonDraw);
        tamanoCuadrado.setHint(String.format("Ingresa un valor entre %s y %s",10,metrics.widthPixels));
        addActionListener();

    }


    private void addActionListener(){
        draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initValues();
                if(isVerified(size,color,repet)){
                    dto= new Bundle();
                    dto.putString("lado_cuadrado", String.valueOf(size));
                    dto.putString("color", String.valueOf(color));
                    dto.putString("repeticiones", String.valueOf(repet));
                    intent= new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtras(dto);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this,"Verifica los datos de entrada",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void initValues(){
        size= Integer.parseInt(tamanoCuadrado.getText().toString());
        color= getColor(colores.getSelectedItem().toString());
        Toast.makeText(this,"Color : " + color,Toast.LENGTH_LONG).show();

        repet= Integer.parseInt(repeticiones.getText().toString());
    }

    private boolean isVerified(int size,int color, int repeticiones){
        return (size>10 && size<metrics.widthPixels) && (repeticiones>0 && repeticiones<100);
    }


    private int getColor(String color){

        switch (color){
            case "Rojo":
                return Color.RED;
            case "Azul":
                return Color.BLUE;
            case "Amarillo":
                return Color.YELLOW;
            case "Naranja":
                return Color.rgb(230,50,200);
            case "Verde":
                return Color.GREEN;
            default:
                return Color.BLACK;
        }
    }


}