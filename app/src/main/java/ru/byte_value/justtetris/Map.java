package ru.byte_value.justtetris;

public class Map {

    private  boolean[][] map;
    private boolean[][] collisionMap;

    private int x_size=10;
    private int y_size=20;
    private int colAddX_size=4;
    private int collAddY_size=4;



    public Map(){
        map= new boolean[y_size][x_size];
        collisionMap= new boolean[y_size+colAddX_size][x_size+collAddY_size];

        for(int i=y_size;i<y_size+collAddY_size;i++){
            for (int j=0;j<x_size+colAddX_size;j++){
                collisionMap[i][j]=true;
            }
        }
        for(int i=0;i<colAddX_size/2;i++){
            for (int j=0;j<y_size+collAddY_size;j++){
                collisionMap[j][i]=true;
            }
        }
        for(int i=x_size+colAddX_size/2;i<x_size+colAddX_size;i++){
            for (int j=0;j<y_size+collAddY_size;j++){
                collisionMap[j][i]=true;
            }
        }
    }

    Map(int x_size,int y_size){
        this.x_size=x_size;
        this.y_size=y_size;
        map= new boolean[y_size][x_size];
        collisionMap= new boolean[y_size+colAddX_size][x_size+collAddY_size];

        for(int i=y_size;i<y_size+collAddY_size;i++){
            for (int j=0;j<x_size+colAddX_size;j++){
                collisionMap[i][j]=true;
            }
        }
        for(int i=0;i<colAddX_size/2;i++){
            for (int j=0;j<y_size+collAddY_size;j++){
                collisionMap[j][i]=true;
            }
        }
        for(int i=x_size+colAddX_size/2;i<x_size+colAddX_size;i++){
            for (int j=0;j<y_size+collAddY_size;j++){
                collisionMap[j][i]=true;
            }
        }
    }

    public boolean checkAndUpdate(){
        boolean combo=false;
        for(int i=y_size-1;i>=0;i--){
            int h=0;
            for(int j=0;j<x_size;j++){
                if(map[i][j]){
                    h++;
                }
            }
            if(h==x_size){
                for(int i1=i;i1>0;i1--){
                    for(int j=0;j<x_size;j++){
                        map[i1][j]=map[i1-1][j];
                        collisionMap[i1][j+2]=collisionMap[i1-1][j+2];
                    }
                }
                for(int j=0;j<x_size;j++){
                    map[0][j]=false;
                    collisionMap[0][j+2]=false;
                }
                i++;
                combo=true;
            }
        }
        return combo;
    }

    public void connection(boolean[][] figure,int x,int y){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(figure[i][j]){
                    map[i+y][j+x]=true;
                    collisionMap[i+y][j+x+2]=true;
                }
            }
        }
    }
    public boolean[][] getCollisionMap(){
        return collisionMap;
    }

    public boolean[][] getMap() {
        return map;
    }

    public boolean canInjectNewFigure(){
        for(int i=0;i<4;i++)
            for(int j=0;j<4;j++)
                if(map[j][x_size/2-2+i])return false;
        return true;
    }
}
