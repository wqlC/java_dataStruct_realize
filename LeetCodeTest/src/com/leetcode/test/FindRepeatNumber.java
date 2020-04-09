package com.leetcode.test;

import java.util.*;

class Solution {
    public int findRepeatNumber(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!map.keySet().contains(nums[i])){
                map.put(nums[i], 1);
            }else{
                return nums[i];
            }
        }
        return -1;
    }
}