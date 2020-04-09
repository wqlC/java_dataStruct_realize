package com.leetcode.test;

import java.util.*;

/**
 * @author tailor
 * @create 2020/4/8 - 22:42
 * @mail wql2014302721@gmail.com
 */
public class ReverseList {
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public int[] reversePrint(ListNode head) {
        head = reverseList(head);
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while(cur!=null){
            list.add(cur.val);
            cur = cur.next;
        }
        int[] ret = new int[list.size()];
        for(int i=0;i<list.size();i++){
            ret[i] = list.get(i);
        }
        return ret;
    }

    private ListNode reverseList(ListNode head) {
        ListNode temp = null;
        ListNode cur = head;
        ListNode pre = null;
        while(cur!=null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
    public int[] reversePrint2(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while(cur!=null){
            stack.push(cur.val);
            cur = cur.next;
        }
        int size = stack.size();
        int[] ret = new int[size];
        for (int i = 0; i < size; i++) {
            ret[i] = stack.pop();
        }
        return ret;
    }
}
