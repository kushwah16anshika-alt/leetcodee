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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return check(root, targetSum);
    }

    public boolean check(TreeNode root, int remainingSum) {

        if (root == null) return false;

        if (root.left == null && root.right == null) {
            return remainingSum == root.val;
        }

        int newSum = remainingSum - root.val;

        return check(root.left, newSum) || check(root.right, newSum);
    }
}