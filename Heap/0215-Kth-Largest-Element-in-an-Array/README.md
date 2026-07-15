# 215. Kth Largest Element in an Array (Medium)

## 📝 Problem Statement
Given an integer array `nums` and an integer `k`, return the `kth` largest element in the array.
Note that it is the `kth` largest element in the sorted order, not the `kth` distinct element.

Can you solve it without sorting?

## 💡 Intuition & Approach
Sorting the entire array costs $O(N \log N)$ time, which processes unnecessary elements if we only care about a single target position. Instead, we can optimize this to a bounded time window using a **Min-Heap (PriorityQueue)** capped at size `k`.

A Min-Heap keeps its smallest tracked value at the top (`peek()`). By limiting the heap's maximum size to exactly `k`, it forces the structure to exclusively hold the `k` largest elements encountered so far. The smallest element among these chosen top-tier numbers will sit at the root. Therefore, once the entire array has been processed, the top of the heap is guaranteed to be the overall `kth` largest element.

### 🛠️ The Strategy:
1. **Initialize Heap:** Declare a `PriorityQueue` configured as a min-heap to keep track of the largest numbers.
2. **Bounded Iteration:** Loop through every number in the array:
   * If the heap contains fewer than `k` items, immediately insert the current number (`offer()`).
   * If the heap is already full, compare the current number with `minHeap.peek()`. If the new number is larger, it belongs in the top-`k` group. We discard the old minimum (`poll()`) and insert the new value.
3. **Extract Result:** Once the loop completes, pop and return the final remaining root element.

## 📊 Complexity Analysis
* **Time Complexity:** O(N log K) - Where $N$ is the length of the array. Each element insertion or replacement inside a heap bounded by size $K$ takes logarithmic time. This is significantly faster than full sorting when $K \ll N$.
* **Space Complexity:** O(K) - The min-heap dynamically holds at most $K$ elements at any given point, minimizing space overhead.

## 💻 Implementation (Java)
```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Maintained min-heap holding exactly the k largest elements seen so far
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        
        for (int num : nums) {
            // Case 1: Heap is not full yet, build up to k elements
            if (minHeap.size() < k) {
                minHeap.offer(num);
            } 
            // Case 2: Found an element larger than the smallest in our top-k group
            else if (num > minHeap.peek()) {
                minHeap.poll(); // Evict the excess smaller element
                minHeap.offer(num); // Track the larger element instead
            }
        }

        // The root of the min-heap is now the kth largest element overall
        return minHeap.poll();
    }
}
