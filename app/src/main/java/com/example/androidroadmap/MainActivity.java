package com.example.androidroadmap;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

//    String prevStarted = "yes";
    ImageView img2, img3, imgSplash1, imgSplash2, imgSplash3;
    TextView tvIntro, tvHello, tvWelcome, tvPurpose, tvPurCon, tvOfApplication, tvEasy, tvStep, tvExp;
    Animation animFadeIn, animFadeOut, animMoveInRight, animMoveUp, animMoveDown, animMoveInLeft, animMoveOutRight, animMoveOutLeft;
    Button btnDiveIn, btnProceed, btnLetsGo;
    ConstraintLayout mainActivityParent;

//    @Override
//    protected void onResume() {
//        super.onResume();
//        SharedPreferences sharedpreferences = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
//        if (!sharedpreferences.getBoolean(prevStarted, false)) {
//            SharedPreferences.Editor editor = sharedpreferences.edit();
//            editor.putBoolean(prevStarted, Boolean.TRUE);
//            editor.apply();
//        } else {
//            moveToSecondary();
//        }
//
//
//    }

//    private void moveToSecondary() {
//        startActivity(intent);
//    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivityParent = findViewById(R.id.mainActivityParent);

        //1

        imgSplash1 = findViewById(R.id.imgSplash1);
        tvIntro = findViewById(R.id.tvIntro);
        tvHello = findViewById(R.id.tvHello);
        tvWelcome = findViewById(R.id.tvWelcome);
        btnDiveIn = findViewById(R.id.btnDiveIn);


        //2

        imgSplash2 = findViewById(R.id.imgSplash2);
        tvPurpose = findViewById(R.id.tvPurpose);
        tvOfApplication = findViewById(R.id.tvOfApplication);
        tvPurCon = findViewById(R.id.tvPurCon);
        btnProceed = findViewById(R.id.btnProceed);
        img2 = findViewById(R.id.img2);


        //3

        img3 = findViewById(R.id.img3);
        imgSplash3 = findViewById(R.id.imgSplash3);
        tvEasy = findViewById(R.id.tvEasy);
        tvStep = findViewById(R.id.tvStep);
        tvExp = findViewById(R.id.tvExp);
        btnLetsGo = findViewById(R.id.btnLetsGo);



        animFadeIn = AnimationUtils.loadAnimation(MainActivity.this,R.anim.fade_in);
        animFadeOut = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_out);
        animMoveUp = AnimationUtils.loadAnimation(MainActivity.this, R.anim.move_up);
        animMoveDown = AnimationUtils.loadAnimation(MainActivity.this,R.anim.move_down);
        animMoveInRight = AnimationUtils.makeInAnimation(MainActivity.this, true);
        animMoveInLeft = AnimationUtils.makeInAnimation(MainActivity.this, false);
        animMoveOutRight = AnimationUtils.makeOutAnimation(MainActivity.this, true);
        animMoveOutLeft = AnimationUtils.makeOutAnimation(MainActivity.this, false);



        //1
        imgSplash1.setVisibility(View.VISIBLE);
        tvHello.setVisibility(View.VISIBLE);
        tvWelcome.setVisibility(View.VISIBLE);
        tvIntro.setVisibility(View.VISIBLE);
        btnDiveIn.setVisibility(View.VISIBLE);

        imgSplash1.startAnimation(animMoveInRight);
        tvHello.startAnimation(animFadeIn);
        tvWelcome.startAnimation(animFadeIn);
        tvIntro.startAnimation(animMoveUp);
        btnDiveIn.startAnimation(animMoveInLeft);
        mainActivityParent.setBackgroundColor(getResources().getColor(R.color.white2));


        Window window = MainActivity.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(MainActivity.this.getResources().getColor(R.color.white3));






        //2
        btnDiveIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imgSplash1.startAnimation(animMoveOutLeft);
                tvHello.startAnimation(animFadeOut);
                tvWelcome.startAnimation(animFadeOut);
                tvIntro.startAnimation(animMoveDown);
                btnDiveIn.startAnimation(animMoveOutRight);

                imgSplash1.setVisibility(View.GONE);
                tvHello.setVisibility(View.GONE);
                tvWelcome.setVisibility(View.GONE);
                tvIntro.setVisibility(View.GONE);
                btnDiveIn.setVisibility(View.GONE);

                new Handler().postDelayed(new Runnable() {
                    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void run() {
                        img2.setVisibility(View.VISIBLE);
                        img2.startAnimation(animMoveInLeft);

                        Window window = MainActivity.this.getWindow();
                        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                        window.setStatusBarColor(MainActivity.this.getResources().getColor(R.color.status2));

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                mainActivityParent.setBackgroundColor(getResources().getColor(R.color.status2));
                            }
                        },350);

                        imgSplash2.setVisibility(View.VISIBLE);
                        tvPurpose.setVisibility(View.VISIBLE);
                        tvOfApplication.setVisibility(View.VISIBLE);
                        tvPurCon.setVisibility(View.VISIBLE);
                        btnProceed.setVisibility(View.VISIBLE);

                        imgSplash2.startAnimation(animMoveInRight);
                        tvPurpose.startAnimation(animFadeIn);
                        tvOfApplication.startAnimation(animFadeIn);
                        tvPurCon.startAnimation(animMoveUp);
                        btnProceed.startAnimation(animMoveInLeft);

                    }
                }, 1000);

            }
        });


        //3
        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imgSplash2.startAnimation(animMoveOutLeft);
                tvPurpose.startAnimation(animFadeOut);
                tvOfApplication.startAnimation(animFadeOut);
                tvPurCon.startAnimation(animMoveDown);
                btnProceed.startAnimation(animMoveOutRight);

                imgSplash2.setVisibility(View.GONE);
                tvPurpose.setVisibility(View.GONE);
                tvOfApplication.setVisibility(View.GONE);
                tvPurCon.setVisibility(View.GONE);
                btnProceed.setVisibility(View.GONE);


                new Handler().postDelayed(new Runnable() {
                    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void run() {
                        img3.setVisibility(View.VISIBLE);
                        img3.startAnimation(animMoveInRight);


                        Window window = MainActivity.this.getWindow();
                        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                        window.setStatusBarColor(MainActivity.this.getResources().getColor(R.color.status3));

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                mainActivityParent.setBackgroundColor(getResources().getColor(R.color.status3));
                            }
                        },350);

                        imgSplash3.setVisibility(View.VISIBLE);
                        tvEasy.setVisibility(View.VISIBLE);
                        tvStep.setVisibility(View.VISIBLE);
                        tvExp.setVisibility(View.VISIBLE);
                        btnLetsGo.setVisibility(View.VISIBLE);

                        imgSplash3.startAnimation(animMoveInRight);
                        tvEasy.startAnimation(animFadeIn);
                        tvStep.startAnimation(animFadeIn);
                        tvExp.startAnimation(animMoveUp);
                        btnLetsGo.startAnimation(animMoveInLeft);
                    }
                },1000);

            }
        });

        btnLetsGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imgSplash3.startAnimation(animMoveOutLeft);
                tvEasy.startAnimation(animFadeOut);
                tvStep.startAnimation(animFadeOut);
                tvExp.startAnimation(animMoveDown);
                btnLetsGo.startAnimation(animMoveOutRight);

                imgSplash3.setVisibility(View.GONE);
                tvEasy.setVisibility(View.GONE);
                tvStep.setVisibility(View.GONE);
                tvExp.setVisibility(View.GONE);
                btnLetsGo.setVisibility(View.GONE);


                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MainActivity.this, YoutubeActivity.class);
                        startActivity(intent);
                        finish();
                    }
                },1000);

            }
        });





    }
}