package com.kobalja.weather.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kobalja.weather.R;
import com.kobalja.weather.fragment.WeatherFragment;
import com.kobalja.weather.fragment.WeatherFragmentB;
import com.kobalja.weather.util.GetXmlTask;

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

//    public void onSearchWeather(View v) {  //attribute의 onclick에 onSearchWeather입력 후 메인에 넣으면 WeatherFragment의 rootview와 동일하게 동작한다.
//        GetXmlTask task = new GetXmlTask(this);
//        switch (v.getId()) {
//            case R.id.kangwon:
//                task.execute("https://www.kma.go.kr/wid/queryDFS.jsp?gridx=73&gridy=134");
//                break;
//            case R.id.Busan:
//                task.execute("https://www.kma.go.kr/wid/queryDFS.jsp?gridx=60&gridy=127");
//                break;
//            case R.id.seoul:
//                task.execute("https://www.kma.go.kr/wid/queryDFS.jsp?gridx=37&gridy=127");
//                break;
//            case R.id.daegu:
//                task.execute("https://www.kma.go.kr/wid/queryDFS.jsp?gridx=35&gridy=128");
//                break;
////        }
//    }
}