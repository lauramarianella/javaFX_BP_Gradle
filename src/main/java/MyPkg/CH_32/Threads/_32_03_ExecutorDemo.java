package MyPkg.CH_32.Threads;

import java.util.concurrent.*;

public class _32_03_ExecutorDemo {
  public static void main(String[] args) {
    // Create a fixed thread pool with maximum three threads
    ExecutorService executor = Executors.newFixedThreadPool(1);//Executors.newCachedThreadPool();//

    // Submit runnable tasks to the executor
    executor.execute(new PrintNum(100));
    executor.execute(new PrintChar('x', 100));
    executor.execute(new PrintChar('y', 100));

    // Shut down the executor
    executor.shutdown();
  }
}