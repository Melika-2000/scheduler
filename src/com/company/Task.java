package com.company;

public class Task implements Comparable<Task> {

    private String name;
    private int duration;
    private int typePriority;
    private String state;
    private int cpuTime = 0;
    private int arrivalTime;
    private int waitingTime = 0;
    private static int functionType;

    public Task(String name,int typePriority,int duration, int arrivalTime){
        this.name = name;
        this.typePriority = typePriority;
        this.duration = duration;
        this.arrivalTime = arrivalTime;
    }

    public static void setFunctionType(int functionType) {
        Task.functionType = functionType;
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

    public int getWaitingTime() {
        return waitingTime;
    }

    public void waitingTimeAdder(){
        waitingTime++;
    }

    public String getState() {
        return state;
    }

    @Override
    public int compareTo(Task t) {
        if(functionType == 1) {
            if (this.duration < t.getDuration())
                return -1;
            else if (this.duration > t.getDuration())
                return 1;
        }else if (functionType == 2){
            if (((float)this.getWaitingTime() + this.getDuration()) / this.getDuration() > ((float)t.getWaitingTime() + t.getDuration()) / t.getDuration())
                return -1;
            else if (((float)this.getWaitingTime() + this.getDuration()) / this.getDuration() < ((float)t.getWaitingTime() + t.getDuration()) / t.getDuration())
                return 1;
            else if (((float)this.getWaitingTime() + this.getDuration()) / this.getDuration() == ((float)t.getWaitingTime() + t.getDuration()) / t.getDuration()){
                if (this.getTypePriority() < t.getTypePriority())
                    return -1;
                else if (this.getTypePriority() > t.getTypePriority())
                    return 1;
            }
        }
        return 0;
    }
}
