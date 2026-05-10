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
    public int sumNumbers(TreeNode root) 
    {
        return sum(root,0);
    }
    public int sum(TreeNode root,int summ) 
    {
        if(root==null)
        {
            return 0;
        }
        if(root.left==null&&root.right==null)
        {
            return summ*10+root.val;
        }
        int leftsum=sum(root.left,summ*10+root.val);
        int rightsum=sum(root.right,summ*10+root.val);

        return leftsum+rightsum;
    }

}