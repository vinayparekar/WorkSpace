package com.threading.example;

public class Example2_ThreadCreation_Runnable {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runner1());
        Thread t2 = new Thread( new Runner1());
        t1.start();
        t2.start();

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i< 10 ; i++) {
                    System.out.println("New Hello from : "+ i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t3.start();
    }
}

class Runner1 implements Runnable{
    @Override
    public void run() {
        for(int i=0; i< 10 ; i++) {
            System.out.println("Hello from : "+ i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
