/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai11;



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
    
    public static int fibonacci(int n) {
        if (n < 0) {
            return -1;
        } else if (n == 0 || n == 1) {
            return n;
        } else return fibonacci(n -1 ) + fibonacci(n - 2);
    }
}
