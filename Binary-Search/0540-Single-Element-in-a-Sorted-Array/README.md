# 540. Single Element in a Sorted Array (Medium)

## 📝 Problem Statement
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Return the single element that appears only once. Your solution must run in $O(\log n)$ time and $O(1)$ space.

## 💡 Intuition & Approach
The array is sorted, and a linear scan using XOR would cost $O(N)$ time. To achieve a logarithmic runtime constraint of $O(\log N)$, we can apply **Binary Search** by evaluating index parity patterns.

In a normal paired sequence before the single element appears, pairs always follow an **(Even, Odd)** index pattern. That means for any duplicate pair starting at an even index `mid`, `nums[mid]` must equal `nums[mid + 1]`. 

The moment the single element is introduced, this alignment gets disrupted. For all pairs after the single element, the duplicates shift to an **(Odd, Even)** pattern.

### 🛠️ The Strategy:
1. **Mid Alignment:** Find `mid`. If `mid` is an odd index, decrement it by 1 (`mid--`) to ensure `mid` always anchors an even index position.
2. **Halving the Search Space:** - If `nums[mid] == nums[mid + 1]`, it means the (Even, Odd) pattern is still intact up to `mid + 1`. The single element must lie to the right, so we shift `start = mid + 2`.
   - If `nums[mid] != nums[mid + 1]`, the pattern has broken. The mismatch indicates that the single element lies at or to the left of `mid`. We shift our boundary to `end = mid`.
3. **Termination:** When `start == end`, the loop terminates, pinpointing the single non-duplicate value.

## 📊 Complexity Analysis
* **Time Complexity:** O(log N) - The binary search eliminates half of the remaining lookup space in each iteration.
* **Space Complexity:** O(1) - The verification uses only primitive pointer bounds without dynamic tables.

## 💻 Implementation (Java)
```java
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start = 0, end = nums.length - 1;

        // Binary search to isolate the index disruption
        while (start < end) {
            int mid = start + (end - start) / 2;

            // Ensure mid is always placed at an even index
            if (mid % 2 == 1) {
                mid--;
            }

            // Check if the pair matches the expected (Even, Odd) index layout
            if (nums[mid] == nums[mid + 1]) {
                // Left side is normal; target is in the right half
                start = mid + 2;
            } else {
                // Structural break found; target is at or to the left of mid
                end = mid;
            }
        }

        return nums[start];
    }
}
