class Solution {

    public int f(int i,int j,int dp[][]){
        if(i==0 && j==0)
         return 1;
         if(dp[i][j]!=-1)
          return dp[i][j];
          int left=0,up=0;
        if(j>0){
         left= f(i,j-1,dp);
        }
         
        if(i>0){
         up= f(i-1,j,dp);    
        }
       return  dp[i][j]=left+up;
    }
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
              dp[i][j]=-1;
        }
       // return f(m-1,n-1,dp);
       dp[0][0]=1;
       for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(i==0 && j==0)
              continue;
            int up=i>0?dp[i-1][j]:0;
            int left=j>0?dp[i][j-1]:0;
            dp[i][j]=up+down;
        }
       }
       return dp[m-1][n-1];
    }
}
