package com.example.project0803;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //위젯의 id와 연결할 변수 선언
        Button ok, exit;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //위젯과 변수를 연결
        ok=findViewById(R.id.exit);
        exit=findViewById(R.id.exit);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"확인 버튼 클릭",Toast.LENGTH_SHORT).show();;
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}