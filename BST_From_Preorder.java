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
    public TreeNode f(int bound,int[] preorder,int[] i ){
        if(i[0]==preorder.length || preorder[i[0]]>bound)
            return null;
        TreeNode root=new TreeNode(preorder[i[0]++]);
        root.left=f(root.val,preorder,i);
        root.right=f(bound,preorder,i);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] i=new int[1];
       return f(Integer.MAX_VALUE,preorder,i);

    }
}
