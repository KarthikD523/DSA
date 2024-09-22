class Solution {

    public int f(int nums[],int index,int prev_index,int dp[][]){
        if(index==nums.length)
          return 0;
        if(dp[index][prev_index+1]!=-1)
          return dp[index][prev_index+1];
        int len=0+f(nums,index+1,prev_index,dp); //Not pick
        if(prev_index==-1 ||  nums[index]>nums[prev_index])
           len=Math.max(len,1+f(nums,index+1,index,dp));   //Pick
        return dp[index][prev_index+1]=len;
    }

    public int lengthOfLIS(int[] nums) {
        int dp[][]=new int[nums.length][nums.length];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                dp[i][j]=-1;
            }
        }
        return f(nums,0,-1,dp);
    }
}