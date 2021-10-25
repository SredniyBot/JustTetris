package ru.byte_value.justtetris;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Count {

    private static int number=0;

    public static void win(){
        number++;
    }

    public static void draw(Paint paint, Canvas canvas){
        paint.setTextSize(GameView.unitW*2);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setARGB(150,88,107,117);
        canvas.drawText(String.valueOf(number),(int)GameView.unitW*5,(int)GameView.unitW*4,paint);
        paint.setAlpha(255);
    }

    public static int getNumber() {
        return number;
    }
}
