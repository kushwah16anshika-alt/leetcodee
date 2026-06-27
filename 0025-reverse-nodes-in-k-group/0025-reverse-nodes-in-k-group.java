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
    public ListNode reverseKGroup(ListNode head, int k) 
    {
        if(head==null ||k==1)
        {
            return head;
        }
        ListNode temp=head;
        int count=0;
        while(temp!=null && count<k) //Ye sirf check karta hai ki k nodes available hain ya nahi.
        {
            temp=temp.next;
            count++;
        }
            if(count<k)
            {
                return head;
            }
            ListNode prev=null;
            ListNode curr=head;
            for(int i=0;i<k;i++)
            {
                ListNode Next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=Next;
            }
            head.next=reverseKGroup(curr, k);
        
        return prev;
    }
}