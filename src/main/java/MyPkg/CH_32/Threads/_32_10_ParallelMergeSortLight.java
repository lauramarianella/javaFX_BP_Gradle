/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPkg.CH_32.Threads;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;


public class _32_10_ParallelMergeSortLight {
    public static void main(String[] args) {
        int[] list1 = {7,3,2,16,24,4,11,9};
        parallelMergeSort(list1); // Invoke parallel merge sort
   }

    public static void parallelMergeSort(int[] list) {
        RecursiveAction mainTask = new SortTask(list);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(mainTask);
        System.out.println("Ordered list: " + list.toString());
        // for each loop 
        for(int num : list){ 
            System.out.println(num);
        } 
    }

    private static class SortTask extends RecursiveAction {
        private int[] list;

        SortTask(int[] list) {
            this.list = list;
        }

        @Override
        protected void compute() {
            if (list.length == 1)
                return;
            else{
                // Obtain the first half
                int[] firstHalf = new int[list.length / 2];
                System.arraycopy(list, 0, firstHalf, 0, list.length / 2);

                // Obtain the second half
                int secondHalfLength = list.length - list.length / 2;
                int[] secondHalf = new int[secondHalfLength];
                System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);

                // Recursively sort the two halves
                invokeAll(new SortTask(firstHalf),new SortTask(secondHalf));

                // Merge firstHalf with secondHalf into list
                MergeSort.merge(firstHalf, secondHalf, list);
            }
        }
    }
}