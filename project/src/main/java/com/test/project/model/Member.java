package com.test.project.model;

public class Member {
    private String id;
    private String passwd;
    private String name;

    public Member() {  }

    public Member(String id, String passwd, String name) {
        this.id = id;
        this.passwd = passwd;
        this.name = name;
    }

    // id getter
    public String getId() {
        return this.id;
    }

    // id setter
    public void setId(String id) {
        this.id = id;
    }

    // passwd getter
    public String getPasswd() {
        return this.passwd;
    }

    // passwd setter
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    // name getter
    public String getName() {
        return this.name;
    }

    // name setter
    public void setName(String name) {
        this.name = name;
    }
}