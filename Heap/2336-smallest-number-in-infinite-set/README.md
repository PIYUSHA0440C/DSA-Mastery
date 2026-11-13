# 2336. Smallest Number in Infinite Set (Medium)

## 📝 Problem Statement

Implement the `SmallestInfiniteSet` class to manage a set containing all positive integers.

- `SmallestInfiniteSet()`: Initializes the set with all positive integers.
- `popSmallest()`: Removes and returns the smallest available integer.
- `addBack(num)`: Adds `num` back if it was previously removed and is not already present.

## 💡 Intuition & Approach

Use a combination of a **Min-Heap, HashSet, and a pointer** to efficiently manage the infinite set without storing every positive integer.

- `current`: Tracks the smallest integer that has never been removed from the original infinite sequence. Initially, it is 1.
- `minHeap`: Stores numbers that have been added back, allowing the smallest restored number to be retrieved first.
- `addedBack`: Tracks numbers currently present in the heap to prevent duplicate insertions.

**For `popSmallest()`:**
- If the Min-Heap is not empty, remove and return its smallest element.
- Remove that element from the HashSet as well.
- Otherwise, return `current` and increment it.

**For `addBack(num)`:**
- Only add the number if it is smaller than `current` and is not already present in the HashSet.
- Insert it into both the Min-Heap and HashSet.

This approach avoids storing the infinite sequence and maintains the smallest available number efficiently.

## 🛠️ The Strategy:

1. Initialize `current` to 1, along with an empty Min-Heap and HashSet.
2. For `popSmallest()`, prioritize numbers in the Min-Heap.
3. Remove the popped number from the HashSet to allow it to be added back again later.
4. If the heap is empty, return `current` and increment it.
5. For `addBack(num)`, check whether the number was previously removed and is not already in the heap.
6. Insert valid numbers into both data structures.

## 📊 Complexity Analysis

Let k be the number of currently stored added-back elements.

- **Time Complexity:**
  - `popSmallest()`: O(log k) when the heap is non-empty; O(1) otherwise.
  - `addBack(num)`: O(log k) for heap insertion, with expected O(1) HashSet operations.
  - Constructor: O(1).
- **Space Complexity:** O(k), for storing added-back elements in the Min-Heap and HashSet.

## 💻 Implementation (Java)

```java
class SmallestInfiniteSet {
    private int current;
    private PriorityQueue<Integer> minHeap;
    private Set<Integer> addedBack;

    public SmallestInfiniteSet() {
        current = 1;
        minHeap = new PriorityQueue<>();
        addedBack = new HashSet<>();
    }

    public int popSmallest() {
        if (!minHeap.isEmpty()) {
            int smallest = minHeap.poll();
            addedBack.remove(smallest);

            return smallest;
        }

        return current++;
    }

    public void addBack(int num) {
        if (num < current && !addedBack.contains(num)) {
            minHeap.offer(num);
            addedBack.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
```
