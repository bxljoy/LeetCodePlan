package com.alexbao.leetcode5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class FindAllNumbersDisappearedInArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            set1.add(nums[i]);
            set2.add(i+1);
        }
        set2.removeAll(set1);
        Iterator<Integer> iterator = set2.iterator();
        while (iterator.hasNext()) {
            res.add(iterator.next());
        }
        return res;
    }
}