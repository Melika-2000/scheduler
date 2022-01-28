package com.company;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Hashtable<String,Integer> taskTypes = new Hashtable<>();
        taskTypes.put("Z",1);
        taskTypes.put("Y",2);
        taskTypes.put("X",3);

        int n = scan.nextInt();

        ArrayList <Task> tasks = new ArrayList<>();
        for(int i=0; i<n; i++){
            String tName = scan.next();
            String tType = scan.next();
            int tDuration = scan.nextInt();
            int tArrivalTime = scan.nextInt();
            tasks.add(new Task(tName,taskTypes.get(tType), tDuration, tArrivalTime));
        }

        Function func = new Function(tasks);
        func.roundRobin();
/*
5
a Y 10 1
b Z 6 0
c Y 2 2
d Z 5 5
e X 1 8
*/
    }
}
