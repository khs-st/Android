package com.example.test0807_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Quiz_step1 extends AppCompatActivity {
    Button q1_btn_O,q1_btn_X,q1_btn_next,q1_btn_home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_step1);
        q1_btn_O=findViewById(R.id.q1_btn_O);
        q1_btn_X=findViewById(R.id.q1_btn_X);
        q1_btn_next=findViewById(R.id.q1_btn_next);
        q1_btn_home=findViewById(R.id.q1_btn_home);
        q1_btn_next.setEnabled(false);

        q1_btn_O.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"정답!\n다음 퀴즈로!",Toast.LENGTH_SHORT).show();
                q1_btn_next.setEnabled(true);
            }
        });
        q1_btn_X.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"오답입니다.\n다시 살펴보세요.",Toast.LENGTH_SHORT).show();

            }
        });
        q1_btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //퀴즈2로 이동
                Intent intent= new Intent(getApplicationContext(),Quiz_step2.class);
                startActivity(intent);
            }
        });
        q1_btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
}