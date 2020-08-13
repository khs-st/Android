package com.kobalja.weather.activity;

import androidx.appcompat.app.AppCompatActivity;

import com.kobalja.weather.R;
import com.kobalja.weather.model.MyWeather;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class WeatherView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_view);
        ArrayList<MyWeather> weatherArrayList = (ArrayList<MyWeather>) getIntent().getSerializableExtra("MyWeather");

        for (int i = 0; i < weatherArrayList.size(); i++) {
            Log.d("WeatherView", "날짜: " + weatherArrayList.get(i).getDate());
            Log.d("WeatherView", "시간: " + weatherArrayList.get(i).getTime());
            Log.d("WeatherView", "온도: " + weatherArrayList.get(i).getTemp());
            Log.d("WeatherView", "습도: " + weatherArrayList.get(i).getHumi());
            Log.d("WeatherView", "강수확률: " + weatherArrayList.get(i).getPop());
            Log.d("WeatherView", "날씨: " + weatherArrayList.get(i).getWeather());
            Log.d("WeatherView", "----------------------------");
        }
    }
}