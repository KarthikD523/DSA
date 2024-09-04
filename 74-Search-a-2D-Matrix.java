class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length;
        int row=0;
        

        int lower=0;
       int upper=rows-1;
        int mid=0;
        while(lower<=upper){
         mid=(lower+upper)/2;
         if(matrix[mid][0]>target)
           upper=mid-1;
        else if(matrix[mid][0]<target)
        {
            if(target<=matrix[mid][matrix[mid].length-1])
                {
                    lower=mid+1;
                    break;
                }
                 lower=mid+1;
        }
           
        else
         return true;
        }
       
       row=mid;
       int column=matrix[row].length-1;
        lower=0;
        upper=column;
       while(lower<=upper){
         mid=(lower+upper)/2;
        if(target>matrix[row][mid])
         lower=mid+1;
        else if(target<matrix[row][mid])
         upper=mid-1;
         else
           return true;
       }
       return false;

    }
}