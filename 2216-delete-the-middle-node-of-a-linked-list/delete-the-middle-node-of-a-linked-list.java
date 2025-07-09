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
    public ListNode deleteMiddle(ListNode head) {
        ListNode curr= head;
        int size=0;
        ListNode mid=null;
        while(curr!= null ){
            size++;
            curr=curr.next;
        }
        if(size == 1){ return null;}

        curr=head;
        int middile = size/2;
        int idx =0;
        while(idx<middile-1){
            curr=curr.next;
            idx++;
        }
        curr.next=curr.next.next;
        return head;

       

        
    }
}