package com.yisus.app.moviles.ejemplo_examen_grafico;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
    private int size,color,repeticiones;
    private Lienzo lienzo;
    Bundle bdl;
    public void onCreate(Bundle b){
        super.onCreate(b);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.secondActivity), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        bdl = getIntent().getExtras();
        size= Integer.parseInt(bdl.getString("lado_cuadrado"));
        color= Integer.parseInt(bdl.getString("color"));
        repeticiones= Integer.parseInt(bdl.getString("repeticiones"));
        ConstraintLayout cl= findViewById(R.id.secondActivity);
        lienzo= new Lienzo(this,size,color,repeticiones);
        cl.addView(lienzo);
    }
}
