/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPkg.CH_17.BinaryIO;
import java.io.*;

public class _17_05_TestObjectOutputStream {
  static String path = "C:\\Users\\laura\\NetBeansProjects\\CH17InputIO\\";
  
  public static void main(String[] args) throws IOException {
    try ( // Create an output stream for file object.dat
      ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path + "object.dat"));
    ) {
      // Write a string, double value, and object to the file
      output.writeUTF("John");
      output.writeDouble(85.5);
      output.writeObject(new java.util.Date());
    }
  }
}
