package ru.byte_value.justtetris.figures;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.Random;

import ru.byte_value.justtetris.GameView;
import ru.byte_value.justtetris.R;
import ru.byte_value.justtetris.Sprite;

public class Figure {

    boolean[][] figure;
    boolean[][] figure0;
    boolean[][] figure1;
    boolean[][] figure2;
    boolean[][] figure3;

    private Sprite s;

    private int x=3;
    private int y=0;

    private Context context;
    private int mode =0;

    Figure f;

    public Figure(Context context) {
        this.context=context;
        s=new Sprite(context);
        s.addFrame(R.drawable.full8,0);//full
    }

    void  randomFigure() {
    switch (new Random().nextInt(7)+1) {
        case 1:
            f=new I(context);
            break;
        case 2:
            f=new T(context);
            break;
        case 3:
            f=new J(context);
            break;
        case 4:
            f=new L(context);
            break;
        case 5:
            f=new S(context);
            break;
        case 6:
            f=new O(context);
            break;
        case 7:
            f=new Z(context);
            break;
    }
    }

    public void newFigure(){
        randomFigure();
        y=0;
        x=3;

    }


    public void draw(Paint paint, Canvas canvas) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (f.figure[j][i]) {
                    canvas.drawBitmap(s.getCurrentBitmap(), (int) (x+i) * GameView.unitW, (int)   (y+j) * GameView.unitH, paint);
                }
            }
        }
    }


    public void fall(){
        y++;
    }

    public void left(){
        x--;
    }

    public void right(){
        x++;
    }


    public boolean checkBottomCollision(boolean[][] b){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(f.figure[i][j]&&b[i+y+1][j+x+2]){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkLeftCollision(boolean[][] b){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(f.figure[i][j]&&b[i+y][j+x-1+2]){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkRightCollision(boolean[][] b){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(f.figure[i][j]&&b[i+y][j+x+1+2]){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkRotateCollision(boolean[][] b){
        boolean[][] a= f.figure;
        switch (mode){
            case 0:
                a=f.figure1;
                break;
            case 1:
                a=f.figure2;
                break;
            case 2:
                a=f.figure3;
                break;
            case 3:
                a=f.figure0;
                break;
        }
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(a[i][j]&&b[i+y][j+x+2]){
                    return true;
                }
            }
        }
        return false;
    }

    public void rotate(){

        f.mode++;
        mode++;

        if(f.mode >3 ||mode>3){
            mode=0;
            f.mode =0;
        }
        switch (mode){
            case 0:
                f.figure=f.figure0;
                figure=figure0;
                break;
            case 1:
                f.figure=f.figure1;
                figure=figure1;
                break;
            case 2:
                f.figure=f.figure2;
                figure=figure2;
                break;
            case 3:
                f.figure=f.figure3;
                figure=figure3;
                break;
        }
    }

    public boolean[][] getFigure() {
        return f.figure;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}



