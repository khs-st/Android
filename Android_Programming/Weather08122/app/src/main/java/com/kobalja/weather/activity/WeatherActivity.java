package com.kobalja.weather.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kobalja.weather.R;
import com.kobalja.weather.model.MyWeather;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class WeatherActivity extends AppCompatActivity {
    Button DaeguStartweather;
    TextView DaeguWeatherinfo;
    ArrayList<MyWeather> weatherArrList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        setTitle("대구 날씨 정보");
        DaeguStartweather = findViewById(R.id.startweather);
        DaeguWeatherinfo = findViewById(R.id.weatherinfo);

        DaeguStartweather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetXmlTask task = new GetXmlTask();
                task.execute("https://www.kma.go.kr/wid/queryDFS.jsp?gridx=89&gridy=90");
            }
        });
    }

    private class GetXmlTask extends AsyncTask<String, Void, Document> {
        Document doc = null;

        //작업쓰레드 영역
        @Override
        protected Document doInBackground(String... strings) {
            URL url;


            try {
                url = new URL(strings[0]);
                DocumentBuilderFactory dbf =
                        DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                doc = db.parse(new InputSource(url.openStream()));
                doc.getDocumentElement().normalize();
                ;
            } catch (Exception e) {
                Log.d("GetXmlTask", "xml에러: " + e.getMessage());
            }
            return doc;
        }

        //작업쓰레드 종료 후에 처리(UI 쓰레드) temp는 온도, wkfor은 날씨를 한국어로
        @Override
        protected void onPostExecute(Document document) {
            super.onPostExecute(document);

            String s = "";
            NodeList nodeList = doc.getElementsByTagName("data");
            Calendar cal = Calendar.getInstance();
            int year = cal.get(cal.YEAR);
            int month = cal.get(cal.MONTH) + 1;
            int date = cal.get(cal.DATE);
            String strDate = null;


            for (int i = 0; i < nodeList.getLength(); i++) {
                s += "" + i + ": 대구 날씨 정보: ";
                Node node = nodeList.item(i);
                Element fstElmnt = (Element) node;
                //날짜: 2020년 8월 13일
                //시간, 날씨,  온도, 습도, 강수확률,

                NodeList day = fstElmnt.getElementsByTagName("day");
                Element dayElement = (Element) day.item(0);
                day = dayElement.getChildNodes();
                switch (day.item(0).getNodeValue()) {
                    case "0": //오늘
                        strDate = String.format("%s년 %s월 %s일", year, month, date);
                        Log.d("onPostExecute", "오늘 날짜: " + strDate);
                        break;
                    case "1": //내일
                        strDate = String.format("%s년 %s월 %s일", year, month, date + 1);
                        Log.d("onPostExecute", "내일 날짜: " + strDate);
                        break;
                    case "2": //모레
                        strDate = String.format("%s년 %s월 %s일", year, month, date + 2);
                        Log.d("onPostExecute", "모레 날짜: " + strDate);
                        break;
                }
                s += "날짜 = " + strDate + ", ";

                NodeList hourList = fstElmnt.getElementsByTagName("hour");
                Element hourElement = (Element) hourList.item(0);
                hourList = hourElement.getChildNodes();
                String time = hourList.item(0).getNodeValue();
                s += "시간 = " + time + "H ,";

                NodeList tempList = fstElmnt.getElementsByTagName("temp");
                Element nameElement = (Element) tempList.item(0);
                tempList = nameElement.getChildNodes();
                String temp = tempList.item(0).getNodeValue();
                s += "온도 = " + temp + "℃ ,";

                NodeList rehList = fstElmnt.getElementsByTagName("reh");
                Element rehElement = (Element) rehList.item(0);
                rehList = rehElement.getChildNodes();
                String humi = rehList.item(0).getNodeValue();
                s += "습도 = " + humi + "℃ ,";

                NodeList popList = fstElmnt.getElementsByTagName("pop");
                Element popElement = (Element) popList.item(0);
                popList = popElement.getChildNodes();
                String pop = popList.item(0).getNodeValue();
                s += "강수확률 = " + pop + "% ,";

                NodeList weatherList = fstElmnt.getElementsByTagName("wfKor");
                Element weatherElement = (Element) weatherList.item(0);
                weatherList = weatherElement.getChildNodes();
                String weather = weatherList.item(0).getNodeValue();
                s += "날씨 = " + weather + "\n";
                weatherArrList.add(new MyWeather(strDate, time, temp, humi, pop, weather));
            }
            DaeguWeatherinfo.setText(s);
//            for (int i = 0; i < weatherArrList.size(); i++) {
//                Log.d("onPostExecute", "날짜: " + weatherArrList.get(i).getDate());
//                Log.d("onPostExecute", "시간: " + weatherArrList.get(i).getTime());
//                Log.d("onPostExecute", "온도: " + weatherArrList.get(i).getTemp());
//                Log.d("onPostExecute", "습도: " + weatherArrList.get(i).getHumi());
//                Log.d("onPostExecute", "강수확률: " + weatherArrList.get(i).getPop());
//                Log.d("onPostExecute", "날씨: " + weatherArrList.get(i).getWeather());
//                Log.d("onPostExecute", "----------------------------");
//            }

            Intent intent=new Intent(getApplicationContext(),WeatherView.class);
            intent.putExtra("MyWeather",weatherArrList);
            startActivity(intent);
        }
    }

}