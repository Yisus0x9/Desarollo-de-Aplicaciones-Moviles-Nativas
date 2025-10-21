package com.yisus.app.moviles.graficos_3d;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class PerspectiveView extends View {
    private int centerX, centerY, maxX, maxY, minMaxXY;
    private Obj obj;
    private Paint paint;

    // CAMBIAR ESTA VARIABLE PARA ELEGIR LA FIGURA
    // Opciones: "CUBO", "PIRAMIDE", "CILINDRO", "ESFERA"
    private String figuraActual = "ESFERA";

    public PerspectiveView(Context context) {
        super(context);
        obj = new Obj();

        // Crear la figura según la variable
        switch (figuraActual) {
            case "CUBO":
                obj.crearCubo();
                break;
            case "PIRAMIDE":
                obj.crearPiramide(50);
                break;
            case "CILINDRO":
                obj.crearCilindro(50);
                break;
            case "ESFERA":
                obj.crearEsfera(50, 50);
                break;
        }

        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(3);
        paint.setAntiAlias(true);
        setBackgroundColor(Color.YELLOW);
    }

    private int iX(float x) {
        return Math.round(centerX + x);
    }

    private int iY(float y) {
        return Math.round(centerY - y);
    }

    private void line(Canvas canvas, int i, int j) {
        Point2D p = obj.vScr[i];
        Point2D q = obj.vScr[j];
        canvas.drawLine(iX(p.x), iY(p.y), iX(q.x), iY(q.y), paint);
    }

    private void dibujarCubo(Canvas canvas) {
        // Aristas horizontales inferiores
        line(canvas, 0, 1);
        line(canvas, 1, 2);
        line(canvas, 2, 3);
        line(canvas, 3, 0);

        // Aristas horizontales superiores
        line(canvas, 4, 5);
        line(canvas, 5, 6);
        line(canvas, 6, 7);
        line(canvas, 7, 4);

        // Aristas verticales
        line(canvas, 0, 4);
        line(canvas, 1, 5);
        line(canvas, 2, 6);
        line(canvas, 3, 7);
    }

    private void dibujarPiramide(Canvas canvas) {
        int numLados = obj.w.length - 1;

        // Base
        for (int i = 0; i < numLados - 1; i++) {
            line(canvas, i, i + 1);
        }
        line(canvas, numLados - 1, 0);

        // Aristas desde la base al vértice superior
        int verticeApice = numLados;
        for (int i = 0; i < numLados; i++) {
            line(canvas, i, verticeApice);
        }
    }

    private void dibujarCilindro(Canvas canvas) {
        int numLados = obj.w.length / 2;

        // Base inferior
        for (int i = 0; i < numLados - 1; i++) {
            line(canvas, i, i + 1);
        }
        line(canvas, numLados - 1, 0);

        // Base superior
        for (int i = numLados; i < obj.w.length - 1; i++) {
            line(canvas, i, i + 1);
        }
        line(canvas, obj.w.length - 1, numLados);

        // Aristas verticales
        for (int i = 0; i < numLados; i++) {
            line(canvas, i, i + numLados);
        }
    }

    private void dibujarEsfera(Canvas canvas) {
        int numMeridianos = obj.numMeridianos;
        int numParalelos = obj.numParalelos;

        // Meridianos (líneas verticales)
        for (int i = 0; i < numMeridianos; i++) {
            for (int j = 0; j < numParalelos; j++) {
                int idx = i * (numParalelos + 1) + j;
                int idxNext = i * (numParalelos + 1) + j + 1;
                line(canvas, idx, idxNext);
            }
        }

        // Paralelos (líneas horizontales)
        for (int j = 0; j <= numParalelos; j++) {
            for (int i = 0; i < numMeridianos - 1; i++) {
                int idx = i * (numParalelos + 1) + j;
                int idxNext = (i + 1) * (numParalelos + 1) + j;
                line(canvas, idx, idxNext);
            }
            // Conectar el último con el primero
            int idx = (numMeridianos - 1) * (numParalelos + 1) + j;
            int idxFirst = j;
            line(canvas, idx, idxFirst);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        maxX = getWidth() - 1;
        maxY = getHeight() - 1;
        minMaxXY = Math.min(maxX, maxY);
        centerX = maxX / 2;
        centerY = maxY / 2;

        obj.d = obj.rho * minMaxXY / obj.objSize;
        obj.eyeAndScreen();

        switch (figuraActual) {
            case "CUBO":
                dibujarCubo(canvas);
                break;
            case "PIRAMIDE":
                dibujarPiramide(canvas);
                break;
            case "CILINDRO":
                dibujarCilindro(canvas);
                break;
            case "ESFERA":
                dibujarEsfera(canvas);
                break;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            float x = event.getX();
            float y = event.getY();

            obj.theta = (float) getWidth() / x;
            obj.phi = (float) getHeight() / y;
            obj.rho = (obj.phi / obj.theta) * getHeight();
            centerX = (int) x;
            centerY = (int) y;

            invalidate();
        }
        return true;
    }
}

