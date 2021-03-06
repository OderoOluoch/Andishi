package com.odero.andishi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView andishiLogo;
    RelativeLayout relativeLayout;
    Animation txtAnimation, layoutAnimation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fall_down);
        layoutAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.bottom_to_top);

        andishiLogo = findViewById(R.id.andishiLogo);
        relativeLayout = findViewById(R.id.relMain);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                relativeLayout.setVisibility(View.VISIBLE);
                relativeLayout.setAnimation(layoutAnimation);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        andishiLogo.setVisibility(View.VISIBLE);
                        andishiLogo.setAnimation(txtAnimation);
                    }
                },800);
            }
        }, 900);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Welcome.class);
                startActivity(intent);
            }
        },9000);

    }
}