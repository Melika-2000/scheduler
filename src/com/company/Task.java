package com.company;

import java.util.ArrayList;

public class Task implements Comparable<Task> {

    private String name;
    private int duration;
    private int typePriority;
    private String state = "notAdded";
    private int cpuTime = 0;
    private int arrivalTime;
    private static int priorityType;

    public Task(String name,int typePriority,int duration, int arrivalTime){
        this.name = name;
        this.typePriority = typePriority;
        this.duration = duration;
        this.arrivalTime = arrivalTime;
    }

    public static void setPriorityType(int priorityType) {
        Task.priorityType = priorityType;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getTypePriority() { return typePriority; }

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
        if(priorityType == 1) {
            if (this.duration < t.getDuration())
                return -1;
            else if (this.duration > t.getDuration())
                return 1;
        }else if (priorityType == 2){
            if (((float)this.getArrivalTime() + this.getDuration()) / this.getDuration() > ((float)t.getArrivalTime() + t.getDuration()) / t.getDuration())
                return -1;
            else if (((float)this.getArrivalTime() + this.getDuration()) / this.getDuration() < ((float)t.getArrivalTime() + t.getDuration()) / t.getDuration())
                return 1;
            else if (((float)this.getArrivalTime() + this.getDuration()) / this.getDuration() == ((float)t.getArrivalTime() + t.getDuration()) / t.getDuration()){
                if (this.getTypePriority() < t.getTypePriority())
                    return -1;
                else if (this.getTypePriority() > t.getTypePriority())
                    return 1;
            }
        }
        return 0;
    }

}
