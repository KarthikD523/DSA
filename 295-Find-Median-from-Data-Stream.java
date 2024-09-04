class MedianFinder {
    PriorityQueue<Integer> maxheap;
    PriorityQueue<Integer> minheap;
    public MedianFinder() {
        maxheap=new PriorityQueue<>(Comparator.reverseOrder());
        minheap=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxheap.add(num);

        if(maxheap.size()!=0 && minheap.size()!=0 && maxheap.peek()>minheap.peek()){
            int a =maxheap.poll();
            minheap.add(a);
        }

        if(maxheap.size()>minheap.size()+1){
            int a =maxheap.poll();
            minheap.add(a);
        }
        else if(minheap.size()>maxheap.size()+1){
            int a =minheap.poll();
            maxheap.add(a);
        }
    }
    
    public double findMedian() {
        if(maxheap.size()==minheap.size()){
            double res= (double)(minheap.peek()+maxheap.peek())/2;
            return res;
        }
        else if(maxheap.size()>minheap.size()){
            return maxheap.peek();
        }
        else
         return minheap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */