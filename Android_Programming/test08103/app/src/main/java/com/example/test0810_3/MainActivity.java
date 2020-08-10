package com.example.test0810_3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_user;
    TextView userInfo;
    static final int USER_FORM_REQ=1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("회원가입폼 v1.0");


        btn_user=findViewById(R.id.btn_user);
        userInfo=findViewById(R.id.userInfo);
        btn_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),UserForm.class);
                startActivityForResult(intent,USER_FORM_REQ);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==USER_FORM_REQ){
            if(resultCode==RESULT_OK){
                String id=data.getStringExtra("ID");
                String passwd=data.getStringExtra("PW");
                String phone=data.getStringExtra("PhoneNumber");
                String email=data.getStringExtra("Email");
                String hobby=data.getStringExtra("Hobby");
                String userData= String.format(""+"이름:%s\n"+"비밀번호:%s\n"+"휴대폰번호:%s\n"
                +"이메일:%s\n"+"취미:%s",id,passwd,phone,email,hobby);
                userInfo.setText(userData);
            }
            else if(resultCode==RESULT_CANCELED){
                Toast.makeText(this,"회원가입을 취소했습니다.",Toast.LENGTH_SHORT).show();
            }
        }
    }
}