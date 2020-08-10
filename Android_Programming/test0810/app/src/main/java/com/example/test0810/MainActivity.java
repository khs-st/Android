package com.example.test0810;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


// 액티비티 lifesycle
//안드로이드의 intent는 자바의 get set
public class MainActivity extends AppCompatActivity {
    Button SendData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity","onStart() 시작");

        SendData=findViewById(R.id.SendData);
        SendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SettingActivity.class);

                intent.putExtra("ID","동대구제일검");
                intent.putExtra("LEVEL",123);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity","onResume() 시작");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity","onPause() 시작");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity","onStop() 시작");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity","onRestart() 시작");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity","onDestroy() 시작");

    }
}