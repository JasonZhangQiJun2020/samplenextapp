package com.sample;

public class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Standard getters for Jackson to use during serialization
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Optional: Standard setters if needed
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}

