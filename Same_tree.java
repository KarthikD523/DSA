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
    public boolean f(TreeNode p,TreeNode q){
        if(p==null && q==null)
         return true;
        else if(p==null)
         return false;
        else if(q==null)
         return false;
         
        if(p!=null && q!=null && p.val!=q.val)
         return false;

        boolean left=false,right=false;
        if(p!=null && q!=null){
         left=f(p.left,q.left);
         right=f(p.right,q.right);
        }
       
        if(left==false || right==false)
         return false;
        return true;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return f(p,q);
    }
}
