package com.example.test0810_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_vote;
    static final int SIZE=9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("그림투표App v1.0");

        final int voteCount[]=new int[SIZE];
        ImageView imageView[]=new ImageView[SIZE];

        int imageId[]={
                R.id.pic1,R.id.pic2,R.id.pic3,
                R.id.pic4,R.id.pic5,R.id.pic6,
                R.id.pic7,R.id.pic8,R.id.pic9
        };

        final String imageName[]={
                "독서하는 소녀","꽃장식 모자 소녀","부채를 든 소녀",
                "이레느깡 단 베르양","잠자는 소녀","테라스의 두 자매",
                "피아노 레슨","피아노 앞의 소녀들","해변에서"
        };

        for(int i=0; i<SIZE; i++){
            final int index=i;
            imageView[index]=findViewById(imageId[i]);
            imageView[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    voteCount[index]++;
                    Toast.makeText(MainActivity.this,imageName[index]+" 총 "+
                            voteCount[index]+" 표 획득",Toast.LENGTH_SHORT).show();
                }
            });
        }
    btn_vote=findViewById(R.id.btn_vote);
        btn_vote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent=new Intent(getApplicationContext(), VoteResult.class);
            intent.putExtra("VC",voteCount);
            intent.putExtra("ImgName",imageName);
            startActivity(intent);
            }
        });

    }


}