package com.example.test0811;

import android.widget.ImageView;

public class Person {
    private int user_img, addr_img;
    private String name, age, email, addr;

    public Person(int user_img, int addr_img, String name, String age, String email, String addr) {
        this.user_img = user_img;
        this.addr_img=addr_img;
        this.name = name;
        this.age = age;
        this.email = email;
        this.addr = addr;

    }

    public int getUser_img() {
        return user_img;
    }

    public void setUser_img(int user_img) {
        this.user_img = user_img;
    }

    public int getAddr_img() {
        return addr_img;
    }

    public void setAddr_img(int addr_img) {
        this.addr_img = addr_img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
