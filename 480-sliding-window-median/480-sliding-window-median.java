class Solution {
     Queue<Integer> minHeap;
     Queue<Integer> maxHeap;
        
    public Solution() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    private void add(int num) {
        if (maxHeap.size() == 0 || maxHeap.peek() > num) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }
    
    private void remove(int num) {
        if (num <= maxHeap.peek()) {
            maxHeap.remove(num);
        } else {
            minHeap.remove(num);
        }
        
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }
    
    private double findMedian() {
        double val = 0.0;
        if (maxHeap.size() == minHeap.size()) {
            val = maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
        } else if (maxHeap.size() > minHeap.size()) {
            val = maxHeap.peek();
        } else if (maxHeap.size() < minHeap.size()) {
            val = minHeap.peek();
        }
         
        return val;
    }
    
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            add(nums[end]);
            int size = (end - start + 1);
            if (size == k) {
                result[start] = findMedian();
                remove(nums[start]);
                start++;
            }
        }
        
        return result;
    }
}