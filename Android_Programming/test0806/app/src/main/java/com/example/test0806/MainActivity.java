package com.example.test0806;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CheckBox CheckAgree;
    TextView Q;
    RadioGroup Rg;
    Button btn;
    ImageView showImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CheckAgree = findViewById(R.id.CheckAgree);
        Q = findViewById(R.id.Q);
        Rg = findViewById(R.id.Rg);
        btn = findViewById(R.id.btn);
        showImg = findViewById(R.id.showImg);
        CheckAgree.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        //시작 체크박스가 체크되면
                        if(CheckAgree.isChecked()==true){
                            Q.setVisibility(View.VISIBLE);
                            Rg.setVisibility(View.VISIBLE);
                            btn.setVisibility(View.VISIBLE);
                            showImg.setVisibility(View.VISIBLE);
                        }
                        else{
                            Q.setVisibility(View.INVISIBLE);
                            Rg.setVisibility(View.INVISIBLE);
                            btn.setVisibility(View.INVISIBLE);
                            showImg.setVisibility(View.INVISIBLE);                        }
                    }
                }
        );
    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
                switch(Rg.getCheckedRadioButtonId()){
                    case R.id.R_C:
                        showImg.setImageResource(R.drawable.c);
                        break;
                    case R.id.R_CPP:
                        showImg.setImageResource(R.drawable.cpp);
                        break;
                    case R.id.R_JAVA:
                        showImg.setImageResource(R.drawable.java);
                        break;
                    case R.id.R_JQ:
                        showImg.setImageResource(R.drawable.jquery);
                        break;
                    case R.id.R_JS:
                        showImg.setImageResource(R.drawable.javascript);
                        break;
                }
        }
    });
    }
}