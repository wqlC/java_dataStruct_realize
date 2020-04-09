package com.leetcode.test;
import java.util.*;

/**
 * @author tailor
 * @create 2020/4/9 - 20:25
 * @mail wql2014302721@gmail.com
 */
public class CheckPermutation {
    public boolean checkPermutation(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();
        for(int i=0; i<s1.length(); i++){
            if(s1Map.keySet().contains(s1.charAt(i))){
                s1Map.put(s1.charAt(i), s1Map.get(s1.charAt(i))+1);
            }else{
                s1Map.put(s1.charAt(i), 1);
            }
            if(s2Map.keySet().contains(s2.charAt(i))){
                s2Map.put(s2.charAt(i), s2Map.get(s2.charAt(i))+1);
            }else{
                s2Map.put(s2.charAt(i), 1);
            }
        }

        Set<Character> keySet = s1Map.keySet();
        for (Character key: keySet){
            if(!s2Map.containsKey(key)){
                return false;
            }
            if(!(s1Map.get(key).equals(s2Map.get(key)))){
                continue;
            }
        }
        return s1Map.size()==s2Map.size();
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "bca";
        System.out.println(new CheckPermutation().checkPermutation(s1, s2));
    }
}
