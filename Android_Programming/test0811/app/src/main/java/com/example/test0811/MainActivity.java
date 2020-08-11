package com.example.test0811;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    PersonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
                        false);
        recyclerView.setLayoutManager(layoutManager);

        adapter=new PersonAdapter();


        Person perArr[]= new Person[20];
        for(int i=0; i<perArr.length; i++){
            perArr[i]=new Person(R.drawable.login_user,R.drawable.back,"kobalja"+i,"26","kobalja2020@tistory.com","대구시 거주"+i);
            adapter.addItem(perArr[i]);
        }
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnPersonItemClickListener() {
            @Override
            public void onItemClick(PersonAdapter.ViewHolder holder, View view, int position) {
                Person item=adapter.getItem(position);
                Toast.makeText(getApplicationContext(),"이름: "+item.getName()+"\n나이: "+item.getAge()+"\n이메일: "+item.getAddr(),Toast.LENGTH_SHORT).show();
                Log.d("MainActivity","이름: "+item.getName());
                Log.d("MainActivity","나이: "+item.getAge());
                Log.d("MainActivity","이메일: "+item.getEmail());
                Log.d("MainActivity","주소: "+item.getAddr());

            }
        });


    }
}