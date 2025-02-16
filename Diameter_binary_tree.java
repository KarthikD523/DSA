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
    public int findHeight(TreeNode node,int diameter[]){
        if(node==null)
          return -1;
        int left=1+findHeight(node.left,diameter);
        int right=1+findHeight(node.right,diameter);
        diameter[0]=Math.max(diameter[0],left+right);
        return Math.max(left,right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter=new int[1];
        int res= findHeight(root,diameter);
        return diameter[0];
    }
}
