/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPkg.CH_32.Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class _32_06_ThreadCooperation {
    private static Account account = new Account();

    public static void main(String[] args) {
        // Create a thread pool with two threads
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new DepositTask());
        executor.execute(new WithdrawTask());
        executor.shutdown();

        System.out.println("Thread 1\t\tThread 2\t\tBalance");
    }

    public static class DepositTask implements Runnable {
        @Override//Keep adding an amount to the account
        public void run() {
            try{//Purposely delay it to let the withdraw method proceed
              while(true) {
                account.deposit((int)(Math.random() * 10) + 1);
                Thread.sleep(1000);
              }
            }catch (InterruptedException ex) {
              ex.printStackTrace();
            }
        }
    }

    public static class WithdrawTask implements Runnable {
      @Override//Keep subtracting an amount from the account
      public void run(){
          while (true) {
              account.withdraw((int)(Math.random() * 10) + 1);
          }
      }
    }

    //An inner class for account
    private static class Account {
        private static Lock lock = new ReentrantLock();//Create a new lock
        private static Condition newDeposit = lock.newCondition();//Create a condition
        private int balance = 0;

        public int getBalance() {
            return balance;
        }

        public void withdraw(int amount) {
            lock.lock();//Acquire the lock
            try {
                while (balance < amount) {
                    System.out.println("\t\t\tWait for a deposit");
                    newDeposit.await();
                }

                balance -= amount;
                System.out.println("\t\t\tWithdraw " + amount + "\t\t" + getBalance());
            }catch (InterruptedException ex) {
                ex.printStackTrace();
            }finally {
                lock.unlock();//Release the lock
            }
        }

        public void deposit(int amount) {
            lock.lock();//Acquire the lock
            try {
              balance += amount;
              System.out.println("Deposit " + amount + "\t\t\t\t\t" + getBalance());
              newDeposit.signalAll();//Signal thread waiting on the condition
            }finally {
              lock.unlock();//Release the lock
            }
        }
    }
}