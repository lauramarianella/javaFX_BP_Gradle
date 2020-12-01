/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPkg.CH_32.Threads;

/**
 *
 * @author laura
 */
public class SimpleRecursive {
    public static void main(String[] args) {
        SimpleRecursive sr = new SimpleRecursive();
        sr.myRecursive2(5);
    }
    
    public int myRecursive(int i) {
        System.out.println(i + " execution");
        if(i==0){
            return i;
        }else{
            return myRecursive(--i);    
        }
    }
    
    
    public int myRecursive2(int i) {
        int j;
        if(i==0){
            System.out.println(i + " current");
            return i;
        }else{
            System.out.println(i + " current");
            myRecursive2(--i);
            System.out.println(i+ " next");
            return i;
        }
    }
}
