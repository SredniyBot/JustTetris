package ru.byte_value.justtetris.figures;

import android.content.Context;

public class T extends Figure {


    private static boolean[][] T =
            {{false, false, false, false},
                    {false, true, true, true},
                    {false, false, true, false},
                    {false, false, false, false}};
    private static boolean[][] T1 =
            {{false, false, true, false},
                    {false, true, true, false},
                    {false, false, true, false},
                    {false, false, false, false}};
    private static boolean[][] T2 =
            {{false, false, true, false},
                    {false, true, true, true},
                    {false, false, false, false},
                    {false, false, false, false}};
    private static boolean[][] T3 =
            {{false, false, true, false},
                    {false, false, true, true},
                    {false, false, true, false},
                    {false, false, false, false}};
    T(Context context){
        super(context);
        figure=T;
        figure0=T;
        figure1=T1;
        figure2=T2;
        figure3=T3;
    }
}
