/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPkg.CH_32.Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _32_04_AccountWithSyncDemoBlockingObject {
    private static Account account = new Account();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newScheduledThreadPool(200);
        // Create and launch 100 threads
        for (int i = 0; i < 100; i++) {
            executor.execute(new AddAPennyTask());
            executor.execute(new CheckObjectBlock());
        }
        executor.shutdown();
        // Wait until all tasks are finished
        while (!executor.isTerminated()) {
        }
        System.out.println("What is balance? " + account.getBalance());
    }

    // A thread for adding a penny to the account
    private static class AddAPennyTask implements Runnable {       
        public void run() {
            account.deposit(1);
        }
    }

    // An inner class for account
    private static class Account {
        private int balance = 0;

        public int getBalance() {
            return balance;
        }
        public void isBlocked(){
            try {
                System.out.println("executing...");
                Thread.sleep(800);
            }catch (InterruptedException ex) {}
        }
        
        public synchronized void deposit(int amount) {
            System.out.println("Ini? ");
            int newBalance = balance + amount;
            
            // This delay is deliberately added to magnify the
            // data-corruption problem and make it easy to see.
            try {
              Thread.sleep(500);
            }catch (InterruptedException ex) {}

            balance = newBalance;
            System.out.println("myBalance? " + balance);
         }
    }
    
    private static class CheckObjectBlock implements Runnable {
        public void run() {
            account.isBlocked();
        }
    }

}