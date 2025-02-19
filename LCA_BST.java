/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ptr=root;
        while(ptr!=null){
            if((p.val < ptr.val && q.val>ptr.val) || (q.val<ptr.val && p.val>ptr.val))
              return ptr;
            else if(p.val<ptr.val && q.val<ptr.val)
             ptr=ptr.left;
            else if(p.val>ptr.val && q.val>ptr.val)
             ptr=ptr.right;
            else if(p.val==ptr.val || q.val==ptr.val)
             return ptr;
        }
        return null;
    
    }
}
