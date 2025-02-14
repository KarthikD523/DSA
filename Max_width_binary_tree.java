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
 class Pair{
    TreeNode node;
    int num;
    Pair(TreeNode _node,int _num){
        node=_node;
        num=_num;
    }
 }
class Solution {
    
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        int ans=0;
        while(!q.isEmpty()){
            int size=q.size();
            int mmin=q.peek().num;
            int first=mmin;
            int last=0;
            for(int i=0;i<size;i++){
                Pair p=q.poll();
                int num=p.num;
                TreeNode node=p.node;
                int cur_id=num-mmin;
                if(i==0)
                  first=cur_id;
                if(i==size-1)
                  last=cur_id;
                if(node.left!=null)
                 q.add(new Pair(node.left,2*cur_id+1));
                if(node.right!=null)
                 q.add(new Pair(node.right,2*cur_id+2));
            }
        ans=Math.max(ans,last-first+1);
        }
        return ans;
    }
}
