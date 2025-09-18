package com.yisus.app.moviles.clase_intent;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.*;
import android.content.Intent;
import android.widget.*;

/*
La clase Inent se usa para invocar activities, a veces es necesarios pasar parametros
de un activity al que se va a lanzar, para ello usamos el método  Intent putExtras(android.os.Bundle extras).

La clase Bundle en Android es una estructura de datos clave-valor que sirve
para transportar y almacenar información entre diferentes componentes de una aplicación.
 Es fundamental para la comunicación entre Activities, Fragments y otros componentes ya que se encarga de transportar y/o recibir recursos.
 */

public class MainActivity extends Activity{
    EditText editTextDivisor;
    EditText editTextDividendo;
    Button jbn;
    Bundle bdl;
    Intent itn;

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        editTextDividendo =findViewById(R.id.editTextTextA);
        editTextDivisor =findViewById(R.id.editTextTextB);
        jbn = findViewById(R.id.buttonSolve);
        jbn.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                itn = new Intent(MainActivity.this, SecondActivity.class);
                bdl = new Bundle();
                bdl.putString("divisor", editTextDivisor.getText().toString());
                bdl.putString("dividendo", editTextDividendo.getText().toString());
                itn.putExtras(bdl);
                startActivity(itn);
            }
        });
    }
}