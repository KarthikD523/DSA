class Pair implements Comparable<Pair>{
    int value;
    int count;
    Pair(int value,int count){
        this.value=value;
        this.count=count;
    }

    @Override
    public int compareTo(Pair other){
        return Integer.compare(other.count,this.count);
    }
}


class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int res[]=new int[k];
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        Arrays.sort(nums);
        int count=1;
        int i;
        for( i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                count++;
            }
            else
            {
                pq.add(new Pair(nums[i-1],count));
                count=1;
            }
        }
        pq.add(new Pair(nums[i-1],count));
        int index=-1;
        while(k>0){
            res[++index]=pq.poll().value;
            k--;
        }
        return res;
    }
}