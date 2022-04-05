package com.smithbhavsar.bookyourcoupon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Countdown extends AppCompatActivity {
    private TextView texttimer, randomtext, couponame;
    private CountDownTimer countDownTimer;
    private long timeleft = 180000;
    private boolean timerrunning;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown);

        texttimer = findViewById(R.id.timerintext);
        couponame = findViewById(R.id.couponname);
        Intent i = getIntent();
        String title = i.getStringExtra("Title");
        couponame.setText(title);
        progressBar = findViewById(R.id.countdowntimer);
        randomtext = findViewById(R.id.couponcode);
        startstop();
        timerprocessbar();
        randomtext();

    }

    private void randomtext() {
        randomtext.setText(getRandomString(6));
    }

    private String getRandomString(int i) {
        final String character = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder result = new StringBuilder();
        while (i>0){
            Random random = new Random();
            result.append(character.charAt(random.nextInt(character.length())));
            i--;
        }
        return result.toString();
    }

    private void timerprocessbar() {
        Thread thread = new Thread(){
            @Override
            public void run(){
                super.run();
                for (int i = 100 ; i>0;){
                    try{
                        sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    progressBar.setProgress(i);
                    i--;
                }
            }
        };
        thread.start();
    }

    private void startstop() {
        if (timerrunning){
            stoptimmer();
        }else{
            starttimmer();
        }
    }

    private void starttimmer() {
        countDownTimer = new CountDownTimer(timeleft,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeleft = millisUntilFinished;
                updatetimer();
            }

            @Override
            public void onFinish() {

                Toast.makeText(Countdown.this, "Coupon code expired", Toast.LENGTH_SHORT).show();


            }
        }.start();
        timerrunning = true;
    }

    private void updatetimer() {
        int minutes = (int) timeleft / 60000;
        int seconds = (int) timeleft % 60000 / 1000;

        String timeleftText = "" + minutes;
        timeleftText += ":";
        if (seconds<10)timeleftText += "0";
        timeleftText = timeleftText + seconds;
        texttimer.setText(timeleftText);
    }

    private void stoptimmer() {
        countDownTimer.cancel();
        timerrunning = false;
    }
}