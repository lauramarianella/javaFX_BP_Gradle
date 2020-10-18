/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPkg.CH_17.BinaryIO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class _17_ReadObject {
    static String path = "C:\\Users\\laura\\NetBeansProjects\\CH17InputIO\\tests\\";
    
    public static void main(String[] args) throws IOException {
        try (
          ObjectInputStream input = new ObjectInputStream(new FileInputStream(path + "17_WriteObject.dat"));
        ) {
            Object obj;
            while(! ((obj = input.readObject()) instanceof _17_EOFClass) ){
                System.out.println(obj);
            }

        }catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
