/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPkg.CH_32.Threads;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;


public class _32_05_AccountWithSyncUsingLock {
    private static Account account = new Account();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        // Create and launch 100 threads
        for (int i = 0; i < 100; i++) {
          executor.execute(new AddAPennyTask());
        }
        executor.shutdown();
        // Wait until all tasks are finished
        while (!executor.isTerminated()) {
        }
        System.out.println("What is balance ? " + account.getBalance());
    }

    // A thread for adding a penny to the account
    public static class AddAPennyTask implements Runnable {
        public void run() {
          account.deposit(1);
        }
    }

    // An inner class for account
    public static class Account {
        private Lock lock = new ReentrantLock(); // Create a lock
        private int balance = 0;

        public int getBalance() {
            return balance;
        }

        public void deposit(int amount) {
            lock.lock(); // Acquire the lock
            try {
                int newBalance = balance + amount;
                // This delay is deliberately added to magnify the
                // data-corruption problem and make it easy to see.
                Thread.sleep(5);
                balance = newBalance;
                System.out.println("balance? " + balance);
            }catch (InterruptedException ex) {
            }finally {
              lock.unlock(); // Release the lock
            }
        }
    }
}