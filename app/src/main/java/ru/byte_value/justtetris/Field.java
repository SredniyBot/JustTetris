package ru.byte_value.justtetris;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Vibrator;
import ru.byte_value.justtetris.figures.Figure;

public class Field {

    private int fallTime=0;
    private final int fallTimeTotal =1000;

    private static final int x_size=10;
    private static final int y_size=20;
    private static final double size=1;
    private static Map map;
    private boolean stop=false;
    private Context context;
    private Vibrator vibrator;
    Pause pause;
    private Figure figure;
    private Sprite full;
    private Sprite empty;

    Field(Context context){
        this.context=context;
        vibrator =(Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        map = new Map();
        pause=new Pause(context);
        figure =new Figure(context);
        figure.newFigure();
        full=new Sprite(context);
        full.addFrame(R.drawable.full8,0);//full
        empty=new Sprite(context);
        empty.addFrame(R.drawable.empty3,0);//empty
    }

    public void update(int ms){
        if(!isStopped()) {
            fallTime += ms;
            if (fallTime >= fallTimeTotal) {
                fallTime -= fallTimeTotal;
                down();
            }
        }
    }

    public boolean down(){
        if(figure.checkBottomCollision(map.getCollisionMap())){
            map.connection(figure.getFigure(), figure.getX(), figure.getY());
            map.checkAndUpdate();
            figure.newFigure();
            Count.win();
            checkEndOfGame();
            return true;
        }
        figure.fall();
        fallTime =0;
        return false;
    }


    public void draw(Paint paint, Canvas canvas){
        for(int i=0;i<x_size;i++){
            for(int j=0;j<y_size;j++){
                if(map.getMap()[j][i]){
                    canvas.drawBitmap(
                            full.getCurrentBitmap(),
                            (int)size*i*GameView.unitW,
                            (int)size*j*GameView.unitH,
                            paint);
                }else{
                    canvas.drawBitmap(empty.getCurrentBitmap(),
                            (int)size*i*GameView.unitW,
                            (int)size*j*GameView.unitH,
                            paint);
                }

            }
        }
        figure.draw(paint,canvas);
        Count.draw(paint,canvas);
        pause.draw(paint,canvas);
    }

    public boolean moveX(int dx) {
        if(!isStopped()) {
            if (dx >= GameView.unitW) {
                vibrator.vibrate(20);
                if (!figure.checkLeftCollision(map.getCollisionMap()))
                    figure.left();
                return true;
            } else if (dx <= -GameView.unitW) {
                vibrator.vibrate(20);
                if (!figure.checkRightCollision(map.getCollisionMap()))
                    figure.right();
                return true;
            }
        }
        return false;
    }

    public boolean moveY(int dy) {
        if(!isStopped()) {
            if (dy >= GameView.unitH) {
                return true;
            } else if (dy <= -GameView.unitW) {
                vibrator.vibrate(30);
                down();
                return true;
            }
        }
        return false;
    }

    public void megaMoveY(){
        if(!isStopped()) {
            vibrator.vibrate(40);
            while (!down()) ;
            down();
        }
    }

    public void rotate() {
        if(!isStopped()) {
            if (!figure.checkRotateCollision(map.getCollisionMap())) {
                figure.rotate();
                vibrator.vibrate(30);
            }
        }
    }

    public void checkEndOfGame(){
        if(!map.canInjectNewFigure()) {
            stop=true;
            Intent intent = new Intent(context, ResultActivity.class);
            intent.putExtra("count", Count.getNumber());
            context.startActivity(intent);
        }
    }


    private boolean isStopped(){
        return pause.isPaused()&&stop;
    }

}
