package ru.byte_value.justtetris.figures;

import android.content.Context;

public class I extends Figure {

    private static boolean[][] I =
            {{false, false, true, false},
                    {false, false, true, false},
                    {false, false, true, false},
                    {false, false, true, false}};
    private static boolean[][] I1 =
            {{false, false, false, false},
                    {false, false, false, false},
                    {true, true, true, true},
                    {false, false, false, false}};
    I(Context context){
        super(context);
        figure=I;
        figure0=I;
        figure1=I1;
        figure2=I;
        figure3=I1;
    }



}
