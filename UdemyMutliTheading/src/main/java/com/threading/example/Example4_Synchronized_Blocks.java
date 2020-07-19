package com.threading.example;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Example4_Synchronized_Blocks {
    // As stageOne and stageTwo are working on two different lists both of them have nothing in common and can run simultaneously
    // Goal is to allow - thread T1 to run stageOne() and Thread T2 to run stageTwo() method concurrently
    // goal is to now allow - thread T1 to run stageOne() and Thread T2 to run stageOne() method concurrently
    // goal is to now allow - thread T1 to run stageTwo() and Thread T2 to run stageTwo() method concurrently

    Random random = new Random();
    public  List<Integer> list1 = new ArrayList<>();
    public  List<Integer> list2 = new ArrayList<>();

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void stageOne() throws InterruptedException {

        synchronized(lock1){
            Thread.sleep(1);
            list1.add(random.nextInt());
        }
    }

    public void stageTwo() throws InterruptedException {
        synchronized (lock2){
            Thread.sleep(1);
            list2.add(random.nextInt());
        }
    }

    public void process() throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            stageOne();
            stageTwo();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting now .... ");

        final Example4_Synchronized_Blocks obj = new Example4_Synchronized_Blocks();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    obj.process();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    obj.process();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Long start = System.currentTimeMillis();
        t1.start();
        t2.start();
        t1.join(); t2.join();
        Long end = System.currentTimeMillis();

        System.out.println("Time elapsed : "+ (end-start));
        System.out.println("List1 count : "+ obj.list1.size() +", List2 count : "+ obj.list2.size());

    }
}
