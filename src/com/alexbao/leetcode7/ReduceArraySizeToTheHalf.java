package com.alexbao.leetcode7;

import java.util.*;

public class ReduceArraySizeToTheHalf {
    public int minSetSize(int[] arr) {
        int size = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<size; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        List<Integer> frequent = new ArrayList<>();
        for (int value : map.values()) {
            System.out.println(value);
            frequent.add(value);
        }
        Collections.sort(frequent, Collections.reverseOrder());
        int res = 0;
        for (int num : frequent) {
            if (size > arr.length/2) {
                size -= num;
                res++;
            } else {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ReduceArraySizeToTheHalf app = new ReduceArraySizeToTheHalf();
        int[] arr = {3,3,3,3,5,5,5,2,2,7};
        app.minSetSize(arr);
    }
}
