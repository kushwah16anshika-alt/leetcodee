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
    public ListNode mergeKLists(ListNode[] lists) 
    {
        PriorityQueue<ListNode>q=new PriorityQueue<>((a,b)->a.val-b.val);
        
        for(ListNode node : lists)
        {
            if(node != null)
            {
                q.offer(node);
            }
        }

        ListNode dummy= new ListNode(-1);
        ListNode current =dummy;

        while(!q.isEmpty())
        {
            ListNode minnode =q.poll();

            current.next=minnode;
            current=current.next;

            if(minnode.next!=null)
            {
                q.offer(minnode.next);
            }
        }
        return dummy.next;
    }
}