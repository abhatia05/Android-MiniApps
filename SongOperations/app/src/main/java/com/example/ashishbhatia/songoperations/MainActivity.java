package com.example.ashishbhatia.songoperations;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button pl;
    private Button pu;
    private int st;
    private MediaPlayer mp;
    private SeekBar sb;
    public static int oneTimeOnly = 0;
    private Handler myh = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Match two buttons
        pl = (Button) findViewById(R.id.playbtn);
        pu = (Button) findViewById(R.id.pausebtn);

        // Match SeekBar
        sb = (SeekBar) findViewById(R.id.status);
        sb.setClickable(false);
        sb.setProgress(0);
        // Create Media Player object using create
        mp = MediaPlayer.create(this,R.raw.kibnuduniyada);

       int ft = mp.getDuration();
        int st = mp.getCurrentPosition();
        if (oneTimeOnly == 0) {
            sb.setMax((int) ft);
            oneTimeOnly = 1;
        }
        // Incrementing SeekBar using a new runnable thread.
        myh.postDelayed(UpdateSongTime,100);

    }

    public void playButton(View view) {

        // Song Play
        Toast.makeText(getApplicationContext(), "Playing sound",Toast.LENGTH_SHORT).show();
        mp.start();


    }

    public void pauseButton(View view) {
        // Song Pause
        Toast.makeText(getApplicationContext(), "Paused",Toast.LENGTH_SHORT).show();
        mp.pause();

    }



    private  Runnable UpdateSongTime = new Runnable() {
        @Override
        public void run() {
            st = mp.getCurrentPosition();

            sb.setProgress(st);
            myh.postDelayed(this,100);

        }
    };
}
