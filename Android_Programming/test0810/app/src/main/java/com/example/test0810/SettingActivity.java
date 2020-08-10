package com.example.test0810;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Intent intent=getIntent();
        Log.d("SettingActivity","아이디: "+intent.getStringExtra("ID"));
        Log.d("SettingActivity","레벨: "+intent.getIntExtra("LEVEL",0));

    }
}