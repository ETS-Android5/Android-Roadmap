package com.example.androidroadmap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class SplashActivity extends AppCompatActivity {

    ImageView img;
    LottieAnimationView lottie;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        img = findViewById(R.id.img);
        lottie = findViewById(R.id.lottie);
        text = findViewById(R.id.text);

        //Animations
        img.animate().translationY(-2600).setDuration(1000).setStartDelay(7000);
        lottie.animate().translationY(2600).setDuration(1000).setStartDelay(7000);
        text.animate().translationX(1500).setDuration(1000).setStartDelay(7000);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        }, 8000);
    }
}