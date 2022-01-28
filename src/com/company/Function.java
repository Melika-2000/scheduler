package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Function {
    ArrayList<Task> tasks = new ArrayList<>();

    public Function(ArrayList<Task> tasks) {
        int minArrivalTime = tasks.get(0).getArrivalTime();
        Task selectedTask = tasks.get(0);
        while(tasks.size() != 0) {
            for (Task task : tasks) {
                if(task.getArrivalTime() < minArrivalTime){
                    selectedTask = task;
                    minArrivalTime = task.getArrivalTime();
                }
            }
            this.tasks.add(selectedTask);
            tasks.remove(selectedTask);
            minArrivalTime = 1000;
        }
    }

    public void shortestJobFirst() {
        PriorityQueue<Task> tasksQ = new PriorityQueue();
        Task.setFunctionType(1);
        int index = 0;
        while(index < tasks.size()){
            if(tasks.get(index).getArrivalTime() == 0){
                tasksQ.add(tasks.get(index));
                index++;
            }
            else break;
        }
        int time = 0;
        if (index == 0) {
            tasksQ.add(tasks.get(0));
            index = 1;
            time = tasks.get(0).getArrivalTime();
        }
        while (!tasksQ.isEmpty()) {
            System.out.println("\n---------");
            Task task = tasksQ.poll();
            while (task.getDuration() != task.getCpuTime()) {
                System.out.println("Time:" + time + "  Running: " + task.getName());
                while(index < tasks.size() && tasks.get(index).getArrivalTime() <= time ) {
                    tasksQ.add(tasks.get(index));
                    index++;
                }
                printQ(tasksQ);
                task.cpuTimeAdder();
                time++;
            }
            while(index < tasks.size() && (tasksQ.size() == 0 || tasks.get(index).getArrivalTime() <= time)) {
                tasksQ.add(tasks.get(index));
                time = tasks.get(index).getArrivalTime();
                index++;
            }
        }
    }

    public void firstComeFirstServed() {
        Queue<Task> tasksQ = new LinkedList();
        int index = 0;
        while(index < tasks.size()){
            if(tasks.get(index).getArrivalTime() == 0){
                tasksQ.add(tasks.get(index));
                index++;
            }
            else break;
        }
        int time = 0;
        if (index == 0) {
            tasksQ.add(tasks.get(0));
            index = 1;
            time = tasks.get(0).getArrivalTime();
        }
        while (!tasksQ.isEmpty()) {
            System.out.println("\n---------");
            Task task = tasksQ.poll();
            while (task.getDuration() != task.getCpuTime()) {
                System.out.println("Time:" + time + "  Running: " + task.getName());
                while (index < tasks.size() && tasks.get(index).getArrivalTime() <= time) {
                    tasksQ.add(tasks.get(index));
                    index++;
                }
                printQ(tasksQ);
                task.cpuTimeAdder();
                time++;
            }
            while(index < tasks.size() && (tasksQ.size() == 0 || tasks.get(index).getArrivalTime() <= time)) {
                tasksQ.add(tasks.get(index));
                time = tasks.get(index).getArrivalTime();
                index++;
            }
        }
    }

    public void roundRobin() {
        Queue<Task> tasksQ = new LinkedList();
        int q = 3;
        int index = 0;
        while(index < tasks.size()){
            if(tasks.get(index).getArrivalTime() == 0){
                tasksQ.add(tasks.get(index));
                index++;
            }
            else break;
        }
        int time = 0;
        if(index == 0) {tasksQ.add(tasks.get(0)); index = 1;}
        while (!tasksQ.isEmpty()) {
            System.out.println("\n---------");
            Task task = tasksQ.poll();
            while (task.getDuration() != task.getCpuTime()) {
                System.out.println("Time:" + time + "  Running: " + task.getName());
                while(index < tasks.size() && tasks.get(index).getArrivalTime() <= time ) {
                    tasksQ.add(tasks.get(index));
                    index++;
                }
                printQ(tasksQ);
                task.cpuTimeAdder();
                time++;
                if (task.getCpuTime() % q == 0 && task.getDuration() != task.getCpuTime()) {
                    tasksQ.add(task);
                    break;
                }
            }
            while(index < tasks.size() && (tasksQ.size() == 0 || tasks.get(index).getArrivalTime() <= time)) {
                tasksQ.add(tasks.get(index));
                time = tasks.get(index).getArrivalTime();
                index++;
            }
        }
    }

    public void HRRN() {
        PriorityQueue<Task> tasksQ = new PriorityQueue();
        Task.setFunctionType(2);
        int index = 0;
        while(index < tasks.size()){
            if(tasks.get(index).getArrivalTime() == 0){
                tasksQ.add(tasks.get(index));
                index++;
            }
            else break;
        }
        int time = 0;
        if(index == 0) {
            tasksQ.add(tasks.get(0));
            index = 1;
            time = tasks.get(0).getArrivalTime();
        }
        while (!tasksQ.isEmpty()) {
            System.out.println("\n---------");
            Task task = tasksQ.poll();
            while (task.getDuration() != task.getCpuTime()) {
                System.out.println("Time:" + time + "  Running: " + task.getName());
                while(index < tasks.size() && tasks.get(index).getArrivalTime() <= time ) {
                    tasksQ.add(tasks.get(index));
                    index++;
                }
                printQ(tasksQ);
                task.cpuTimeAdder();
                time++;
            }
            while(index < tasks.size() && (tasksQ.size() == 0 || tasks.get(index).getArrivalTime() <= time)) {
                tasksQ.add(tasks.get(index));
                time = tasks.get(index).getArrivalTime();
                index++;
            }
        }
    }

    private void printQ(Queue<Task> queue) {
        Queue<Task> tempQueue = new LinkedList<>();
        System.out.print("ReadyQ:  ");
        while (queue.size() != 0) {
            System.out.print(queue.peek().getName() + " ");
            queue.peek().waitingTimeAdder();
            tempQueue.add(queue.peek());
            queue.poll();
        }
        System.out.println();
        queue.addAll(tempQueue);
    }
}
