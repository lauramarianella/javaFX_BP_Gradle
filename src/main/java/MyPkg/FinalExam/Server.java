package MyPkg.FinalExam;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static PageGenerator pageGenerator = new PageGenerator();
    
    public static void main(String[] args) {
        // Create a thread pool with two threads
        ExecutorService executor = Executors.newFixedThreadPool(1);
        ListenTask listening = new ListenTask();
        executor.execute(listening);
        executor.shutdown();
    }
    
    public static class ListenTask implements Runnable {
        boolean flag = true;
        @Override//Keep adding an amount to the account
        public void run() {
            ExecutorService executor = Executors.newFixedThreadPool(3);
            try{//Purposely delay it to let the withdraw method proceed
                System.out.println("ListenTask: Server running at localhost...");
                while(flag){
                  System.out.println("ListenTask: Please enter a command... ");
                  Scanner input = new Scanner(System.in);
                  String strCommand = input.nextLine();

                  System.out.println("ListenTask: \t\t\tThe command entered is " + strCommand);
                  switch(strCommand) {
                      case "exit":
                          flag = false;
                          System.out.println("ListenTask: Server shutdown...");
                          break;
                  }
                  Thread.sleep(2000);
                }
            }catch (InterruptedException ex) {
              ex.printStackTrace();
            }
            executor.shutdown();
        }
    }

    public static class WriteTask implements Runnable{
        String text = "";
        public WriteTask(String text){
            this.text = text;
        }
        
        @Override//Keep adding an amount to the account
        public void run() {
            System.out.println("\t\t\tWriteTask: Writing");
            pageGenerator.write(text);
        }
    }

    public static class ReadTask implements Runnable{
        @Override//Keep adding an amount to the account
        public void run() {
            System.out.println("\t\t\tReadTask: Reading");
            System.out.println("\t\t\tReadTask:" + pageGenerator.read());
        }
    }
    
    
    private static class PageGenerator {
        private static String path = "C:\\Users\\laura\\NetBeansProjects\\CH17InputIO\\";
        private static String name = "page.html";
        
        File file = new File(path + name);
        private IOReadDataStream read = new IOReadDataStream(file);
        private IOWriteDataStream write = new IOWriteDataStream(file);

        public String read(){
            String text="";

            return text;
        }

        public void write(String text) {

        }
    }
}