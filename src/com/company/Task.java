package com.company;

import java.util.ArrayList;

public class Task implements Comparable<Task> {

    private String name;
    private int duration;
    private int typePriority;
    private String state;
    private int cpuTime = 0;

    public Task(String name,int typePriority,int duration){
        this.name = name;
        this.typePriority = typePriority;
        this.duration = duration;
    }

    public void setState(String state) {
        this.state = state;
    }


    public int getTypePriority(){
        return typePriority;
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

    public int getCpuTime() {
        return cpuTime;
    }

    public String getState() {
        return state;
    }

    @Override
    public int compareTo(Task t) {
        if(this.duration < t.getDuration())
            return -1;
        else if(this.duration > t.getDuration())
            return 1;
        return 0;
    }

}
