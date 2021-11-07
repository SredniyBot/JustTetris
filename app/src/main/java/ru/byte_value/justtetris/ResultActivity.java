package ru.byte_value.justtetris;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent=getIntent();
        int count= intent.getIntExtra("count",0);
        TextView view=findViewById(R.id.resultText);
        view.setText("Поздравляем, ваш счет составляет: "+count);

    }
}