# 703. Kth Largest Element in a Stream (Easy)

## 📝 Problem Statement
Design a class to find the $k$-th largest element in a stream of numbers. Note that it is the $k$-th largest element in the sorted order, not the $k$-th distinct element.

Implement `KthLargest` class:
* `KthLargest(int k, int[] nums)` Initializes the object with the integer `k` and the stream of integers `nums`.
* `int add(int val)` Appends a new integer `val` to the stream and returns the element representing the $k$-th largest element in the pool of integers so far.

## 💡 Intuition & Approach
To keep track of the $k$-th largest element dynamically in a stream, sorting the entire array on every insertion would be highly inefficient ($O(N \log N)$ per addition). Instead, we can optimize this by maintaining a **Min-Heap (PriorityQueue)** capped at a maximum size of $k$.

A Min-Heap keeps the smallest element at the top (`peek()`). By limiting the heap size to exactly $k$, the heap will exclusively hold the $k$ largest elements seen so far in the stream. The smallest among these $k$ largest elements will reside at the top of the heap. Consequently, the top element is guaranteed to be the overall $k$-th largest element of the entire stream.

When a new number is introduced:
1. If the heap has fewer than $k$ elements, we insert the number directly.
2. If the heap is full, we compare the new number with the top element (`minHeap.peek()`). If the new value is larger, it deserves a spot in our top-$k$ pool, so we remove the smallest element (`poll()`) and push the new value (`offer()`). If it is smaller, it can be safely ignored.

### 🛠️ The Strategy:
1. **Initialize Fixed-Size Heap:** Create a `PriorityQueue` with capacity `k`. Loop through initial inputs and call the internal insertion routine.
2. **Size Capped Insertion:** If `minHeap.size() < k`, insert the item. Otherwise, compare the value with `minHeap.peek()` and execute a swap (`poll` followed by `offer`) if the incoming value is larger.
3. **Query Resolution:** The `add(val)` method runs the insertion policy and returns the top element using `minHeap.peek()` in $O(1)$ time.

## 📊 Complexity Analysis
* **Time Complexity:** 
  * **Initialization:** O(N log K) - Where $N$ is the number of initial elements. Each element insertion into a heap of size $K$ takes logarithmic time.
  * **Add Operation:** O(log K) - Inserting a new element and maintaining heap order requires time proportional to the heap height, which is bounded by $K$.
* **Space Complexity:** O(K) - The heap stores at most $K$ elements at any given point, guaranteeing highly efficient memory boundaries.

## 💻 Implementation (Java)
```java
class KthLargest {
    private int k;
    private PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>(k);

        // Seed the heap with initial array values
        for (int num : nums) {
            insert(num);
        }
    }
    
    public int add(int val) {
        insert(val);
        // The top of a min-heap of size k is always the kth largest element overall
        return minHeap.peek();
    }

    private void insert(int num) {
        // Case 1: Heap is not yet full, collect incoming element
        if (minHeap.size() < k) {
            minHeap.offer(num);
        } 
        // Case 2: Element is larger than current kth largest, update pool
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
