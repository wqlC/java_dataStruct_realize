package com.tailor.others;

/**
 * @author tailor
 * @create 2020/3/23 - 18:29
 * @mail wql2014302721@gmail.com
 */
public class Palindrome {
    private class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }
    public boolean isPalindrome(ListNode head) {
        ListNode firstEnd = getFirstEnd(head);
        ListNode SecondStart = firstEnd.next;
        ListNode SecondHead = reverse(SecondStart);
        ListNode p1 = head;
        ListNode p2 = SecondHead;
        boolean result = true;
        while(result && p2!=null){
            if(p1.val!=p2.val){
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        firstEnd.next = reverse(SecondHead);
        getList(head);
        return result;
    }

    private ListNode getFirstEnd(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public ListNode reverse(ListNode head){
        ListNode cur = head;
        ListNode prev = null;
        ListNode temp = null;
        while(cur!=null){
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        getList(prev);
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

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        ListNode head = palindrome.new ListNode(-1);
        ListNode cur = head;
        for(int i=0; i<10; i++){
            cur.next = palindrome.new ListNode(i);
            cur = cur.next;
        }
        for(int i=10; i>=0; i--){
            cur.next = palindrome.new ListNode(i);
            cur = cur.next;
        }
        getList(head.next);
        System.out.println(palindrome.isPalindrome(head.next));
    }
}
