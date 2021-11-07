package ru.byte_value.justtetris;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Vibrator v=(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(100);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GameView gameView = new GameView(this);

        LinearLayout gameLayout = findViewById(R.id.gameLayout);
        gameLayout.addView(gameView);

    }

}
