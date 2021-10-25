package ru.byte_value.justtetris;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Sprite {

        private boolean active=true;
        private int[] bitmapId=new int[50];
        private Bitmap[] bitmaps=new Bitmap[50];
        private Context context;
        private int index=0;
        private int first=0;
        private int last=0;
        private int currentFrameTime=0;
        private int frameTime=100;

        double x,y;
        double w,h;
        boolean animate=true;
        public Sprite(Context context){
                this.context=context;
                w= ru.byte_value.justtetris.GameView.unitW;
                h= ru.byte_value.justtetris.GameView.unitH;
        }

        public void addFrame(int res,int index){
                //if(!(index<50&&index>=0)) return;
                if(index>last){
                        last=index;
                }
                bitmapId[index]=res;
                Bitmap cBitmap = BitmapFactory.decodeResource(context.getResources(), res);
                bitmaps[index]= Bitmap.createScaledBitmap(
                        cBitmap, (int)w, (int)h, false);
                cBitmap.recycle();
        }

        public void nextFrame(){
                if(animate){
                        index++;
                        if(index>last)index=first;
                }
        }

        public void update(int ms){
                if(!active)return;
                currentFrameTime+=ms;
                if(currentFrameTime>=frameTime){
                        nextFrame();
                        currentFrameTime-=frameTime;
                }
        }

        public void draw(Paint paint, Canvas canvas){
                if(!active)return;
                canvas.drawBitmap(bitmaps[index], (int) x, (int)   y, paint);
        }

        public Bitmap getCurrentBitmap(){
                return bitmaps[index];
        }

}
