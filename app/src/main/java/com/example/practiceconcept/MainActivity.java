package com.example.practiceconcept;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import ticker.views.com.ticker.widgets.circular.timer.callbacks.CircularViewCallback;
import ticker.views.com.ticker.widgets.circular.timer.view.CircularView;


public class MainActivity extends AppCompatActivity {


    Button button,button2,button3,button4,next_screen;

    CircularView circularView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        next_screen = findViewById(R.id.next_screen);


        next_screen.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this,MainActivity2.class));
        });

        circularView = findViewById(R.id.circular_view);
        CircularView.OptionsBuilder builderWithTimer =
                new CircularView.OptionsBuilder()
                        .shouldDisplayText(false)
                        .setCircularViewCallback(new CircularViewCallback() {
                            @Override
                            public void onTimerFinish() {

                                // Will be called if times up of countdown timer
                                Toast.makeText(MainActivity.this, "CircularCallback: Timer Finished ", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onTimerCancelled() {

                                // Will be called if stopTimer is called
                                Toast.makeText(MainActivity.this, "CircularCallback: Timer Cancelled ", Toast.LENGTH_SHORT).show();
                            }
                        });

        circularView.setOptions(builderWithTimer);


        button.setOnClickListener(v -> {
            circularView.startTimer();
        });

        button2.setOnClickListener(v -> {
            circularView.pauseTimer();
        });

        button3.setOnClickListener(v -> {
            circularView.stopTimer();
        });

        button4.setOnClickListener(v -> {
            circularView.resumeTimer();
        });



    }
}