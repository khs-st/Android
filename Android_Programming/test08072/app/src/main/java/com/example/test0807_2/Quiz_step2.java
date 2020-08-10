package com.example.test0807_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Quiz_step2 extends AppCompatActivity {
    Button q2_btn_O,q2_btn_X,q2_btn_next,q2_btn_home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_step2);
        q2_btn_O=findViewById(R.id.q2_btn_O);
        q2_btn_X=findViewById(R.id.q2_btn_X);
        q2_btn_next=findViewById(R.id.q2_btn_next);
        q2_btn_home=findViewById(R.id.q2_btn_home);
        q2_btn_next.setEnabled(false);

        q2_btn_O.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"오답입니다.\n다시 살펴보세요.",Toast.LENGTH_SHORT).show();

            }
        });
        q2_btn_X.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"정답!\n다음 퀴즈로!",Toast.LENGTH_SHORT).show();
                q2_btn_next.setEnabled(true);
            }
        });
        q2_btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //퀴즈3로 이동
                Intent intent= new Intent(getApplicationContext(),Quiz_step3.class);
                startActivity(intent);
            }
        });
        q2_btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
}