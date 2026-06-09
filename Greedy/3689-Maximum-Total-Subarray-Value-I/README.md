# 3689. Maximum Total Subarray Value I (Medium)

## 📝 Problem Statement
You are given an integer array `nums` of length `n` and an integer `k`. You need to choose exactly `k` non-empty subarrays of `nums`. Subarrays may overlap, and the exact same subarray can be chosen more than once. The value of a subarray is defined as `max(subarray) - min(subarray)`. Return the maximum possible total value (sum of values of all chosen subarrays) you can achieve.

## 💡 Intuition & Approach
The phrasing of the problem makes it look like a complex combinatorial optimization puzzle. However, a closer look at the constraints and rules reveals a highly exploitable **Greedy Invariant**:
1. We are required to choose exactly `k` subarrays.
2. Subarrays **may overlap**.
3. The **exact same subarray can be chosen more than once**.

To maximize the total value, we want each of our `k` choices to have the largest possible individual value. The maximum possible difference between any two elements in the entire array is simply `globalMax - globalMin`. 

Since we can choose the full array `nums[0..n-1]` (or any subarray containing both the global maximum and global minimum elements) repeatedly for all `k` choices, we don't need to look at any other configurations. The problem collapses from a subarray search into a simple global peak-to-peak calculation.

### 🛠️ The Strategy:
1. **Find Global Extrema:** Traverse `nums` in a single pass to find the absolute maximum (`max`) and minimum (`min`) values.
2. **Compute Result:** The max value for a single subarray is `max - min`. Since we can pick this optimal subarray exactly `k` times, the final answer is `k * (max - min)`.
3. **Type Casting:** Cast the product to a `long` to safely avoid integer overflow, as `k` can be up to $10^5$ and elements can be up to $10^9$.

## 📊 Complexity Analysis
* **Time Complexity:** O(N) - We scan the array exactly once to locate the global maximum and minimum elements.
* **Space Complexity:** O(1) - The solution runs completely in-place using only two primitive tracking variables.

## 💻 Implementation (Java)
```java
class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // Step 1: Isolate the absolute maximum and minimum values in the array
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        
        // Step 2: Multiply the peak difference by k, casting to long to avoid overflow
        return (long) k * (max - min);
    }
}
