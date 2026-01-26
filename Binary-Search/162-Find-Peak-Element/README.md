# 162. Find Peak Element (Medium)

## 📝 Problem Statement
A peak element is an element that is strictly greater than its neighbors. Given a 0-indexed integer array `nums`, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that `nums[-1] = nums[n] = -∞`.
**Requirement:** Must run in **O(log n)** time.



## 💡 Intuition & Approach
The key to solving this in $O(\log n)$ is realizing that if we are on an upward slope, there *must* be a peak to our right (even if it's just the last element). If we are on a downward slope, there *must* be a peak to our left (even if it's just the first element).

1. **Binary Search on Slopes:** We compare `nums[mid]` with its next neighbor `nums[mid + 1]`.
   - **Case 1: `nums[mid] > nums[mid + 1]`**
     We are currently in a decreasing sequence. This means `mid` could be a peak, or the peak lies to the left. 
     *Action:* `end = mid`.
   - **Case 2: `nums[mid] < nums[mid + 1]`**
     We are currently in an increasing sequence. This means a peak must lie to the right of `mid`. 
     *Action:* `start = mid + 1`.
2. **Convergence:** The search space eventually shrinks to a single element where `start == end`. That index is a guaranteed peak.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝙡𝙤𝙜 𝙣) - We divide the search space by half each iteration.
* **Space Complexity:** 𝙊(𝟭) - No extra space used.

## 💻 Implementation (Java)
```java
class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while(start < end){
            int mid = start + (end - start) / 2;

            if(nums[mid] > nums[mid + 1]){
                // We are in a decreasing part of the array
                // This mid could be the peak, but we look left to be sure
                end = mid;
            } else {
                // We are in an increasing part of the array
                // The peak must be to the right of mid
                start = mid + 1;
            }
        }
        // start and end converge to a peak element
        return end; 
    }
}
