class MedianFinder {
    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
       left.add(num);

       right.add(left.remove());
       if(left.size() <right.size()){
        left.add(right.remove());
       } 
    }
    
    public double findMedian() {
           if (left.size() > right.size()) {
            return left.peek(); // odd count
        } else {
            return (left.peek() + right.peek()) / 2.0; // even count
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */