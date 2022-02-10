class MedianFinder {
    
    PriorityQueue<Integer> pq1; 
    PriorityQueue<Integer> pq2; 

    public MedianFinder() {
        pq1 = new PriorityQueue<>(Collections.reverseOrder());
        pq2 = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (pq1.isEmpty() || pq1.peek() > num) {
            pq1.add(num);
        } else {
            pq2.add(num);
        }
        
        if (pq1.size() > pq2.size() + 1) {
            pq2.add(pq1.peek());
            pq1.poll();
        } else if (pq2.size() > pq1.size()){
            pq1.add(pq2.peek());
            pq2.poll();
        }
    }
    
    public double findMedian() {
        double val = 0.0;
        if (pq1.size() == pq2.size()) {
            val = (pq1.peek() + pq2.peek()) / 2.0;
        } else if (pq1.size() > pq2.size()) {
            val = pq1.peek();
        } else if (pq1.size() < pq2.size()) {
            val = pq2.peek();
        }
        
        return val;
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */