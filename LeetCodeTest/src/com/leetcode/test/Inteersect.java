package com.leetcode.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author tailor
 * @create 2020/3/26 - 17:07
 * @mail wql2014302721@gmail.com
 */
class Inteersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new TreeMap<>();
        for(int num : nums1){
            if(!map.keySet().contains(num)){
                map.put(num, 1);
            }else{
                map.put(num, map.get(num)+1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int num: nums2){
            if(map.keySet().contains(num)){
                list.add(num);
                map.put(num, map.get(num)-1);
                if(map.get(num) == 0){
                    map.remove(num);
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}