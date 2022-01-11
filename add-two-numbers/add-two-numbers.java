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
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode fwd = cur.next;
            cur.next = prev;
            prev = cur;
            cur = fwd;
        }
        return prev;   
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1 != null ? l1 : l2;
        ListNode c1 = (l1);
        ListNode c2 = (l2);
        
        ListNode head = new ListNode(-1);
        ListNode itr = head;
        
        int carry = 0;
        
        while (c1 != null || c2 != null || carry != 0) {
            int sum = carry + (c1 != null ? c1.val : 0) + (c2 != null ? c2.val : 0);
            int ld = sum % 10;
            carry = sum / 10;
            
            itr.next = new ListNode(ld);
            itr = itr.next;
            if (c1 != null) c1 = c1.next;
            if (c2 != null) c2 = c2.next;
        }
        
        return (head.next);
    }
}