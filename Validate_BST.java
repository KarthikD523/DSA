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
    public boolean f(TreeNode node,long min,long max){
        boolean left,right;

        if(node==null)
          return true;

        if(node.val>min && node.val<max){
         left=f(node.left,min,node.val);
         right=f(node.right,node.val,max);
         if(left==false || right==false)
           return false;
        else
         return true;
        }
        else
         return false;
        
    }
    public boolean isValidBST(TreeNode root) {
        return f(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
}
