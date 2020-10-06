/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPkg.CH_17.BinaryIO;
import java.io.*;

public class _17_02_TestDataStream {
  static String path = "C:\\Users\\laura\\NetBeansProjects\\CH17InputIO\\";
  public static void main(String[] args){
    try{
        try( // Create an output stream for file temp.dat
            DataOutputStream output = new DataOutputStream(new FileOutputStream(path + "temp02.dat"));
           ) {
                // Write student test scores to the file
                output.writeUTF("John");
                output.writeDouble(85.5);
                output.writeUTF("Jim");
                output.writeDouble(185.5);
                output.writeUTF("George");
                output.writeDouble(105.25);

                //write something -->read other type
                output.writeChar('c');
                output.writeDouble(105.25);
                output.writeDouble(105.25);
                output.writeChars("12ABC56");
                
            }

          try ( // Create an input stream for file temp.dat
                DataInputStream input = new DataInputStream(new FileInputStream(path + "temp02.dat"));
            ) {
                // Read student test scores from the file
                if(input.available() != 0) System.out.println(input.readUTF() + " " + input.readDouble());
                if(input.available() != 0) System.out.println(input.readUTF() + " " + input.readDouble());
                if(input.available() != 0) System.out.println(input.readUTF() + " " + input.readDouble());
                
                if(input.available() != 0) System.out.println(input.readChar());
                if(input.available() != 0) System.out.println(input.readFloat());
                if(input.available() != 0) System.out.println(input.readDouble());
                if(input.available() != 0) System.out.println(input.readLine());//Deprecated
                
                System.out.print(input.readUTF());
            }
    }catch(EOFException e){
      System.out.print("EOF(End of File): You have to check if you already reach the end before READING... " + e.toString());
    }catch(IOException e){
        e.printStackTrace();
    }
  }
}