/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPkg.CH_17.BinaryIO;
import java.io.*;

public class _17_04_Copy {
  /** Main method
     @param args[0] for source file 
     @param args[1] for target file
     * @throws java.io.IOException
   */
  public static void main(String[] args) throws IOException { 
    // Check command-line parameter usage
    /*if (args.length != 2) { 
      System.out.println(
        "Usage: java Copy sourceFile targetfile");
      System.exit(1);
    }*/

    // Check if source file exists
    String path = "C:\\Users\\laura\\NetBeansProjects\\CH17InputIO\\";
//    String nameOri = "Outline_ORI.pdf";
//    String nameCopy = "Outline_FIN.pdf";
    String nameOri = "MyTxt.txt";
    String nameCopy = "MyTxtFinal.txt";
    
    File sourceFile = new File(path + nameOri);//new File(args[0]);
    if (!sourceFile.exists()) {
       System.out.println("Source file " + nameOri + " does not exist");
       System.exit(2);
    }

    // Check if target file exists
    File targetFile = new File(path + nameCopy);//new File(args[1]);
    if (targetFile.exists()) {
      System.out.println("Target file " + nameCopy + " already exists");
      System.exit(3);
    }

    try (
      // Create an input stream
      BufferedInputStream input = new BufferedInputStream(new FileInputStream(sourceFile));
  
      // Create an output stream
      BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(targetFile));
    ) {
      // Continuously read a byte from input and write it to output
      int r, numberOfBytesCopied = 0;
      while ((r = input.read()) != -1) {
        output.write((byte)r);
        numberOfBytesCopied++;
      }

      // Display the file size
      System.out.println(numberOfBytesCopied + " bytes copied");
    }
  }
}