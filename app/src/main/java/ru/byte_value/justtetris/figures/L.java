package ru.byte_value.justtetris.figures;

import android.content.Context;

public class L extends Figure {


    private static boolean[][] L =
            {{false, true, false, false},
                    {false, true, false, false},
                    {false, true, true, false},
                    {false, false, false, false}};
    private static boolean[][] L1 =
            {{false, false, false, false},
                    {false, true, true, true},
                    {false, true, false, false},
                    {false, false, false, false}};
    private static boolean[][] L2 =
            {{false, true, true, false},
                    {false, false, true, false},
                    {false, false, true, false},
                    {false, false, false, false}};
    private static boolean[][] L3 =
            {{false, false, false, false},
                    {false, false, false, true},
                    {false, true, true, true},
                    {false, false, false, false}};
    L(Context context){
        super(context);
        figure=L;
        figure0=L;
        figure1=L1;
        figure2=L2;
        figure3=L3;
    }
}
