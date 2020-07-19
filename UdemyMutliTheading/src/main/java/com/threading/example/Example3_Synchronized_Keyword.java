package com.threading.example;

public class Example3_Synchronized_Keyword {

    public static volatile int counter=0;
    // The Java volatile keyword is used to mark a Java variable as "being stored in main memory".
    // every read of a volatile variable will be read from the computer's main memory, and not from the CPU cache
    // every write to a volatile variable will be written to main memory, and not just to the CPU cache.
    // The Java volatile keyword guarantees visibility of changes to variables across threads.
    // In a multithreaded application where the threads operate on non-volatile variables, each thread may copy variables from main memory into a CPU cache while working on them, for performance reasons.
    // If your computer contains more than one CPU, each thread may run on a different CPU. That means, that each thread may copy the variables into the CPU cache of different CPUs.


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
        // join() method will halt current thread in this case main thread untill execution of t1 and t2 threads is complete.

        System.out.println("Counter Value: " + counter);
    }

    public static synchronized void increment(){
        for(int i=0;i<1000;i++) {
            counter++; // ++ operation is not atomic as it is : count = counter +1 , so to get proper increment it is being used in synchronized block.
        }
    }


}
