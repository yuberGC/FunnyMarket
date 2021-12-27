package com.usa.funnymarket.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.usa.funnymarket.R;

import java.util.Timer;
import java.util.TimerTask;

public class Main_Splash extends AppCompatActivity {

    private ProgressBar progressBarAnimator;
    private ObjectAnimator progressAnimator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_splash);
        barraInicio();
        progressAnimator.setDuration(5000);

        progressAnimator.start();


        progressAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);

            }
        });
        Intent intent =new Intent(this,MainActivity.class);

        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                startActivity(intent);
                finish();
            }
        };

        Timer reloj = new Timer();
        reloj.schedule(tarea,5000);



    }

    private void barraInicio(){
        progressBarAnimator = findViewById(R.id.progressBar);
        progressAnimator = ObjectAnimator.ofInt(progressBarAnimator,"progress",0,100);
    }


}