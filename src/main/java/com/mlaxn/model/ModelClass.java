package com.mlaxn.model;

public class ModelClass {
    int eid;
    String name;
    String position;

    //Default Constructor
    public ModelClass() {}

    public ModelClass(int eid, String name, String position) {
        this.eid = eid;
        this.name = name;
        this.position = position;
    }

    public int getEid() {
        return eid;
    }
    public void setEid(int eid) {
        this.eid = eid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }

}

