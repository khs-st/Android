package com.example.toggle0806;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    ToggleButton toggleButton_tv,toggleButton_wifi,toggleButton_computer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton_tv=findViewById(R.id.toggleButton_tv);
        toggleButton_wifi=findViewById(R.id.toggleButton_wifi);
        toggleButton_computer=findViewById(R.id.toggleButton_computer);

        toggleButton_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(toggleButton_tv.isChecked()==true){
                    toggleButton_tv.setBackgroundResource(R.drawable.power_on);
                    Toast.makeText(getApplicationContext(),"TV ON",Toast.LENGTH_SHORT).show();
                }
                else{
                    toggleButton_tv.setBackgroundResource(R.drawable.shutdown64);
                    Toast.makeText(getApplicationContext(),"TV OFF",Toast.LENGTH_SHORT).show();
                }
            }
        });
        toggleButton_wifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(toggleButton_wifi.isChecked()==true){
                    toggleButton_wifi.setBackgroundResource(R.drawable.power_on);
                    Toast.makeText(getApplicationContext(),"WIFI ON",Toast.LENGTH_SHORT).show();
                }
                else{
                    toggleButton_wifi.setBackgroundResource(R.drawable.shutdown64);
                    Toast.makeText(getApplicationContext(),"WIFI OFF",Toast.LENGTH_SHORT).show();
                }
            }
        });
        toggleButton_computer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(toggleButton_computer.isChecked()==true){
                    toggleButton_computer.setBackgroundResource(R.drawable.power_on);
                    Toast.makeText(getApplicationContext(),"COMPUTER ON",Toast.LENGTH_SHORT).show();
                }
                else{
                    toggleButton_computer.setBackgroundResource(R.drawable.shutdown64);
                    Toast.makeText(getApplicationContext(),"COMPUTER OFF",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}