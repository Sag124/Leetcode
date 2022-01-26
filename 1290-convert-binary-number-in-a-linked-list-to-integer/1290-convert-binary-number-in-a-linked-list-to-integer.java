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
    public int getDecimalValue(ListNode head) {
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        System.out.println(size);
        
        //3 
        int ans = 0;
        cur = head;
        for (int i = size - 1; i >= 0; i--) {
            ans += cur.val * (int)Math.pow(2, i);
            cur = cur.next;
        }
        return ans;
    }
}