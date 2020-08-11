package com.example.test0811;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//ViewHolder 쓰는 이유? 대량의 data가 리스트로 올라가니 메모리 문제, 데이터 누락등의 문제가 발생했다.
// 그래서 관리를 위해 ViewHolder쓴다. 정확한 이유는 아니다. 검색 해야함

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> implements OnPersonItemClickListener {
    ArrayList<Person> items = new ArrayList<>(); //items라는 객체배열을 통해서 관리
    OnPersonItemClickListener listener;

    @NonNull
    @Override
    //itemView는 화면정보, data적인 부분은 adapter
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.list_layout, parent, false);
        return new ViewHolder(itemView,this); //ViewHolder 객체
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder holder, int position) {
        Person item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(Person item) {
        items.add(item);
    }

    public Person getItem(int position) {
        return items.get(position);
    }

    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if (listener != null) {
            listener.onItemClick(holder, view, position);
        }
    }

    public void setOnItemClickListener(OnPersonItemClickListener listener) {
        this.listener = listener;
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, age, email, addr;
        ImageView addr_img, user_img;

        public ViewHolder(@NonNull View itemView, final OnPersonItemClickListener listener) {
            super(itemView);
            name = itemView.findViewById(R.id.name);  //리스트 아이디
            age = itemView.findViewById(R.id.age);
            email = itemView.findViewById(R.id.email);
            addr = itemView.findViewById(R.id.addr);
            addr_img = itemView.findViewById(R.id.addr_img);
            user_img = itemView.findViewById(R.id.user_img);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position=getAdapterPosition();
                    if(listener!=null){
                        listener.onItemClick(ViewHolder.this,view,position);
                    }
                }
            });
        }

        public void setItem(Person item) {
            name.setText(item.getName());
            age.setText(item.getAge());
            email.setText(item.getEmail());
            addr.setText(item.getAddr());
            user_img.setImageResource(item.getUser_img());
            addr_img.setImageResource(item.getAddr_img());
        }
    }
}
