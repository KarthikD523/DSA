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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        List<List<Integer>> res=new ArrayList<>();
        int flag=0;
        int level=0;
        if(root==null)
          return res;
        while(!q.isEmpty()){
            res.add(new ArrayList<>());
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                 if(flag==1)
                    res.get(level).add(0,node.val);
                else{
                    res.get(level).add(node.val);
                }
                  if(node.left!=null)
                      q.add(node.left);
                    if(node.right!=null)
                      q.add(node.right);
            }
             flag=flag^1;
             level++;
        }
        return res;
    }
}
