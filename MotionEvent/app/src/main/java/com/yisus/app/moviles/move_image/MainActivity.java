package com.yisus.app.moviles.move_image;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ImageView iv;
    private List<PointF> move = new ArrayList<>();
    private boolean isRecording = true;
    private ValueAnimator animator;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        iv = findViewById(R.id.xiv);

        iv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent me) {
                if (!isRecording) return false;

                switch (me.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        move.clear();
                        move.add(new PointF(v.getX(), v.getY()));
                        break;

                    case MotionEvent.ACTION_MOVE:
                        float newX = me.getRawX() - v.getWidth() / 2f;
                        float newY = me.getRawY() - v.getHeight() / 2f;
                        v.setX(newX);
                        v.setY(newY);
                        move.add(new PointF(newX, newY));
                        break;

                    case MotionEvent.ACTION_UP:
                        if (move.size() > 1) {
                            reproducirTrayectoriaFluida(v);
                        }
                        break;

                    default:
                        return false;
                }
                return true;
            }
        });
    }

    private void reproducirTrayectoriaFluida(View v) {
        isRecording = false;
        PointF inicio = move.get(0);
        v.setX(inicio.x);
        v.setY(inicio.y);

        v.postDelayed(new Runnable() {
            @Override
            public void run() {
                float longitudTotal = calcularLongitudTotal();
                long duracionTotal = (long) (longitudTotal * 3); // Ajusta velocidad aquí

                animator = ValueAnimator.ofFloat(0, 1);
                animator.setDuration(duracionTotal);
                animator.setInterpolator(new LinearInterpolator());

                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float progreso = animation.getAnimatedFraction();
                        PointF punto = obtenerPuntoEnTrayectoria(progreso);
                        v.setX(punto.x);
                        v.setY(punto.y);
                    }
                });

                animator.addListener(new android.animation.AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(android.animation.Animator animation) {
                        isRecording = true;
                    }
                });

                animator.start();
            }
        }, 500);
    }

    private float calcularLongitudTotal() {
        float longitud = 0;
        for (int i = 1; i < move.size(); i++) {
            PointF p1 = move.get(i - 1);
            PointF p2 = move.get(i);
            float dx = p2.x - p1.x;
            float dy = p2.y - p1.y;
            longitud += Math.sqrt(dx * dx + dy * dy);
        }
        return longitud;
    }

    private PointF obtenerPuntoEnTrayectoria(float progreso) {
        float longitudTotal = calcularLongitudTotal();
        float longitudObjetivo = longitudTotal * progreso;
        float longitudAcumulada = 0;

        for (int i = 1; i < move.size(); i++) {
            PointF p1 = move.get(i - 1);
            PointF p2 = move.get(i);

            float dx = p2.x - p1.x;
            float dy = p2.y - p1.y;
            float segmento = (float) Math.sqrt(dx * dx + dy * dy);

            if (longitudAcumulada + segmento >= longitudObjetivo) {
                // El punto está en este segmento
                float resto = longitudObjetivo - longitudAcumulada;
                float t = resto / segmento;

                return new PointF(
                        p1.x + dx * t,
                        p1.y + dy * t
                );
            }

            longitudAcumulada += segmento;
        }

        // Si llegamos aquí, devolver el último punto
        return move.get(move.size() - 1);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (animator != null && animator.isRunning()) {
            animator.cancel();
        }
    }
}