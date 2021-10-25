package ru.byte_value.justtetris.figures;

import android.content.Context;

public class O extends Figure {
    private static boolean[][] O =
            {{false, true, true, false},
                    {false, true, true, false},
                    {false, false, false, false},
                    {false, false, false, false}};

   O(Context context){
        super(context);
       figure=O;
       figure0=O;
       figure1=O;
       figure2=O;
       figure3=O;
    }
}
