public class Solution {

    public static int f(int day,int last,int points[][],int dp[][]){
        if(day==0){
            int maxi=-1;
            for(int i=0;i<=2;i++){
                if(i!=last){
                    maxi=Integer.max(maxi,points[0][i]);

                }
            }
            return dp[day][last]=maxi;
        }


        if(dp[day][last]!=-1)
          return dp[day][last];
        int maxi=-1;
        for(int task=0;task<=2;task++){
            if(task!=last){
                int point=points[day][task]+f(day-1,task,points,dp);
                maxi=Integer.max(point,maxi);
            }
        }
        return dp[day][last]=maxi;
    }
    public static int ninjaTraining(int n, int points[][]) {

       int dp[][]=new int[n][4];
       for(int i=0;i<n;i++){
           for(int j=0;j<4;j++){
               dp[i][j]=-1;
           }
       }
       return f(n-1,3,points,dp);
    }

}
