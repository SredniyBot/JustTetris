package ru.byte_value.justtetris;

import android.view.MotionEvent;
import android.view.View;

import java.util.Calendar;

public class Sensor {
    private static long longTouchTime;
    private static long longTouchTimeMax=100;
    private static double x,y,prevX,prevY,dx,dy;
    private static int down=0;
    boolean move =false;
    ru.byte_value.justtetris.Field field;
    Sensor(ru.byte_value.justtetris.Field field){
        this.field = field;
    }

    public void checkAction(View v, MotionEvent event){
        if(!field.pause.isPaused()){
        x=event.getX();
        y=event.getY();

        if((event.getAction()==MotionEvent.ACTION_DOWN||event.getAction()==MotionEvent.ACTION_UP||event.getAction()==MotionEvent.ACTION_CANCEL)) {
            prevX=x;
            prevY=y;
        }
        if((event.getAction()==MotionEvent.ACTION_DOWN)) {
            longTouchTime= Calendar.getInstance().getTimeInMillis();
        }

        if(event.getAction()==MotionEvent.ACTION_MOVE) {
            dy-=y-prevY;
            prevY=y;
            dx-=x-prevX;
            prevX=x;

            if(field.moveY((int)dy)){
                dy=0;
                move=true;
                down++;
                if(Calendar.getInstance().getTimeInMillis()-longTouchTime<longTouchTimeMax*1.5&&down>=4){
                    field.megaMoveY();
                    down=0;
                }
            }
            if(down!=0){
                dx=dx/1.3;
            }

            if(field.moveX((int)dx)){
                dx=0;
                move=true;
            }
        }
        if(event.getAction()==MotionEvent.ACTION_UP||event.getAction()==MotionEvent.ACTION_CANCEL) {
            if(Calendar.getInstance().getTimeInMillis()-longTouchTime<longTouchTimeMax&&!move){
                field.rotate();
            }
            move=false;
            down=0;
        }
    }}


}
