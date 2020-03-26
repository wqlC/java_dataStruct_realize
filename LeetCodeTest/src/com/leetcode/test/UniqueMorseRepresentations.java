package com.leetcode.test;
import java.util.*;
/**
 * @author tailor
 * @create 2020/3/26 - 11:07
 * @mail wql2014302721@gmail.com
 */
public class UniqueMorseRepresentations {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> morseSet = new TreeSet<>();

        for(String word:words){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                sb.append(codes[word.charAt(i)-'a']);
            }
            morseSet.add(sb.toString());
            sb = null;
        }
        return morseSet.size();
    }

    public static void main(String[] args) {

    }
}
