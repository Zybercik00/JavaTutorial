package com.github.zybercik00.hellojava.concurrency;

public class SleepMessage implements Runnable {
    
    @Override
    public void run() {
        String [] importantMessage = {"Ala ma kota", "Kamil tez ma kota", "Kto jeszcze ma kota?"};
        for (int i = 0; i < importantMessage.length; i++) {
            try {
            Thread.sleep(4000);
            } catch (InterruptedException e) {
            return;
            }
            System.out.println(importantMessage[i]);
        }
    }
}
