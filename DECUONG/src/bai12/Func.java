/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai12;

import java.util.ArrayList;
import java.util.List;



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
    
    public static int sum(int n){
       int sum = 0;
       while(n > 0){
           sum += n % 10;
           n /= 10;
       }
       return sum;
    }
    
    public static String factor(int n) {
        StringBuilder builder = new StringBuilder();
        List<Integer> arr = new ArrayList<>();
        
        for (int i = 1; i <= n ; i++) {
            if(n % i == 0) arr.add(i);
        }
        arr.stream().filter((integer) -> (isPrime(integer))).forEach(i -> builder.append(i).append(' '));
        return builder.toString();
    }
}
