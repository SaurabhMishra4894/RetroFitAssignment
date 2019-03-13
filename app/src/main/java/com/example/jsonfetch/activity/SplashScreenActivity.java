package com.example.jsonfetch.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jsonfetch.R;

public class SplashScreenActivity extends AppCompatActivity {

    public static final long SPLASH_SCREEN_TIME = 2000;

    /**
     * onCreate Method for splash screen which displays a splash screen and returns
     * activity after delay of SPLASH_SCREEN_TIME
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splah_screen);

        new Handler().postDelayed(new Runnable() {

            /**
             * Method run is override which will start the Activity after Splash gets completed
             */

            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this, ShowCountriesActivity.class);
                startActivity(intent);
            }
        }, SPLASH_SCREEN_TIME);

        finish();
    }
}