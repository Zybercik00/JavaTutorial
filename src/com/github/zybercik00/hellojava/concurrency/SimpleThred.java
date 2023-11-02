package com.github.zybercik00.hellojava.concurrency;

public class SimpleThred {

    
    public static void main(String[] args) throws InterruptedException {
        ThreadMessage threadMessage = new ThreadMessage();
        SleepMessage sleepMessage = new SleepMessage();
        long patience = 1000 * 60 * 60;
        
        if (args.length > 0) {
            try {
                patience = Long.parseLong(args[0]) * 1000;
            } catch (NumberFormatException e) {
                System.err.println("Argument must be an integer.");
                System.exit(1);
            }
        }
        threadMessage.printThreadMessage("\nOdpalamy wątek MessageLoop");
        long startTime = System.currentTimeMillis();
        Thread threadMessageLoop = new Thread(new SleepMessage());
        threadMessageLoop.start();

        threadMessage.printThreadMessage("\nCzekamy az wątek MessageLoop zakończy");
        while (threadMessageLoop.isAlive()) {
            threadMessage.printThreadMessage("\nCiągle czekamy....");
            threadMessageLoop.join(1000);
            if ((System.currentTimeMillis() - startTime) > patience && threadMessageLoop.isAlive()) {
                threadMessage.printThreadMessage("\nZmęczeni czekaniem");
                threadMessageLoop.interrupt();
                threadMessageLoop.join();
            }
        }
        threadMessage.printThreadMessage("\nNo w końcu!");

    }

}
