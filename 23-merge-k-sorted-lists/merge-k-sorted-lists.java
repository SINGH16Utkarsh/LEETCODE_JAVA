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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val-b.val);

    for(ListNode head : lists){
        if(head != null){
            pq.add(head);
        }
    }
    ListNode dummy = new ListNode(0);
    ListNode tail = dummy;

    while(!pq.isEmpty()){
        ListNode minNode = pq.remove();
        tail.next=minNode;
        tail = tail.next;

        if(minNode.next != null){
            pq.add(minNode.next);
        }


    }
    return dummy.next;
    }
}