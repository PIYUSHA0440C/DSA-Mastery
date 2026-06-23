# 295. Find Median from Data Stream (Hard)

## 📝 Problem Statement
The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.

Implement the `MedianFinder` class:
* `MedianFinder()` initializes the object.
* `void addNum(int num)` adds an integer from the data stream.
* `double findMedian()` returns the median of all elements so far.

## 💡 Intuition & Approach
Sorting the entire list upon every incoming number would require $O(N \log N)$ per addition, causing severe performance bottlenecks. To isolate the median in logarithmic time, we can view the ordered stream as two distinct halves:
1. **The Lower Half:** Contains the smaller elements. We need quick access to its largest value, making it a **Max-Heap**.
2. **The Upper Half:** Contains the larger elements. We need quick access to its smallest value, making it a **Min-Heap**.

By maintaining these two heaps, the median will always reside at the roots (peeks) of either one or both structures.

### 🛠️ The Strategy:
1. **Balance Insertion:** When a new element arrives, we route it through the heaps to ensure proper sorting:
   - First, insert the element into the `minHeap`.
   - Take the smallest element from the `minHeap` and balance it down into the `maxHeap`.
2. **Size Stabilization:** We enforce a size constraint where `maxHeap` can hold at most one more element than `minHeap`. If `maxHeap.size() > minHeap.size() + 1`, we balance it back by moving the peak of `maxHeap` into `minHeap`.
3. **Median Extraction:** - If both heaps have equal sizes, the stream has an even number of elements; the median is the average of both roots: `(maxHeap.peek() + minHeap.peek()) / 2.0`.
   - If the sizes are unequal, `maxHeap` contains the extra element, making its root the exact median.

## 📊 Complexity Analysis
* **Time Complexity:** -
  * `addNum`: O(log N) - Adding an element and rebalancing heap properties takes logarithmic time.
  * `findMedian`: O(1) - Accessing the root elements of the heap requires constant time execution.
* **Space Complexity:** O(N) - Linear space allocated to retain all elements in memory within the two heaps.

## 💻 Implementation (Java)
```java
class MedianFinder {
    private PriorityQueue<Integer> minHeap; // Stores the larger half of numbers
    private PriorityQueue<Integer> maxHeap; // Stores the smaller half of numbers

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        // Step 1: Filter the number through minHeap to find its sorted position
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());
        
        // Step 2: Maintain size balance property (maxHeap size <= minHeap size + 1)
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        // If even total elements, return the average of both middle elements
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        
        // If odd total elements, maxHeap root holds the exact median
        return (double) maxHeap.peek();
    }
}
