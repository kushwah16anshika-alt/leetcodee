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
    public TreeNode pruneTree(TreeNode root) 
    {
        if(root==null)return null;

        pruneTree(root.left);
        pruneTree(root.right);

        if(!checkone(root.left))
        {
            root.left=null;
        }
        if(!checkone(root.right))
        {
            root.right=null;
        }

        if(root.left==null&&root.right==null && root.val==0)
        {
            return null;
        }
        return root;
    }
    public boolean checkone(TreeNode root)
    {
        if(root==null)return false;

        if(root.val==1)
        {
            return true;
        }

        return checkone(root.left) || checkone(root.right);
    }
}