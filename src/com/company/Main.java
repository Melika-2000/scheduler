package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TaskType Z = new TaskType("Z",1,"A","C");
        TaskType Y = new TaskType("Y",2,"C","B");
        TaskType X = new TaskType("X",3,"A","B");
        ArrayList<TaskType> taskTypes = new ArrayList<>();
        taskTypes.add(Z);
        taskTypes.add(Y);
        taskTypes.add(X);


        int aSize = scan.nextInt();
        int bSize = scan.nextInt();
        int cSize = scan.nextInt();
        int n = scan.nextInt();

        ArrayList <Task> tasks = new ArrayList<>();
        for(int i=0; i<n; i++){
            String taskName = scan.next();
            String taskTypeName = scan.next();
            int taskDuration = scan.nextInt();
            for(TaskType t : taskTypes){
                if(t.getName() == taskTypeName)
                    tasks.add(new Task(taskName,t,taskDuration));
            }
        }

    }
}
