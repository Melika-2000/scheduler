package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Function {
    ArrayList<Task> tasks;

    public Function(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void shortestJobFirst() {
        PriorityQueue<Task> tasksQ = new PriorityQueue();
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
        tasksQ.addAll(tasks);
        int q = 4;
        int time = 0;
        while (!tasksQ.isEmpty()) {
            System.out.println("\n---------");
            Task task = tasksQ.poll();
            while (task.getDuration() != task.getCpuTime()) {
                System.out.println("Time:" + time + "  Running: " + task.getName());
                printQ(tasksQ);
                task.cpuTimeAdder();
                time++;
                if (task.getCpuTime() % q == 0 && task.getDuration() != task.getCpuTime()) {
                    tasksQ.add(task);
                    break;
                }
            }
        }
    }

    public void HRRN() {
        int time = 0;
        while (tasks.size() > 0) {
            System.out.println("\n---------");
            double maxRR = 0.0;
            Task selectedTask = tasks.get(0);
            for (Task task : tasks) {
                if (((float)time + task.getDuration()) / task.getDuration() > maxRR) {
                    selectedTask = task;
                    maxRR = (float) (time + task.getDuration()) / task.getDuration();
                }
            }
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
