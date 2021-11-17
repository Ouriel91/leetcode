// =========== 2 solutions =============

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

//may the two lists are not in the same length 
//so what we do we count the lengths of the lists
//and make sure that two pointers start where is no diffrence between them.
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode first = headA;
        ListNode second = headB;
        int len1 = 0;
        int len2 = 0;
        
        while(null != first)
        {
            ++len1;
            first = first.next;
        }
        
        while(null != second)
        {
            ++len2;
            second = second.next;
        }
        
        first = headA;
        second = headB;
        
        if(len1 > len2)
        {
            for(int i=0; i<len1-len2;++i)
            {
                first = first.next;
            }
        }
        else
        {
            for(int i=0; i<len2-len1; ++i)
            {
                second = second.next;
            }
        }
        
        //stop when have intersection or have no intersection (one pointer reach to end of his list)
        while(first != second)
        {
            first = first.next;
            second = second.next;
        }
        
        return first;
    }
}

//based on the same idea above
//but now we don't check the length of the lists
//when one pointer reach to end of the list we return it back to the beginning of other list
//so in the in the end the two pointers start where is no diffrence between them.
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode first = headA;
        ListNode second = headB;
        
        if((null == first) || (null == second))
        {
            return null;
        }
        
        while(first != second)
        {
            first = first.next;
            second = second.next;
            
            if(first == second)
            {
                return first;
            }
            
            if(null == first)
            {
                first = headB;
            }
            
            if(null == second)
            {
                second = headA;
            }
        }
        
        return first;
    }
}
