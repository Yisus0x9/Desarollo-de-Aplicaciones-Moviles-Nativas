package com.yisus.app.moviles.spiner;

import android.app.Activity;
import android.os.Bundle;

import android.view.View;
import android.widget.*;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends Activity {
    Spinner s;
    EditText editText;
    Button button;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> arrayList;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.editTextText);
        button=findViewById(R.id.button);
        s =  findViewById(R.id.xsp);
        findViewById(R.id.xsp);
        arrayList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(arrayAdapter);

        button.setOnClickListener(e->{
            String nombre = editText.getText().toString().trim();
            if (nombre.isEmpty()) {
                Toast.makeText(MainActivity.this, "El campo no puede estar vacío",
                        Toast.LENGTH_LONG).show();
            } else {
                arrayList.add(nombre);
                arrayAdapter.notifyDataSetChanged();
                editText.setText("");
                Toast.makeText(MainActivity.this, "Agregado: " + nombre,
                        Toast.LENGTH_SHORT).show();
            }

        });
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> av, View v, int i, long l) {
                Toast.makeText(MainActivity.this, s.getSelectedItem().toString(),
                        Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // No hacer nada cuando no se selecciona nada
            }
        });
    }
}