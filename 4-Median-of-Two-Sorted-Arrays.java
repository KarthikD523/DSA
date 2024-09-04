class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int len=n+m;
   
   if(n>m){
    return findMedianSortedArrays(nums2,nums1);
   }

        int k;
       k=len/2;

       int low=Integer.max(0,k-m);
       int high=Integer.min(n,k);

       while(low<=high){
        int cut1=(low+high)/2;
        int cut2=k-cut1;

        int l1=cut1==0?Integer.MIN_VALUE:nums1[cut1-1];
        int l2=cut2==0?Integer.MIN_VALUE:nums2[cut2-1];
        int r1=cut1==n?Integer.MAX_VALUE:nums1[cut1];
        int r2=cut2==m?Integer.MAX_VALUE:nums2[cut2];
        if(l1<=r2 && l2<=r1){
            double res;
            if(len%2==0){
                
                res=(double)(Integer.max(l1,l2)+Integer.min(r1,r2))/2;
                return res;
            }
            else{
                res=Integer.min(r1,r2);
                return res;
            }
        }
        else if(l1>r2){
            high=cut1-1;
        }
        else
          low=cut1+1;
       }
       return 1;
    }
}