class Solution {
    public int f(int index,int nums[],int dp[],int ch){
       
        if(index<=1 && ch==1){
            if(index==1)
              return nums[1];
            return 0;

        }
        if(index<=0){
            if(index==0)
             return nums[0];
            return 0;
        }
        if(dp[index]!=-1)
          return dp[index];
        int left=0+f(index-1,nums,dp,ch);
        int right=nums[index]+f(index-2,nums,dp,ch);
        dp[index]=Integer.max(left,right);
        return dp[index];
    }
    public int rob(int[] nums) {
         if(nums.length==1)
          return nums[0];
        int dp[]=new int[nums.length];
        for(int i=0;i<nums.length;i++)
          dp[i]=-1;
        int last_ignore=f(nums.length-2,nums,dp,0);
        

        for(int i=0;i<nums.length;i++)
          dp[i]=-1;
        int first_ignore=f(nums.length-1,nums,dp,1);
       
        return Integer.max(first_ignore,last_ignore);
        
    }
}