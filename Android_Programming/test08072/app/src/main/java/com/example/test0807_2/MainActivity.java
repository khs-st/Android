package com.example.test0807_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button startquiz,exitquiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startquiz=findViewById(R.id.startquiz);
        exitquiz=findViewById(R.id.exitquiz);

        startquiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //시작버튼 누르면 Quiz_step1으로 이동
                Intent intent= new Intent(getApplicationContext(),Quiz_step1.class);
                startActivity(intent);
            }
        });
        exitquiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //쌓여있는 모든 액티비티 종료 처리
                ActivityCompat.finishAffinity(MainActivity.this);
                finish();
                }
        });
    }
}