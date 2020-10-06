/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPkg.CH_17.BinaryIO;
import java.io.*;

public class _17_01_TestFileStream {
  static String path = "C:\\Users\\laura\\NetBeansProjects\\CH17InputIO\\";
  public static void main(String[] args) throws IOException {
    try (
        // Create an output stream to the file
        FileOutputStream output = new FileOutputStream(path + "temp01.dat");
    ){
        // Output values to the file
        for (int i = 0; i <= 10; i++)
          output.write(i);
        
        output.write(2147483647);
        
        byte[] ascii_a = "a".getBytes("UTF-8");
        output.write(ascii_a);// platform's default charset=97
        
        output.write("b".getBytes());// platform's default charset=[98]
        
        byte[] ascii_string = "xyz".getBytes();
        output.write(ascii_string);// platform's default charset=[120,121,122]
        
        byte[] ascii_1 = "1".getBytes();
        output.write(ascii_1);// platform's default charset=[49]
        
        
    }

    try (
      // Create an input stream for the file
      FileInputStream input = new FileInputStream(path + "temp01.dat");
    ){
        // Read values from the file
        int value;
        while ((value = input.read()) != -1)
          System.out.print(value + " ");
    }
  }
}
