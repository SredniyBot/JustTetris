package ru.byte_value.justtetris.figures;

import android.content.Context;

public class J extends Figure {

    private static boolean[][] J =
            {{false, false, true, false},
                    {false, false, true, false},
                    {false, true, true, false},
                    {false, false, false, false}};
    private static boolean[][] J1 =
            {{false, false, false, false},
                    {false, true, false, false},
                    {false, true, true, true},
                    {false, false, false, false}};
    private static boolean[][] J2 =
            {{false, true, true, false},
                    {false, true, false, false},
                    {false, true, false, false},
                    {false, false, false, false}};
    private static boolean[][] J3 =
            {{false, false, false, false},
                    {true, true, true, false},
                    {false, false, true, false},
                    {false, false, false, false}};

    J(Context context){
        super(context);
        figure=J;
        figure0=J;
        figure1=J1;
        figure2=J2;
        figure3=J3;
    }
}
