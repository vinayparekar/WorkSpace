package com.threading.example;

public class Example1 {
    public static void main(String[] args) {

        Runner r1 = new Runner();
        r1.start();

        Runner r2 = new Runner();
        r2.start();
    }
}

class Runner extends Thread{
    @Override
    public void run() {
        super.run();
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
