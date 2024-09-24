class Solution {
    public int f(int i,int j,String word1,String word2,int dp[][]){
        if(i<0)
          return j+1;
        if(j<0)
          return i+1;
        if(dp[i][j]!=-1)
         return dp[i][j];
        if(word1.charAt(i)==word2.charAt(j))
          return dp[i][j]=f(i-1,j-1,word1,word2,dp);

        int mini=Integer.MAX_VALUE;

        int delete=1+f(i-1,j,word1,word2,dp);
        int insert=1+f(i,j-1,word1,word2,dp);
        int replace=1+f(i-1,j-1,word1,word2,dp);

       mini=Math.min(mini,delete);
       mini=Math.min(mini,insert);
       mini=Math.min(mini,replace);
       
       
        return dp[i][j]=mini;
    }
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();

        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return f(m-1,n-1,word1,word2,dp);
    }
}