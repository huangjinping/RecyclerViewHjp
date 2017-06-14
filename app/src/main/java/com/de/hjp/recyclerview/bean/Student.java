package com.de.hjp.recyclerview.bean;

import java.util.List;

/**
 * Created by harrishuang on 2017/5/10.
 */

public class Student {
    private int id;
    private String name;
    private List<Course> course;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }
}
