import java.util.* ;
import java.io.*; 
/*   
    Following is the Binary Tree node structure for referance:

    class TreeNode
    {
        int data;
        TreeNode left, right;
    
        public TreeNode(int item)
        {
            data = item;
            left = right = null;
        }
    }
*/

public class Solution {
    public static boolean f(TreeNode node,ArrayList<Integer> ds,int x){
        if(node==null)
        return false;
        ds.add(node.data);
        if(node.data==x){
           
            return true;
        }
         
        boolean left=f(node.left,ds,x);
        if(left==true)
        return left;
        boolean right=f(node.right,ds,x);
        if(left==false && right!=false)
          return right;
        
        else if(left==false && right==false){
            ds.remove(ds.size()-1);
            return false;
        }
        return false;
          
        
    }
    public static ArrayList<Integer> pathInATree(TreeNode root, int x) {
        // Write your code here..
        ArrayList<Integer> ds=new ArrayList<>();
        boolean res=f(root,ds,x);
        return ds;

    }
}
