package MyPkg.CH_32.Threads;

import java.util.concurrent.*;

public class ProducerConsumer {
    private int a = 1;
    public ProducerConsumer() {
    }
    public synchronized void producer() {
        //do something
        notifyAll();
    }
    public synchronized void consumer(int x) {
        try {
          while(a>x)//here you condition
            wait();
        }catch (InterruptedException ex) {
          ex.printStackTrace();
        }
        //add code if 
    }
}
