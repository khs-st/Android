package com.kobalja.weather.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kobalja.weather.R;
import com.kobalja.weather.util.GetXmlTask;

public class WeatherActivity extends AppCompatActivity {
    Button DaeguStartweather;
    TextView DaeguWeatherinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        setTitle("대구 날씨 정보");
        DaeguStartweather = findViewById(R.id.startweather);
        DaeguWeatherinfo = findViewById(R.id.weatherinfo1);

//        DaeguStartweather.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                GetXmlTask task = new GetXmlTask(MainActivity.this);  //this는 weatherActivity를 의미한다.  온클릭이랑 온크리에이트 하는 시점이 같지 않을 수 있다.
//                                                                                       //그래서 연결이 매치가 안되기 때문에  WeatherActivity.this 를 쓴 것 무결성 위반 위험성이 이유
//                                                                                        //  , 온클릭이라는 이벤트 때문에 쓴것, 만약 온클릭 이벤트가 없으면 this로 가져올 수 있음.
//                task.execute("https://www.kma.go.kr/wid/queryDFS.jsp?gridx=89&gridy=90");
//            }
//        });
    }
}