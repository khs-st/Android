package com.kobalja.weather.fragment;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.kobalja.weather.R;
import com.kobalja.weather.activity.MainActivity;
import com.kobalja.weather.util.GetXmlTask;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.net.URL;
import java.util.Calendar;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class WeatherFragment extends Fragment {
    TextView kangwon,Busan,seoul,daegu;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_weather,
                container, false);


        kangwon = rootView.findViewById(R.id.kangwon);
        Busan = rootView.findViewById(R.id.Busan);
        seoul = rootView.findViewById(R.id.seoul);
        daegu = rootView.findViewById(R.id.daegu);

        //도시 매개변수로 주어 지명정보 활용하기 타이틀 정보를 넣어주는 방법


        Busan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetXmlTask task = new GetXmlTask((MainActivity) getActivity(), "부산");
                task.execute("https://www.kma.go.kr/wid/queryDFS.jsp?gridx=60&gridy=127");
                Toast.makeText((MainActivity) getActivity(), "부산 날씨", Toast.LENGTH_SHORT).show();
            }
        });
        kangwon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetXmlTask task = new GetXmlTask((MainActivity) getActivity(),"강원도");
                task.execute("https://www.kma.go.kr/wid/queryDFS.jsp?gridx=73&gridy=134");
                Toast.makeText((MainActivity) getActivity(), "강원도 날씨", Toast.LENGTH_SHORT).show();
            }
        });
        seoul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetXmlTask task = new GetXmlTask((MainActivity) getActivity(),"서울");
                task.execute("https://www.kma.go.kr/wid/queryDFS.jsp?gridx=37&gridy=127");
                Toast.makeText((MainActivity) getActivity(), "서울 날씨", Toast.LENGTH_SHORT).show();
            }
        });
        daegu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetXmlTask task = new GetXmlTask((MainActivity) getActivity(),"대구");
                task.execute("https://www.kma.go.kr/wid/queryDFS.jsp?gridx=35&gridy=128");
                Toast.makeText((MainActivity) getActivity(), "대구 날씨", Toast.LENGTH_SHORT).show();
            }
        });
        return rootView;


    }



    //fragment layout 연결
//        getSeoulWeather = rootView.findViewById(R.id.startweather1);
//        showSeoulWeather=rootView.findViewById(R.id.weatherinfo1);
//        getSeoulWeather.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                GetXmlTask task=new GetXmlTask();
//                task.execute("https://www.kma.go.kr/wid/queryDFS.jsp?gridx=60&gridy=127");
//            }
//        });
//        return rootView;
//    }
//    private class GetXmlTaskFrag extends AsyncTask<String, Void, Document> {
//        Document doc=null;
//
//        //작업쓰레드 영역
//        @Override
//        protected Document doInBackground(String... strings) {
//            URL url;
//
//
//            try{
//                url=new URL(strings[0]);
//                DocumentBuilderFactory dbf=
//                        DocumentBuilderFactory.newInstance();
//                DocumentBuilder db=dbf.newDocumentBuilder();
//                doc=db.parse(new InputSource(url.openStream()));
//                doc.getDocumentElement().normalize();;
//            } catch (Exception e) {
//                Log.d("GetXmlTaskFrag","xml에러: "+e.getMessage());
//            } return doc;
//        }
//
//        //작업쓰레드 종료 후에 처리(UI 쓰레드) temp는 온도, wkfor은 날씨를 한국어로
//        @Override
//        protected void onPostExecute(Document document) {
//            super.onPostExecute(document);
//
//            String s="";
//            NodeList nodeList=doc.getElementsByTagName("data");
//            Calendar cal = Calendar.getInstance();
//            int year=cal.get(cal.YEAR);
//            int month =cal.get(cal.MONTH)+1;
//            int date=cal.get(cal.DATE);
//            String strDate=null;
//
//            for(int i=0; i<nodeList.getLength(); i++) {
//                s += "" + i + ": 서울 날씨 정보: ";
//                Node node = nodeList.item(i);
//                Element fstElmnt = (Element) node;
//
//                NodeList day=fstElmnt.getElementsByTagName("day");
//                Element dayElement=(Element) day.item(0);
//                day=dayElement.getChildNodes();
//                switch (day.item(0).getNodeValue()){
//                    case"0": //오늘
//                        strDate=String.format("%s년 %s월 %s일",year,month,date);
//                        Log.d("onPostExecute","오늘 날짜: "+strDate);
//                        break;
//                    case"1": //내일
//                        strDate=String.format("%s년 %s월 %s일",year,month,date+1);
//                        Log.d("onPostExecute","내일 날짜: "+strDate);
//                        break;
//                    case"2": //모레
//                        strDate=String.format("%s년 %s월 %s일",year,month,date+2);
//                        Log.d("onPostExecute","모레 날짜: "+strDate);
//                        break;
//                }
//                s+="날짜 = "+strDate+", ";
//
//                NodeList hourList=fstElmnt.getElementsByTagName("hour");
//                Element hourElement=(Element) hourList.item(0);
//                hourList=hourElement.getChildNodes();
//                s+="시간 = "+hourList.item(0).getNodeValue()+"H ,";
//
//                NodeList tempList = fstElmnt.getElementsByTagName("temp");
//                Element nameElement = (Element) tempList.item(0);
//                tempList = nameElement.getChildNodes();
//                s += "온도 = " + tempList.item(0).getNodeValue() + "℃ ,";
//
//                NodeList rehList = fstElmnt.getElementsByTagName("reh");
//                Element rehElement = (Element) rehList.item(0);
//                rehList = rehElement.getChildNodes();
//                s += "습도 = " + rehList.item(0).getNodeValue() + "℃ ,";
//
//                NodeList popList = fstElmnt.getElementsByTagName("pop");
//                Element popElement = (Element) popList.item(0);
//                popList = popElement.getChildNodes();
//                s += "강수확률 = " + popList.item(0).getNodeValue() + "% ,";
//
//                NodeList weatherList = fstElmnt.getElementsByTagName("wfKor");
//                Element weatherElement = (Element) weatherList.item(0);
//                weatherList = weatherElement.getChildNodes();
//                s += "날씨 = " + weatherList.item(0).getNodeValue() + "\n";
//            }
//
//        }
//    }
}