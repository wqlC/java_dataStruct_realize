package com.leetcode.test;

/**
 * @author tailor
 * @create 2020/4/8 - 22:38
 * @mail wql2014302721@gmail.com
 */
public class ReplaceSpace {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if(' ' == c){
                sb.append("%20");
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "We are happy.";
        System.out.println(new ReplaceSpace().replaceSpace(str));
    }
}
