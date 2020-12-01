/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPkg.CH_32.Threads;

import java.util.Timer;
import java.util.TimerTask;

/*public class Test implements Runnable {
    public static void main(String[] args) {
        Test t = new Test();
    }
    public Test() {
        //Test task = new Test();
        Thread t = new Thread(this);
        t.start();
    }
    public void run() {
        System.out.println("test");
    }
}*/

/*public class Test implements Runnable {
    public static void main(String[] args) {
        new Test();
    }
    public Test() {
        Thread t = new Thread(this);
        t.start();
        t=null;
        t = new Thread(this);
        t.start();
    }
    public void run() {
        System.out.println("test");
    }
}*/

public class Test {
    private static volatile boolean running = true;
    private static Object object;
    public static void main(String... args) throws InterruptedException {
        Timer timer = new Timer(true);
        timer.schedule(new TimerTask(){
            @Override
            public void run(){
                running = false;
            }
        }, 1000);
        Runnable task = () ->{
            //System.out.println("test");
        };
        long count = 0;
        while(running){
            Thread thread = new Thread(task);
            thread.start();
            thread.join();
//            object = new Object();
            count++;
        }
        System.out.println("count = " + count);
    } 
}