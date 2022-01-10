package com.company;

import java.util.ArrayList;

public class Task {

    private String name;
    private TaskType type;
    private int duration;
    private String state;
    private int cpuTime = 0;

    public Task(String name, TaskType type,int duration){
        this.name = name;
        this.type = type;
        this.duration = duration;
    }

    public void setState(String state) {
        this.state = state;
    }
    public String getTypeName() {
        return type.getName();
    }

    public ArrayList<String> getTypeResources() {
        return type.getResources();
    }

    public int getTypePriority(){
        return type.getPriority();
    }

    public String getName() {
        return name;
    }

    public void cpuTimeAdder() {
        cpuTime++;
    }

    public int getDuration() {
        return duration;
    }

    public String getState() {
        return state;
    }


}
