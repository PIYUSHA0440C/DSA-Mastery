class KthLargest {
    private int k;
    private PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>(k);

        for(int num: nums){
            insert(num);
        }
    }
    
    public int add(int val) {
        insert(val);
        return minHeap.peek();
    }

    private void insert(int num) {
        if(minHeap.size() < k) minHeap.offer(num);
        else if (num > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(num);
        }        
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
