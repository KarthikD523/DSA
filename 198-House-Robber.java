class Solution {
    public int f(int index,int nums[],int dp[]){

        if(index<=0){
            if(index==0)
              return nums[0];
            return 0;
        }

        if(dp[index]!=-1)
          return dp[index];

        int left=nums[index]+f(index-2,nums,dp);
        int right=0+f(index-1,nums,dp);
        return dp[index]= Integer.max(left,right);
    }
    public int rob(int[] nums) {
        int dp[]=new int[nums.length];
        for(int i=0;i<nums.length;i++)
          dp[i]=-1;
        return f(nums.length-1,nums,dp);

    }
}