package com.kobalja.weather.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kobalja.weather.R;
import com.kobalja.weather.fragment.WeatherFragment;
import com.kobalja.weather.fragment.WeatherFragmentB;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bnview;
    WeatherFragment weatherFragment;
    WeatherFragmentB weatherFragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weatherFragment = new WeatherFragment();
        weatherFragmentB=new WeatherFragmentB();

        bnview=findViewById(R.id.bottom_navigation);
        bnview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.tab1:
                    Toast.makeText(MainActivity.this,"날씨 보기!",Toast.LENGTH_SHORT).show();
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,weatherFragment).commit();
                    return true;
                    case R.id.tab2:
                        Toast.makeText(MainActivity.this,"설정",Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,weatherFragmentB).commit();
                        return true;
                    case R.id. tab3:
                        Toast.makeText(MainActivity.this,"미정",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getApplicationContext(), WeatherActivity.class);
                        startActivity(intent);
                        return true;

                }
                return false;
            }
        });
    }
}