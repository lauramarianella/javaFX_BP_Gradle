/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPkg.CH_32.Threads;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class _32_11_ParallelMaxLight {
    public static void main(String[] args) {
        // Create a list
        final int N = 11;
        int[] list = new int[N];
        for (int i = 0; i < list.length; i++)
          list[i] = i;

        long startTime = System.currentTimeMillis();
        Integer maximum = max(list);
        System.out.println("\nThe maximal number is " + maximum);
    }
  
    public static int max(int[] list) {
        RecursiveTask<Integer> task = new MaxTask(list, 0, list.length);
        ForkJoinPool pool = new ForkJoinPool();
        return pool.invoke(task);
    }
 
    private static class MaxTask extends RecursiveTask<Integer> {
        private final static int THRESHOLD = 5;
        private int[] list;
        private int low;
        private int high;

        public MaxTask(int[] list, int low, int high) {
            this.list = list;
            this.low = low;
            this.high = high;
        }

        @Override
        public Integer compute() {
            if(high - low <= THRESHOLD) {
                int max = list[0];
                for (int i = low; i < high; i++)
                  if (list[i] > max)
                    max = list[i];
                return new Integer(max);
            }else{
              int mid = (low + high) / 2;
              System.out.println("low: " + low + " - high:" + high + " - mid: " + mid);
              RecursiveTask<Integer> left = new MaxTask(list, low, mid);
              RecursiveTask<Integer> right = new MaxTask(list, mid, high);

              right.fork();
              left.fork(); 
              return new Integer(Math.max(left.join().intValue(), 
                right.join().intValue()));
            }
        }
    }
}