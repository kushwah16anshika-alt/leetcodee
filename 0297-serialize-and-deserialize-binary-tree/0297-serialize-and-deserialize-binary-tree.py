# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None



class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        if root is None:
            return "null"
    
        return str(root.val)+","+\
         self.serialize(root.left)+","+\
         self.serialize(root.right)

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        arr=data.split(",")
        index=[0]

        return self.build(arr,index)

    def build(self, arr, index):
    
        if arr[index[0]]=="null":
         index[0]+=1
         return None
       
        root = TreeNode(int(arr[index[0]]))
        index[0]+=1
        root.left = self.build(arr, index)
        root.right = self.build(arr, index)
        return root

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))