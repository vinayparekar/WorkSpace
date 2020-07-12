package com.threading.example;

public class Example3 {

    public static volatile int counter=0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                increment();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Counter Value: " + counter);
    }

    public static synchronized void increment(){
        for(int i=0;i<1000;i++) {
            counter++;
        }
    }


}
