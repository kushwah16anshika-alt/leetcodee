/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxLevelSum(TreeNode root)
    {
       Queue< TreeNode>q=new LinkedList<>();

       q.offer(root);

       int level=1;

       int answerlevel=1;

       int maxsum=Integer.MIN_VALUE;

       while(!q.isEmpty())
       {
         int size=q.size();
         int levelsum=0;

         for(int i=0;i<size;i++)
         {
            TreeNode currnode=q.poll();

            levelsum+=currnode.val;

            if(currnode.left != null)
            {
                q.offer(currnode.left);
            }
            if(currnode.right != null)
            {
                q.offer(currnode.right);
            }
         }
        if(levelsum>maxsum)
        {
            maxsum=levelsum;

            answerlevel=level;
        }
        level++;

       }
     return answerlevel;
    }
}