package ru.byte_value.justtetris.figures;

import android.content.Context;

public class Z extends Figure {
    private static boolean[][] Z =
            {{false, true, true, false},
                    {false, false, true, true},
                    {false, false, false, false},
                    {false, false, false, false}};
    private static boolean[][] Z1 =
            {{false, false, true, false},
                    {false, true, true, false},
                    {false, true, false, false},
                    {false, false, false, false}};

    Z(Context context){
        super(context);
        figure=Z;
        figure0=Z;
        figure1=Z1;
        figure2=Z;
        figure3=Z1;
    }
}
