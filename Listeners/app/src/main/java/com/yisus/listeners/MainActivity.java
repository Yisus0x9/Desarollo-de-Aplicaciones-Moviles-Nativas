package com.yisus.listeners;

import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/*
El método para añadir un evento a un boton se llama setOnClickListener, el cual recibe  ub objeto de tipo OnClickListener y al ejecutarse este métodoo inmediatamente llama
al método onClick para ejecutar la lógica correspondiente, para este ejemplo se hizo lo siguiente:
- Se implemento la interfaz OnClickListener para sobreescribir el método onClick
- Se sobreescribio el método onClick
- Como nuestro activity es un OnclickListener, en el boton se pasa como argumento this

Otra forma de ejecutar una lógica con un boton es desde el XML, anque es la menos usada:
- Primero se necesita un método que no retorne nada y en el que se escriba la lógica a ejecutar cuand se presione el botón
- En el XMl en el Button se añade el prop android:onClick="Nombre del método"
Es el menos usual ya que regularmente se necestia que el método retorne algo
 */

public class MainActivity extends AppCompatActivity implements OnClickListener{
    private TextView jTextView;
    private EditText jEditText;
    private Button jButton;

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
        jEditText=findViewById(R.id.xEditText);
        jButton=findViewById(R.id.xButton);
        jButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
            jEditText.setText("HOLA ESCOM");
    }
}