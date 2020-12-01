/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPkg.CH_32.Threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccountLockCooperation {
    private double balance;
    private Lock lock = new ReentrantLock();//Create a lock
    private Condition newDeposit = lock.newCondition();//Create a condition
    
    public BankAccountLockCooperation(double initial) {
        balance = initial;
    }
    public void deposit(double amount) {
        lock.lock();//Acquire the lock
        try{
            balance = balance + amount;
            newDeposit.signalAll();//Signal thread waiting on the condition
        }catch(Exception e){
        }finally{
            lock.unlock();//Release the lock
        }
    }
    public void withdraw(double amount) {
        lock.lock();//Acquire the lock
        try{
            while (balance < amount) {
                newDeposit.await();
            }
            balance = balance - amount;
        }catch(Exception e){
        }finally{
            lock.unlock();//Release the lock
        }
    }
}
