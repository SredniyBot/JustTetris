package ru.byte_value.justtetris;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;


public class Pause {
    Sprite s;
    private boolean pause = false;
    Context context;
    Pause(Context context){
        this.context=context;
        s=new Sprite(context);
        s.addFrame(R.drawable.pause2,0);
    }
    public void draw( Paint paint,Canvas canvas){
        s.draw(paint,canvas);
    }

    public boolean isPaused() {
        return pause;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
        Intent intent = new Intent();
        intent.setClass(context, ru.byte_value.justtetris.ActivityMenu.class);
        context.startActivity(intent);
    }

    public void checkAction(View v, MotionEvent event){
        if(pause){
            pause=false;
        }else if(event.getAction()==MotionEvent.ACTION_UP||event.getAction()==MotionEvent.ACTION_CANCEL) {
            if (event.getX() <= GameView.unitW && event.getY() <= GameView.unitH && event.getX() >= 0 && event.getY() >= 0) {
                setPause(!pause);
            }
        }
    }
}
