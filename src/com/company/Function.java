package com.company;

import javax.swing.*;
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
        int index = 0;
        while(index < tasks.size()){
            if(tasks.get(index).getArrivalTime() == 0){
                tasksQ.add(tasks.get(index));
                index++;
            }
            else break;
        }
        if(index == 0) {tasksQ.add(tasks.get(0)); index = 1;}
        int time = 0;
        while (!tasksQ.isEmpty()) {
            System.out.println("\n---------");
            Task task = tasksQ.poll();
            while (task.getDuration() != task.getCpuTime()) {
                System.out.println("Time:" + time + "  Running: " + task.getName());
                while(index < tasks.size() && tasks.get(index).getArrivalTime() <= time ) { tasksQ.add(tasks.get(index)); index++; }
                printQ(tasksQ);
                task.cpuTimeAdder();
                time++;
            }
            while(index < tasks.size() && (tasksQ.size() == 0 || tasks.get(index).getArrivalTime() <= time)) { tasksQ.add(tasks.get(index)); time = tasks.get(index).getArrivalTime(); index++; }
        }
    }

    public void firstComeFirstServed() {
        Queue<Task> tasksQ = new LinkedList();
        tasksQ.addAll(tasks);
        int time = 0;
        while (!tasksQ.isEmpty()) {
            System.out.println("\n---------");
            Task task = tasksQ.poll();
            while (task.getDuration() != task.getCpuTime()) {
                System.out.println("Time:" + time + "  Running: " + task.getName());
                printQ(tasksQ);
                task.cpuTimeAdder();
                time++;
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
        if(index == 0) {tasksQ.add(tasks.get(0)); index = 1;}
        int time = 0;
        while (!tasksQ.isEmpty()) {
            System.out.println("\n---------");
            Task task = tasksQ.poll();
            while (task.getDuration() != task.getCpuTime()) {
                System.out.println("Time:" + time + "  Running: " + task.getName());
                while(index < tasks.size() && tasks.get(index).getArrivalTime() <= time ) { tasksQ.add(tasks.get(index)); index++; }
                printQ(tasksQ);
                task.cpuTimeAdder();
                time++;
                if (task.getCpuTime() % q == 0 && task.getDuration() != task.getCpuTime()) {
                    tasksQ.add(task);
                    break;
                }
            }
            while(index < tasks.size() && (tasksQ.size() == 0 || tasks.get(index).getArrivalTime() <= time)) { tasksQ.add(tasks.get(index)); time = tasks.get(index).getArrivalTime(); index++; }
        }
    }

    public void HRRN() {
        int time = 0;
        while (tasks.size() > 0) {
            System.out.println("\n---------");
            float maxRR = (float)0.0;
            Task selectedTask = null;
            int priority = 0;
            for (Task task : tasks){
                if (task.getArrivalTime() <= time){
                    if (((float)task.getArrivalTime() + task.getDuration()) / task.getDuration() > maxRR || ((float)task.getArrivalTime() + task.getDuration()) / task.getDuration() == maxRR && task.getTypePriority() < priority) {
                        priority = task.getTypePriority();
                        selectedTask = task;
                        maxRR = ((float)task.getArrivalTime() + task.getDuration()) / task.getDuration();
                    }
                }
            }
            if(selectedTask == null){time++; continue;}
            tasks.remove(selectedTask);
            while (selectedTask.getDuration() != selectedTask.getCpuTime()) {
                System.out.println("Time:" + time + "  Running: " + selectedTask.getName());
                selectedTask.cpuTimeAdder();
                time++;
            }
        }
    }

    private void printQ(Queue<Task> queue) {
        Queue<Task> tempQueue = new LinkedList<>();
        System.out.print("ReadyQ:  ");
        while (queue.size() != 0) {
            System.out.print(queue.peek().getName() + " ");
            tempQueue.add(queue.peek());
            queue.poll();
        }
        System.out.println();
        queue.addAll(tempQueue);
    }
}
