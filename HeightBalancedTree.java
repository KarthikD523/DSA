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
    public int height(TreeNode node,boolean res[]){
        if(res[0]!=false){
        if(node==null)
         return 0;
        
        int left=1+height(node.left,res);
        int right=1+height(node.right,res);
        if(Math.abs(left-right)>1)
           res[0]=false;

        return Math.max(left,right);
        }
        return 0;
       
    }
    public boolean isBalanced(TreeNode root) {
       boolean[] res=new boolean[1];
       res[0]=true;
       int a=height(root,res);
       return res[0];
    }
}
