package com.kobalja.weather.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kobalja.weather.R;
import com.kobalja.weather.model.MyWeather;

import java.util.ArrayList;

//ViewHolder 쓰는 이유? 대량의 data가 리스트로 올라가니 메모리 문제, 데이터 누락등의 문제가 발생했다.
// 그래서 관리를 위해 ViewHolder쓴다. 정확한 이유는 아니다. 검색 해야함

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> implements OnWeatherItemClickListener {
    ArrayList<MyWeather> items = new ArrayList<>(); //items라는 객체배열을 통해서 관리
    OnWeatherItemClickListener listener;

    @NonNull
    @Override
    //itemView는 화면정보, data적인 부분은 adapter
    public WeatherAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.weather_list, parent, false);  //layout의 weather_list파일이 없어서 오류발생할수있다. recyclerview 를 가진 layout 파일을 생성하고 id를 주어 해결
        return new ViewHolder(itemView,this); //ViewHolder 객체
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherAdapter.ViewHolder holder, int position) {
        MyWeather item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(MyWeather item) {
        items.add(item);
    }

    public MyWeather getItem(int position) {
        return items.get(position);
    }

    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if (listener != null) {
            listener.onItemClick(holder, view, position);
        }
    }

    public void setOnItemClickListener(OnWeatherItemClickListener listener) {
        this.listener = listener;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView date, time, weather;
        ImageView weather_img;

        public ViewHolder(@NonNull View itemView, final OnWeatherItemClickListener listener) {
            super(itemView);
            date = itemView.findViewById(R.id.wv_date);  //리스트 아이디
            time = itemView.findViewById(R.id.wv_time);
            weather = itemView.findViewById(R.id.wv_weather);
            weather_img = itemView.findViewById(R.id.wv_icon);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (listener != null) {
                        listener.onItemClick(ViewHolder.this, view, position);
                    }
                }
            });
        }

        public void setItem(MyWeather item) {
            date.setText(item.getDate());
            time.setText(item.getTime());
            weather.setText(item.getWeather());
            weather_img.setImageResource(getWeatherImage(item.getWeather()));

        }

        public int getWeatherImage(String wfkor) {
            int image = 0;
            switch (wfkor) {
                case "맑음":
                    image = R.drawable.sunny;
                    break;
                case "흐림":
                    image = R.drawable.cloud;
                    break;
                case "구름 조금":
                    image = R.drawable.littlecloud;
                    break;
                case "구름 많음":
                    image = R.drawable.cloud;
                    break;
                case "눈/비":
                    image = R.drawable.snow_rain;
                    break;
                case "눈":
                    image = R.drawable.snowy;
                    break;
                case "비":
                    image = R.drawable.rainy;
                    break;
            }
            return image;
        }



    }
}
