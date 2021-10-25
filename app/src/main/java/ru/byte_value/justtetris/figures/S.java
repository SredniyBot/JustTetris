package ru.byte_value.justtetris.figures;

import android.content.Context;

public class S extends Figure {

    private static boolean[][] S =
            {{false, false, true, true},
                    {false, true, true, false},
                    {false, false, false, false},
                    {false, false, false, false}};
    private static boolean[][] S1 =
            {{false, true, false, false},
                    {false, true, true, false},
                    {false, false, true, false},
                    {false, false, false, false}};

    S(Context context){
        super(context);
        figure=S;
        figure0=S;
        figure1=S1;
        figure2=S;
        figure3=S1;
    }
}
