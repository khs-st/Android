package com.example.test0810_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class VoteResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_result);
        Intent intent=getIntent();
        int[] voteResult=intent.getIntArrayExtra("VC");
        String[] imgName=intent.getStringArrayExtra("ImgName");

        TextView tvArr[]=new TextView[9];
        RatingBar rbarArr[]=new RatingBar[9];
        int tvId[]={
          R.id.tV1, R.id.tV2,R.id.tV3,R.id.tV4,R.id.tV5,R.id.tV6,
                R.id.tV7,R.id.tV8,R.id.tV9
        };

        int rbarId[]={
          R.id.ratingBar1,  R.id.ratingBar2,R.id.ratingBar3,R.id.ratingBar4,R.id.ratingBar5,
                R.id.ratingBar6,R.id.ratingBar7,R.id.ratingBar8,R.id.ratingBar9
        };
        for(int i=0; i<9; i++){
            tvArr[i]=findViewById(tvId[i]);
            rbarArr[i]=findViewById(rbarId[i]);

            tvArr[i].setText(imgName[i]);
            rbarArr[i].setRating((float)voteResult[i]);
        }
        Button btn_exit=findViewById(R.id.btn_exit);
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}