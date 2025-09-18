package com.yisus.first_app_01;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class MainActivity extends AppCompatActivity {
    private EditText eTNum;
    private Button bCalcular;
    private TextView tVResult;
    private int numero;
    private StringBuilder resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        Log.d("gg","d");
        addEvent();
        Log.d("gg","d");
        buildResult();
        Log.d("gg","d");
    }

    public void initComponents(){
        eTNum=findViewById(R.id.xet1);
        tVResult=findViewById(R.id.textV1);
        numero= Integer.parseInt(eTNum.getText().toString());
    }

    public void addEvent(){
        bCalcular=findViewById(R.id.xButtonCalcular);
        bCalcular.setOnClickListener(view -> {
            tVResult.setText(resultText.toString());
        });
    }

    public void buildResult(){
        resultText=new StringBuilder("Resultado: \n");
        resultText.append("El número es Maravilloso : ").append(esMaravilloso(numero));
        resultText.append("El número es fibonacci : ").append(esFibonacci(numero));
    }


    public String esMaravilloso(Integer num) {
        StringBuilder list=new StringBuilder(num);
        while(true){
            if(num==1)
                break;
            num=num%2==0?num/2:num+1;
            list.append("\n").append(num);
        }
        return list.toString();
    }



    public boolean esFibonacci(Integer num){
        return num==(num-1)+(num-2);
    }

    public boolean esPrimo(Integer num){
        boolean isPrimo=true;
        int divisor=2;
        double cociente=1000000;

        while (true){
            cociente=  (double) num /divisor;
            if(cociente==0 || cociente<divisor) {
                isPrimo=false;
                break;
            }
            divisor++;
        }
        return isPrimo;
    }

    public boolean esKaprekar(Integer num){
        String numAsc= Stream.of(String.valueOf(num).toCharArray()).toString();
        String numDesc=new StringBuilder(numAsc).reverse().toString();
        return false;
    }



}