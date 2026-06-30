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
    public void flatten(TreeNode root) {

        if (root == null) return;

        TreeNode curr = root;

        while (curr != null) {

            // Agar left subtree exist karta hai
            if (curr.left != null) {

                TreeNode temp = curr.right;   // save right subtree

                curr.right = curr.left;       // left ko right bana do
                curr.left = null;

                // left subtree ke end tak jao
                TreeNode t = curr.right;
                while (t.right != null) {
                    t = t.right;
                }

                // purana right attach karo
                t.right = temp;
            }

            // move to next node
            curr = curr.right;
        }
    }
}