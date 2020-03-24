package com.leetcode.test;

/**
 * @author tailor
 * @create 2020/3/23 - 14:08
 * @mail wql2014302721@gmail.com
 */

import java.util.ListIterator;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while(prev.next != null){
            if(prev.next.val == val){
                prev.next = prev.next.next;
            }else{
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }
}
class Solution2 {
    public ListNode removeElements(ListNode head, int val) {
        // 比较头节点
        while (head!=null && head.val == val){
            head = head.next;
        }
        if(head == null){
            return null;
        }
        ListNode cur = head;
        while(cur.next!=null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return head;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution3 {
    public int removeElement(int[] nums, int val) {
        int len = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                if (i + 1 < nums.length)
                    nums[len] = nums[i];
            } else {
                len++;
            }
        }
        return len;
    }


    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
        System.out.println(new Solution3().removeElement(nums, val));
    }
}
// 使用递归解决链表的删除问题
class Solution4{
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        head.next = removeElements(head.next, val);
        if(head.val == val)
            return head.next;
        else{
            return head;
        }
    }
}