package ru.byte_value.justtetris;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Vibrator;

import androidx.annotation.Nullable;

public class VibrateService extends Service {
    private Vibrator vibrator;
    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        vibrator= (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void vibrate(int ms){
        vibrator.vibrate(ms);
    }
}
