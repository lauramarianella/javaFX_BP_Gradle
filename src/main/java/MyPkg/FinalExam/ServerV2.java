package MyPkg.FinalExam;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerV2 {//without Scan class working
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
        ArrayList<String> alStrCommands = new ArrayList<String>(Arrays.asList("exit","write", "read", "read"));
                 
        @Override//Keep adding an amount to the account
        public void run() {
            ExecutorService executor = Executors.newFixedThreadPool(3);
            try{//Purposely delay it to let the withdraw method proceed
                System.out.println("ListenTask: Server running at localhost...");
                while(!alStrCommands.isEmpty() && flag) {
                    System.out.println("ListenTask: Please enter a command... ");
                    String strCommand = alStrCommands.get(alStrCommands.size()-1);
                    alStrCommands.remove(alStrCommands.size()-1);

                    System.out.println("ListenTask: \t\t\tThe command entered is " + strCommand);
                    Thread.sleep(5000);
                    switch(strCommand) {
                        case "exit":
                            flag = false;
                            System.out.println("ListenTask: Server shutdown...");
                            break;
                    }
                    
                }
                executor.shutdown();
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
