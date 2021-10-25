package ru.byte_value.justtetris;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.util.Calendar;

public class GameView extends SurfaceView implements Runnable, View.OnTouchListener {

    public static int maxX = 10; // размер по горизонтали
    public static int maxY = 20; // размер по вертикали
    public static float unitW = 0; // пикселей в юните по горизонтали
    public static float unitH = 0; // пикселей в юните по вертикали

    Sensor sensor;
    ru.byte_value.justtetris.Field field;
    private static long time1;


    private boolean firstTime= true;
    private boolean gameRunning;
    private Thread gameThread;
    private Paint paint;
    private Canvas canvas;
    private SurfaceHolder surfaceHolder;

    public GameView(Context context){
        super(context);
        this.setOnTouchListener(this);



        context.startService(new Intent(context, ru.byte_value.justtetris.SoundService.class));
        surfaceHolder=getHolder();
        paint= new Paint();
        gameRunning=true;
        gameThread= new Thread(this);
        gameThread.start();
    }




    @Override
    public void run() {
        while (gameRunning){
            if(!firstTime){
                long time2= Calendar.getInstance().getTimeInMillis();
                Long ms=time2-time1;
                time1=time2;
                update(ms.intValue());
            }
            draw();
        }
    }


    public void update(int ms){
        field.update(ms);
    }


    public void draw() {
        if(surfaceHolder.getSurface().isValid()){
            if(firstTime){
                firstTime=false;
                unitH= surfaceHolder.getSurfaceFrame().height()/maxY;
                unitW=unitH;
//                Float r=surfaceHolder.getSurfaceFrame().width()/unitW;
//                maxY=r.intValue();

                time1 = Calendar.getInstance().getTimeInMillis();
                field =new ru.byte_value.justtetris.Field(getContext());
                sensor =new Sensor(field);
            }
            canvas=surfaceHolder.lockCanvas();
            field.draw(paint,canvas);
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }




    @Override
    public boolean onTouch(View v, MotionEvent event) {

        field.pause.checkAction(v,event);
        sensor.checkAction(v,event);

        return true;
    }
}
