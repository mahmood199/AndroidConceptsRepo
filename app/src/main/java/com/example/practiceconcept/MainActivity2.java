package com.example.practiceconcept;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.androchef.happytimer.countdowntimer.CircularCountDownView;
import com.androchef.happytimer.countdowntimer.HappyTimer;
import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;
import com.tbuonomo.morphbottomnavigation.MorphBottomNavigationView;

public class MainActivity2 extends AppCompatActivity {

    CircularCountDownView circularCountDownView;
    Button start, stop, resume, pause, reset;

    ImageView imageView;
    NumberPicker numberPicker;
    MeowBottomNavigation meowBottomNavigation;
    MorphBottomNavigationView morphBottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        circularCountDownView = findViewById(R.id.circularCountDownView);
        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);
        resume = findViewById(R.id.resume);
        pause = findViewById(R.id.pause);
        reset = findViewById(R.id.reset);
        imageView = findViewById(R.id.imageView);
        meowBottomNavigation = findViewById(R.id.meowBottomNavigation);
        morphBottomNavigationView = findViewById(R.id.morphBottomNavigationView);

        numberPicker = findViewById(R.id.numberPicker);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(24);


        meowBottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_android_black_24dp));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_android_black_24dp));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_android_black_24dp));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(4, R.drawable.ic_android_black_24dp));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(5, R.drawable.ic_android_black_24dp));

        /*meowBottomNavigation.setOnClickMenuListener(item ->
                Toast.makeText(MainActivity2.this, String.valueOf(item.getId()), Toast.LENGTH_SHORT).show()
        );*/



/*
        Glide.with(MainActivity2.this)
                .load("https://crests.football-data.org/471.svg")
                .into(imageView);
*/

        GlideToVectorYou.justLoadImage(MainActivity2.this, Uri.parse("https://crests.football-data.org/471.svg"), imageView);

        circularCountDownView.setTimerTextShown(true);

        circularCountDownView.setTimerType(HappyTimer.Type.COUNT_UP);

        circularCountDownView.setTimerTextFormat(CircularCountDownView.TextFormat.HOUR_MINUTE_SECOND);

        circularCountDownView.setStrokeThicknessForeground(10f);
        circularCountDownView.setStrokeThicknessBackground(10f);

        circularCountDownView.setStrokeColorBackground(ContextCompat.getColor(this, R.color.teal_200));
        circularCountDownView.setStrokeColorForeground(ContextCompat.getColor(this, R.color.teal_700));


        circularCountDownView.setTimerTextIsBold(true);
        circularCountDownView.setTimerTextSize(13f);

        //Initialize Your Timer with seconds
        circularCountDownView.initTimer(20);

        circularCountDownView.setOnTickListener(new HappyTimer.OnTickListener() {
            @Override
            public void onTick(int i, int i1) {

            }

            @Override
            public void onTimeUp() {

            }
        });


        circularCountDownView.setStateChangeListener(new HappyTimer.OnStateChangeListener() {
            @Override
            public void onStateChange(HappyTimer.State state, int i, int i1) {

            }
        });


        start.setOnClickListener(v -> {
            circularCountDownView.startTimer();
        });

        stop.setOnClickListener(v -> {
            circularCountDownView.stopTimer();
        });

        resume.setOnClickListener(v -> {
            circularCountDownView.resumeTimer();
        });

        pause.setOnClickListener(v -> {
            circularCountDownView.pauseTimer();
        });

        reset.setOnClickListener(v -> {
            circularCountDownView.initTimer(20);
            /*circularCountDownView.resetTimer();*/
        });

    }
}