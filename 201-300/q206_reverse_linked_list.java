// =========== 2 solutions =============

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// iterative solution
class Solution {
    public ListNode reverseList(ListNode head) {
        
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        
        while(null != curr)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}

// recursive solution
class Solution {
    public ListNode reverseList(ListNode head) {
        
        if(null == head || null == head.next)
        {
            return head;
        }
        
        ListNode temp =  reverseList(head.next);
        head.next.next = head;
        head.next = null;
        
        return temp;
    }
}