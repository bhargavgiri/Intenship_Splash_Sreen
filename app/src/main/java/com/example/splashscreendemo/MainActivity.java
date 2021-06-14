package com.example.splashscreendemo;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        mediaPlayer=MediaPlayer.create(this,R.raw.splash2);
        mediaPlayer.start();

        Thread t=new Thread()
        {
            public void run()
            {
                super.run();
                try {
                    sleep(5000);
                    Intent i=new Intent(MainActivity.this,MainActivity2.class);
                    startActivity(i);
                    finish();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.release();
        finish();
    }
}
