package com.example.test0810_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class UserForm extends AppCompatActivity {
    TextView id,passwd,phone,email;
    Button ok,cancel;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_form);
        id=findViewById(R.id.usr_name);
        passwd=findViewById(R.id.usr_number);
        phone=findViewById(R.id.usr_phone);
        email=findViewById(R.id.usr_email);
        spinner=findViewById(R.id.spinner);
        ok=findViewById(R.id.Check);
        cancel=findViewById(R.id.Cancel);

        //spinner 초기화
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("게임");
        arrayList.add("수영");
        arrayList.add("바람의나라 렙업");
        arrayList.add("독서");

        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<>(getApplication(),
                android.R.layout.simple_spinner_dropdown_item,arrayList);
        spinner.setAdapter(arrayAdapter);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.putExtra("ID",id.getText().toString());
                intent.putExtra("PW",passwd.getText().toString());
                intent.putExtra("PhoneNumber",phone.getText().toString());
                intent.putExtra("Email",email.getText().toString());
                intent.putExtra("Hobby",spinner.getSelectedItem().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}