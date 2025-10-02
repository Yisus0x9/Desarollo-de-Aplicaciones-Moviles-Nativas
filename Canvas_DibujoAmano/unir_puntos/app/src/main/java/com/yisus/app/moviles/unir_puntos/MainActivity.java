package com.yisus.app.moviles.unir_puntos;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    private PointF point1=new PointF(200,200);
    private PointF point2=new PointF(600,200);
    private PointF point3=new PointF(400,500);
    private int radioCirculo = 40;
    private int tolerancia = 60;

    private Lienzo l;
    private List<PointF> puntosUnidos = new ArrayList<>();
    private boolean dibujando = false;
    private PointF puntoInicial = null;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        ConstraintLayout cl = findViewById(R.id.xl1);
        l = new Lienzo(this);
        l.setOnTouchListener(this);
        cl.addView(l);
    }

    public boolean onTouch(View v, MotionEvent e) {
        int x = (int) e.getX();
        int y = (int) e.getY();

        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                PointF puntoTocado = obtenerPuntoTocado(x, y);
                if (puntoTocado != null) {
                    dibujando = true;
                    puntoInicial = puntoTocado;
                    puntosUnidos.clear();
                    puntosUnidos.add(puntoTocado);
                }
                break;

            case MotionEvent.ACTION_MOVE:
                if (dibujando) {
                    // Verificar si está tocando otro punto
                    PointF puntoActual = obtenerPuntoTocado(x, y);
                    if (puntoActual != null && !puntosUnidos.contains(puntoActual)) {
                        // Unió un nuevo punto
                        puntosUnidos.add(puntoActual);
                    }
                }
                break;

        }

        l.invalidate();
        return true;
    }

    private PointF obtenerPuntoTocado(int x, int y) {
        if (distancia(x, y, point1) <= tolerancia) {
            return point1;
        }
        if (distancia(x, y, point2) <= tolerancia) {
            return point2;
        }
        if (distancia(x, y, point3) <= tolerancia) {
            return point3;
        }
        return null; // No tocó ningún punto
    }

    private double distancia(int x1, int y1,PointF pointCompare) {
        int dx = (int) (pointCompare.x - x1);
        int dy = (int) (pointCompare.y - y1);
        return Math.sqrt(dx * dx + dy * dy);
    }


    private void reiniciar() {
        puntosUnidos.clear();
        dibujando = false;
        puntoInicial = null;
        l.invalidate();
    }

    private PointF obtenerPunto(int punto) {
        switch (punto) {
            case 0: return point1;
            case 1: return point2;
            case 2: return point3;
            default: return null;
        }
    }

    class Lienzo extends View {
        public Lienzo(Context c) {
            super(c);
        }

        protected void onDraw(Canvas c) {
            c.drawRGB(255, 255, 0);
            Paint p = new Paint();
            p.setARGB(255,255,0,0);
            p.setStrokeWidth(8);
            p.setStyle(Paint.Style.STROKE);
            p.setColor(Color.RED); // Negro
            c.drawCircle(point1.x, point1.y, radioCirculo, p);
            c.drawCircle(point2.x, point2.y, radioCirculo, p);
            c.drawCircle(point3.x, point3.y, radioCirculo, p);

            // Dibujar líneas rectas entre puntos unidos
            if (puntosUnidos.size() >= 2) {
                p.setColor(Color.BLACK); // Azul
                p.setStrokeWidth(16);
                p.setStyle(Paint.Style.STROKE);

                for (int i = 0; i < puntosUnidos.size() - 1; i++) {
                    PointF point1 = puntosUnidos.get(i);
                    PointF point2= puntosUnidos.get(i + 1);

                    if(point1!=null && point2!=null)
                        c.drawLine(point1.x, point1.y, point2.x, point2.y, p);
                }
            }


        }
    }
}