package com.devfest.its.its_devfest.models;

import java.io.Serializable;

/**
 * Created by schhaiderahmed on 27/11/16.
 */

public class Student implements Serializable {


    public String name;


    public Student() {
    }


    public Student(String name) {
        this.name = name;
    }
}

