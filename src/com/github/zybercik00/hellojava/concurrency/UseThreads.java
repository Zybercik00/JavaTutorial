package com.github.zybercik00.hellojava.concurrency;

public class UseThreads implements Runnable {

    public static void main(String[] args) {
        Thread useThreads = new Thread(new UseThreads());
        useThreads.start();
    }

    @Override
    public void run() {
        System.out.println("Hello from thread");
    }
    
}
