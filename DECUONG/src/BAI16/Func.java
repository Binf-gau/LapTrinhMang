/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author TIEN
 */
public class Func {

    private static List<Integer> list = new ArrayList<>();
    private static boolean isSort = false;

    public static void init(List<Integer> arr) {
        list.clear();
        list.addAll(arr);
    }

    public static String maxAndIndex() {
        Collections.sort(list);
        StringBuilder builder = new StringBuilder();
        int max = list.get(list.size() - 1);
        int pos = list.size() - 1;
        
        
        
        builder.append("Phần tử lớn nhất ").append(max).append(" vị trí ").append(pos).append("\n");
        for (int i = list.size() - 2; i >= 0; i--) {
            // If the element is not
            // equal to largest element
            if (list.get(i) != max) {
                builder.append("Phần tử lớn thứ 2 ").append(list.get(i)).append(" vị trí ").append(i).append("\n");
                break;
            }
        }
        return builder.toString();
    }

    public static String sortDec() {
        if (!isSort) {
            Collections.reverse(list);
            isSort = true;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            builder.append(list.get(i)).append(' ');
        }
        return builder.toString();
    }

    public static String insert(int so) {
        list.add(so);
        Collections.sort(list);
        Collections.reverse(list);
        StringBuilder builder = new StringBuilder();
        list.forEach(item -> builder.append(item).append(' '));
        return builder.toString();
    }
}
