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
    public boolean hasPathSum(TreeNode root, int targetSum)
    {
       
       List<Integer>temp=new ArrayList<>();
       return check(root,targetSum,temp);
    }

     public boolean check(TreeNode root,int targetSum,List<Integer> temp)
     {
        if(root==null)return false;

        temp.add(root.val);

        if(root.left==null&&root.right==null&&targetSum==root.val)
        {
            return true;
        }
        boolean left=check(root.left,targetSum-root.val,temp);
        boolean right=check(root.right,targetSum-root.val,temp);
        temp.remove(temp.size()-1);
        return left||right;
     }
}