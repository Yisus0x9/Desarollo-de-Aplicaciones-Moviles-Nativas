package com.yisus.app.moviles.move_image;

import android.annotation.SuppressLint;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView iv;
    private View root;

    // Estado
    private float x, y;           // posición actual
    private float vx = 500f;      // px/s
    private float vy = 380f;      // px/s

    // Dimensiones válidas
    private int width, height;        // contenedor
    private int widthImage, heightImage; // imagen

    private long lastMs;
    private boolean running = false;

    // Bucle de animación
    private final Runnable ticker = new Runnable() {
        @Override public void run() {
            if (!running) return;

            long now = SystemClock.uptimeMillis();
            float dt = (now - lastMs) / 1000f; // segundos
            lastMs = now;

            // Próxima posición “libre”
            PointF next = getNextPosition(x, y, vx * dt, vy * dt);

            // ¿Colisión con los bordes?
            if (existCollision(next.x, next.y)) {
                // corrige posición al borde
                next = getNextPositionIfCollision(x, y, vx * dt, vy * dt);

                // invierte velocidades según el/los ejes que pegaron
                if (next.x <= 0 || next.x + widthImage >= width)  vx = -vx;
                if (next.y <= 0 || next.y + heightImage >= height) vy = -vy;
            }

            // aplica nueva posición
            x = next.x;
            y = next.y;
            iv.setTranslationX(x);
            iv.setTranslationY(y);

            // siguiente frame
            root.postOnAnimation(this);
        }
    };

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        iv   = findViewById(R.id.xiv);
        root = findViewById(R.id.activity_main);

        // Espera a que el layout tenga tamaño válido
        root.post(() -> {
            width  = root.getWidth();
            height = root.getHeight();
            widthImage  = iv.getWidth();
            heightImage = iv.getHeight();

            // posición inicial (traducciones actuales)
            x = iv.getTranslationX();
            y = iv.getTranslationY();

            start();
        });

        // (Opcional) tocar para pausar/reanudar
        root.setOnClickListener(v -> { if (running) stop(); else start(); });

        // (Opcional) arrastrar con el dedo y soltar: sigue rebotando
        iv.setOnTouchListener((v, me) -> {
            switch (me.getActionMasked()) {
                case MotionEvent.ACTION_DOWN:
                case MotionEvent.ACTION_MOVE:
                    // centra el toque en la imagen
                    x = me.getX() + v.getX() - widthImage / 2f;
                    y = me.getY() + v.getY() - heightImage / 2f;
                    clamp(); // evita salirse
                    iv.setTranslationX(x);
                    iv.setTranslationY(y);
                    return true;
            }
            return false;
        });
    }

    private void start() {
        if (running) return;
        running = true;
        lastMs = SystemClock.uptimeMillis();
        root.postOnAnimation(ticker);
    }

    private void stop() { running = false; }

    // ---------- Tus utilidades, corregidas ----------

    private boolean existCollision(float x, float y){
        return x < 0 || y < 0 || x + widthImage > width || y + heightImage > height;
    }

    private PointF getNextPositionIfCollision(float x, float y, float dx, float dy) {
        float newX = x + dx;
        float newY = y + dy;

        if (newX < 0) newX = 0;
        else if (newX + widthImage > width) newX = width - widthImage;

        if (newY < 0) newY = 0;
        else if (newY + heightImage > height) newY = height - heightImage;

        return new PointF(newX, newY);
    }

    private PointF getNextPosition(float x, float y, float dx, float dy) {
        return new PointF(x + dx, y + dy);
    }

    private void clamp() {
        if (x < 0) x = 0;
        if (y < 0) y = 0;
        if (x + widthImage > width) x = width - widthImage;
        if (y + heightImage > height) y = height - heightImage;
    }

    @Override protected void onPause() { super.onPause(); stop(); }
    @Override protected void onResume() { super.onResume(); if (width > 0) start(); }
}
