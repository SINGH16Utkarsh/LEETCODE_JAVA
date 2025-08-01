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
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=0;
        ListNode tempA=headA;
        while(tempA!=null){
            lenA++;
            tempA=tempA.next;
        }
        int lenB=0;
        ListNode tempB=headB;
        while(tempB!=null){
            lenB++;
            tempB=tempB.next;
        }
        //check difference

        int diff = Math.abs(lenA-lenB);

        tempA=headA;
        tempB=headB;

        if(lenA > lenB){
            while(diff-->0){
                tempA=tempA.next;
            }
        }
        else{
               while(diff-->0){
                tempB=tempB.next;
            }
        }
       //CHECK FOR EQUALITY

      

       while(tempA != tempB){
        tempA=tempA.next;
        tempB= tempB.next;
        if(tempA == null || tempB==null){
            return null;
        }
       }
     return tempB;
        
    }
}