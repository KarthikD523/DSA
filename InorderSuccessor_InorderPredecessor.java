class Solution {
    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        // code here.
        // update pre[0] with the predecessor of the key
        // update suc[0] with the successor of the key
        pre[0]=null;
        suc[0]=null;
        Node ptr=root;
        while(ptr!=null){
            if(ptr.data>key){
                suc[0]=ptr;
                ptr=ptr.left;
            }
            else
              ptr=ptr.right;
            
        }
        
        ptr=root;
        while(ptr!=null){
            if(ptr.data<key){
                pre[0]=ptr;
                ptr=ptr.right;
            }
            else
             ptr=ptr.left;
        }
        
        
    }
}
