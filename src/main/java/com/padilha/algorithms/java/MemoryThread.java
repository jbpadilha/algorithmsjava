package com.padilha.algorithms.java;

class MyThread implements Runnable {
    String name;
    Thread t;
    MyThread (String threadName){
        name = threadName;
        t = new Thread(this, name);
        System.out.println("New thread: " + t);
        t.start();
    }

    public void run() {
        try {
            for(int i = 5; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e) {
            System.out.println(name + "Interrupted");
        }
        System.out.println(name + " exiting.");
    }
}

public class MemoryThread {

    public static void runMultipleThread() {
        System.out.println(Thread.currentThread().getName() + ": RunnableTest");
        Runnable task1 = () -> System.out.println(Thread.currentThread().getName() + " is running 1");

        Thread thread2 = new Thread(() -> System.out.println(Thread.currentThread().getName() + " is running 2"));

        Runnable task3 = () -> System.out.println(Thread.currentThread().getName() + " is running 3");

        Thread thread1 = new Thread(task1);

        thread1.start();
        thread2.start();

        new Thread(task3).start();
    }

    public static void main(String[] args) {
        runMultipleThread();

        // Multi Thread
        new MyThread("One");
        new MyThread("Two");
        new MyThread("Three");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }
        System.out.println("Main thread exiting.");
    }
}
