# java_dataStruct_realize
learn and realize data_struct with java language
## 数组
- [动态数组的实现](./Array/src/Array.java)
- [使用数组实现栈](./Stack/src/ArrayStack.java)
- [使用数组实现队列](./Queue/src/ArrayQueue.java)
## 链表
- [单链表的实现](./LinkedList/src/LinkedList.java)
- [使用链表实现栈](./LinkedList/src/LinkedListStack.java)
- [使用链表实现队列](./Queue/src/LinkedListQueue.java)
### 链表和递归
[leetcode 203 移除链表元素](https://leetcode-cn.com/problems/remove-linked-list-elements)
>删除链表中等于给定值 val 的所有节点。<br>
 示例:<br>
 输入: 1->2->6->3->4->5->6, val = 6<br>
 输出: 1->2->3->4->5

```java
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
```
使用递归实现上述要求：
```java
class Solution{
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
```