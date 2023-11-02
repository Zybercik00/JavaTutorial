package com.github.zybercik00.hellojava.concurrency;

public class ThreadMessage {
    
    public void printThreadMessage(String message) {
        String threadName = Thread.currentThread().getName();
        System.out.format("%n%s: %n%s%n%n", threadName, message);
    }
}
