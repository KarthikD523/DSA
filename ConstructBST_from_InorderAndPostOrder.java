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
    public TreeNode f(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd,HashMap<Integer,Integer> map){
        if(preStart>preEnd || inStart>inEnd)
          return null;

        TreeNode root=new TreeNode(preorder[preStart]);

        int iRoot=map.get(root.val);
        int num_left=iRoot-inStart;

        root.left=f(preorder,preStart+1,preStart+num_left,inorder,inStart,iRoot-1,map);
        root.right=f(preorder,preStart+num_left+1,preEnd,inorder,iRoot+1,inEnd,map);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        return f(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
    }
}
