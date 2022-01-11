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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        
        ListNode head1 = list1;
        ListNode head2 = list2;
        
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                prev.next = head1;
                head1 = head1.next;
                prev = prev.next;
            } else {
                prev.next = head2;
                head2 = head2.next;
                prev = prev.next;
            }
        }
        
        while (head1 != null) {
            prev.next = head1;
                head1 = head1.next;
                prev = prev.next;
        }
        
        while (head2 != null) {
            
                prev.next = head2;
                head2 = head2.next;
                prev = prev.next;
        }
        
        return dummy.next;
    }
}