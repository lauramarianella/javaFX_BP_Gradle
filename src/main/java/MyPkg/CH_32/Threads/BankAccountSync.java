/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPkg.CH_32.Threads;

public class BankAccountSync {
    private double balance;
    public BankAccountSync(double initial) {
        balance = initial;
    }
    public synchronized void deposit(double amount) {
        balance = balance + amount;
    }
    public void withdraw(double amount) {
        deposit(-amount);
    }
}
