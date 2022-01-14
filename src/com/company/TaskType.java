package com.company;

import java.util.ArrayList;

public class TaskType {
    private String name;
    private ArrayList<String> resources = new ArrayList<>();
    private int Priority;

    public TaskType(String name,int priority,String r1, String r2){
        this.name = name;
        this.Priority = priority;
        resources.add(r1);
        resources.add(r2);
    }

    public ArrayList<String> getResources() {
        return resources;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return Priority;
    }
}