package com.test.project.model;
import java.io.Serializable;

/* 터미널에서 cd명령으로 classes까지 온 다음, javac -d . LoginBean.java */
public class LoginBean implements java.io.Serializable {
    private String id;
    private String password;
    private String name;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}