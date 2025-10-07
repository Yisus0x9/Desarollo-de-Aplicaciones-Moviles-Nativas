package com.yisus.app.moviles.ejemplo_examen_grafico;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Lienzo extends View {
    private Paint pn;
    private int size,color,repeticiones;

    public Lienzo(Context context) {
        super(context);

    }
    public Lienzo(Context context, int size, int color, int repeticiones) {
        super(context);
        this.size = size;
        this.color = color;
        this.repeticiones = repeticiones;
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        pn=new Paint();
        canvas.drawRGB(50,50,50);
        pn.setStrokeWidth(4);
        drawSquareAndCircle(pn,canvas,getWidth()/2, getHeight()/2,size,color,0);
    }

    private void drawSquareAndCircle(Paint pn,Canvas c,int x,int y,int sizeSquare, int colorCircle,int veces){
        if(veces<repeticiones) {
            pn.setColor(Color.BLUE);
            pn.setStyle(Paint.Style.STROKE);
            c.drawRect(new Rect(x - (sizeSquare / 2), y - (sizeSquare /2), x + (sizeSquare / 2), y + (sizeSquare / 2)), pn);
            pn.setColor(colorCircle);
            c.drawCircle(x, y, sizeSquare/2, pn);
            drawSquareAndCircle(pn, c, x, y, (int) (sizeSquare / Math.sqrt(2)), colorCircle, veces + 1);
        }
    }
}
