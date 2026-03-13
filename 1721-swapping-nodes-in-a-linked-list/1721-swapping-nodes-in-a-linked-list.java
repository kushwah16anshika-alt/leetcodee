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
    public ListNode swapNodes(ListNode head, int k)
    {
        ListNode first = head;
        ListNode second = head;
        ListNode temp = head;
        int len=0;
        ListNode curr=head;
        //step 1 find len
        while(curr!=null)
        {
            curr=curr.next;
            len++;
        }
        //step 2 find kth node 
        for(int i = 1; i < k; i++)
          {
            first = first.next;
          }
        
    
        //step 3 find kth node from the begining
         for(int i = 1; i < (len - k + 1); i++)
          {
            second=second.next;
          }
    
        //step 4 swap
        int t= first.val;
        first.val=second.val;
        second.val=t;
        
        return head;
    }
}