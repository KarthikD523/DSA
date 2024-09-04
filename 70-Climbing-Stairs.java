class Solution {

    
    public  int calculateSteps(int index,int n,int res[]){
        if(index>=n){
            if(index==n){
                res[index]=1;
                return 1;
            }
             
           return 0;
        }
        if(res[index]!=0){
            
            return res[index];
        }
           
      int a =  calculateSteps(index+1,n,res);
      int b =  calculateSteps(index+2,n,res);
    
       res[index]=a+b;
       return res[index];
    }
    public int climbStairs(int n) {
        int res[]=new int[n+1];
       
        calculateSteps(0,n,res);
        return res[0];
    }
}