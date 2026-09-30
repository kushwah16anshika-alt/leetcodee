/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) 
    {
        if(root==null)
        {
            return "null";
        }
        return root.val+","+serialize(root.left)+","+serialize(root.right);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) 
    {
        String []arr=data.split(",");
        int []index=new int [1];

        return build(arr,index);
    }
    public TreeNode build(String []arr,int []index) 
    {
       if(arr[index[0]].equals("null"))
       {
         index[0]++;
         return null;
       }
       TreeNode root = new TreeNode(Integer.parseInt(arr[index[0]]));
       index[0]++;
       root.left=build(arr,index);
       root.right=build(arr,index);
       return root;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));