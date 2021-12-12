/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai13;


/**
 *
 * @author TIEN
 */
public class Func {
    public static boolean isPrime(int n){
        if(n < 2 ) return false;
        else if(n == 2) return true;
        else {
            for (int i = 2; i < n; i++) {
                if(n % i == 0) return false;
            }
        }
        return true;
    }
    
    public static String uocso(int n){
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= n ; i++) {
            if(n % i == 0) builder.append(i).append(' ');
        }
        return builder.toString();
    }
    
    public static String uocsolasonguyento(int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= n ; i++) {
            if(n % i == 0 && isPrime(i)) builder.append(i).append(' ');
        }
        return builder.toString();
    }
}
