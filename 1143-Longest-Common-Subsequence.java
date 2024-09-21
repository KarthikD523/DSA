class Solution {
    public int f(int index1,int index2,String text1,String text2,int dp[][]){
        if(index1<0 || index2<0)
         return 0;

        if(dp[index1][index2]!=-1)
         return dp[index1][index2];

        if(text1.charAt(index1)==text2.charAt(index2)){
            return dp[index1][index2]=1+f(index1-1,index2-1,text1,text2,dp);
        }
        int n1=f(index1,index2-1,text1,text2,dp);
        int n2=f(index1-1,index2,text1,text2,dp);
        return dp[index1][index2]=Integer.max(n1,n2);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp=new int[text1.length()][text2.length()];
        for(int i=0;i<text1.length();i++){
            for(int j=0;j<text2.length();j++){
                dp[i][j]=-1;
            }
        }
        return f(text1.length()-1,text2.length()-1,text1,text2,dp);
    }
}