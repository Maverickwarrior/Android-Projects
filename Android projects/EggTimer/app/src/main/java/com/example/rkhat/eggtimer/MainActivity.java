package com.example.rkhat.eggtimer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;


import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    SeekBar eggTimerSeekBar;
    TextView timerTextView;
    Boolean counterIsActive=false;
    Button controllerButton;
    CountDownTimer countDownTimer;

    public void resetTimer(){
        timerTextView.setText("0:30");
        eggTimerSeekBar.setProgress(30);
        countDownTimer.cancel();
        controllerButton.setText("GO");
        eggTimerSeekBar.setEnabled(true);
        counterIsActive=false;
        }



    public void controlTimer(View view) {

        if (counterIsActive == false) {
            counterIsActive = true;
            eggTimerSeekBar.setEnabled(false);
            controllerButton.setText("STOP");


             countDownTimer=new CountDownTimer(eggTimerSeekBar.getProgress() * 1000 + 100, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    updateTimer((int) millisUntilFinished / 1000);

                }

                @Override
                public void onFinish() {
                    timerTextView.setText("0:00");
                    MediaPlayer mPlayer = MediaPlayer.create(getApplicationContext(), R.raw.airhorn);
                    mPlayer.start();
                    resetTimer();



                }
            }.start();

        }else {
            resetTimer();


        }


    }

    public void updateTimer(int secondsLeft) {
        int minutes = (int) secondsLeft / 60;
        int seconds = secondsLeft - minutes * 60;

        String secondString = "" + seconds;

        if(seconds <= 9) {
            secondString = "0" + secondString;
        }

        timerTextView.setText("" + minutes + ":" + secondString);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         eggTimerSeekBar=(SeekBar)findViewById(R.id.eggTimerSeekBar);
         timerTextView=(TextView)findViewById(R.id.timerTextView);
         controllerButton=(Button)findViewById(R.id.controllerButton);
         eggTimerSeekBar.setMax(600);
         eggTimerSeekBar.setProgress(30);

        eggTimerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateTimer(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }




}
