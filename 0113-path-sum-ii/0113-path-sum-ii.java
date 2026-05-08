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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum)
    {
        List<List<Integer>> result= new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        checksum(result,targetSum,temp,root);

        return result;
    }

    public void checksum(List<List<Integer>>result,int ts,List<Integer> temp,TreeNode root)
    {
        int sum=0;
        if(root==null)return ;
        temp.add(root.val);
        if(root.left==null&& root.right==null&&ts==root.val)
        {
            result.add(new ArrayList<>(temp));
        }
         
        checksum(result, ts-root.val, temp, root.left);
        checksum(result, ts-root.val, temp, root.right);

     temp.remove(temp.size()-1);
    }
}