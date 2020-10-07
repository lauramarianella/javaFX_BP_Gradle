/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPkg.CH_17.BinaryIO;
import java.io.*;

public class _17_07_TestObjectStreamForArray {
    static String path = "C:\\Users\\laura\\NetBeansProjects\\CH17InputIO\\";
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        int[] numbers = {1, 2, 3, 4, 5};
        String[] strings = {"John", "Susan", "Kim"};

        try ( // Create an output stream for file array.dat
          ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("_17_07_array.dat", true));
        ) {
            // Write arrays to the object output stream
            output.writeObject(numbers);
            output.writeObject(strings);
        }

        try ( // Create an input stream for file array.dat
          ObjectInputStream input = new ObjectInputStream(new FileInputStream("_17_07_array.dat"));
        ) {
            int[] newNumbers = (int[])(input.readObject());
            String[] newStrings = (String[])(input.readObject());

            // Display arrays
            for (int i = 0; i < newNumbers.length; i++)
              System.out.print(newNumbers[i] + " ");
            System.out.println();

            for (int i = 0; i < newStrings.length; i++)
              System.out.print(newStrings[i] + " ");
        }
    }
}