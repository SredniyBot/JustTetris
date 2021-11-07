package ru.byte_value.justtetris;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;


public class SoundService extends Service {

    private static MediaPlayer music;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onCreate() {
        music=MediaPlayer.create(this, R.raw.nem);

    }

    public static void stop(){
        if (music.isPlaying())
        music.stop();
    }

    @Override
    public void onDestroy() {
        music.stop();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        music.start();
    }
}
