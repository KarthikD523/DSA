class Solution {
    public double myPow(double x, int n) {
        double res=1;
        long nn=n;
        if(nn<0)
        nn=nn*-1;
        while(nn>0){
            if(nn%2==0)
              {
                nn=nn/2;
                x=x*x;
              }
              else{
                res=res*x;
                nn=nn-1;
              }
        }
        if(n<0)
         res=1/res;
       return res;
    }
}