package com.kobalja.weather.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.kobalja.weather.R;

public class Intro extends AppCompatActivity {
    private Handler handler;
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Intent intent=new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        //액션바 숨김
        getSupportActionBar().hide();
        handler=new Handler();
        handler.postDelayed(runnable, 1000);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }

}