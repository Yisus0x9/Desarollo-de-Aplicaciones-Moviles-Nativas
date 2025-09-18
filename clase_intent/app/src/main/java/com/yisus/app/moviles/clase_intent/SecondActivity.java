package com.yisus.app.moviles.clase_intent;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

public class SecondActivity extends Activity {
    EditText jet;
    Bundle bdl;

    @Override
    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_second);
        jet = findViewById(R.id.xet1);
        bdl = getIntent().getExtras();
        jet.append(dividir(bdl.getString("dividendo"),bdl.getString("divisor")));
    }


    @SuppressLint("DefaultLocale")
    private String dividir(String dividendo, String divisor){
        try {
            double dividen=Double.parseDouble(dividendo);
            double diviso=Double.parseDouble(divisor);
            return String.format("Cociente: 29%.6f",dividen/diviso);
        }catch (Exception e){
            return "Asegurate de ingresar los números correctos";
        }
    }

//    private String solveQuadratic(String A, String B, String C) {
//        try {
//            // Convertir strings a doubles para manejar decimales
//            double a = Double.parseDouble(A);
//            double b = Double.parseDouble(B);
//            double c = Double.parseDouble(C);
//
//            double discriminante = b * b - 4 * a * c;
//
//            if (discriminante < 0) {
//                return "No existen soluciones reales (discriminante negativo)";
//            } else if (discriminante == 0) {
//                double x = -b / (2 * a);
//                return String.format("Solución única: x = %.2f", x);
//            } else {
//                double sqrtDiscriminante = Math.sqrt(discriminante);
//                double x1 = (-b + sqrtDiscriminante) / (2 * a);
//                double x2 = (-b - sqrtDiscriminante) / (2 * a);
//                return String.format("Dos soluciones: x₁ = %.2f, x₂ = %.2f", x1, x2);
//            }
//
//        } catch (NumberFormatException e) {
//            return "Error: Los parámetros deben ser números válidos";
//        } catch (Exception e) {
//            return "Error al intentar resolver la ecuación cuadrática";
//        }
//    }
}