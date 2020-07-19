package com.threading.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable{

    private int id;

    public Processor(int id){
        this.id = id;

    }

    @Override
    public void run() {
        System.out.println("Starting thread : " + id);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Completed Thread : " + id);
    }
}

public class Example5_Thread_Pool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
            executorService.submit(new Processor(i));
        }

        executorService.shutdown();
        System.out.println("All Tasks Submitted ");

        executorService.awaitTermination(1, TimeUnit.DAYS);

        System.out.println("All Tasks Completed ");
    }

}
