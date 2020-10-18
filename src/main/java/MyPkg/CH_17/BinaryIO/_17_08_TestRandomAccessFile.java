/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPkg.CH_17.BinaryIO;
import java.io.*;

public class _17_08_TestRandomAccessFile {
    static String path = "C:\\Users\\laura\\NetBeansProjects\\CH17InputIO\\";
    public static void main(String[] args) throws IOException {
        try ( // Create a random access file
          RandomAccessFile inout = new RandomAccessFile(path + "_17_08_inout.dat","rw");
        ) {
            // Clear the file to destroy the old contents if exists
            inout.setLength(0);
            inout.seek(inout.length()); // Move the file pointer to the end
            
            System.out.println("Offset at the beginnig: " + inout.getFilePointer());
            // Write new integers to the file
            for (int i = 0; i < 200; i++)
              inout.writeInt(i);//inout.writeChar((String.valueOf(i).toCharArray())[0]);//inout.writeInt(i);//inout.writeUTF(String.valueOf(i));
            System.out.println("Offset after inserting 200int: " + inout.getFilePointer());
            // Display the current length of the file
            System.out.println("Current file length is " + inout.length());

            // Retrieve the first number
            inout.seek(0); // Move the file pointer to the beginning
            System.out.println("The first number is " + inout.readInt());
            System.out.println("Offset at the first number: " + inout.getFilePointer());
            
            // Retrieve the second number
            //inout.seek(1 * 4); // Move the file pointer to the second number
            System.out.println("The second number is " + inout.readInt());

            // Retrieve the tenth number
            inout.seek(9 * 4); // Move the file pointer to the tenth number
            System.out.println("The tenth number is " + inout.readInt());
            System.out.println("Offset at the tenth number: " + inout.getFilePointer());

            // Modify the eleventh number
            inout.writeInt(555);

            // Append a new number
            inout.seek(inout.length()); // Move the file pointer to the end
            inout.writeInt(999);

            // Display the new length
            System.out.println("The new length is " + inout.length());

            // Retrieve the new eleventh number
            inout.seek(10 * 4); // Move the file pointer to the eleventh number
            System.out.println("The eleventh number is " + inout.readInt());
            System.out.println("Offset a the ekeventh number: " + inout.getFilePointer());
        }
    }
}