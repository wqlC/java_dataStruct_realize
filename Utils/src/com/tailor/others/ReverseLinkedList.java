package com.tailor.others;

import java.util.List;

/**
 * @author tailor
 * @create 2020/3/23 - 18:02
 * @mail wql2014302721@gmail.com
 */

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for(int i=1; i<10; i++){
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        getList(head);
        head = reverseListNode(head);
        getList(head);
    }

    private static ListNode reverseListNode(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode temp = null;
        while(cur != null){
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        return prev;
    }

    public static void getList(ListNode head){
        ListNode cur = head;
        while(cur != null){
            System.out.print (cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

}
