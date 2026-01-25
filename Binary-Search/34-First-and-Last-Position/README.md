# 34. Find First and Last Position of Element in Sorted Array (Medium)

## 📝 Problem Statement
Given an array of integers `nums` sorted in non-decreasing order, find the starting and ending position of a given `target` value. If the target is not found, return `[-1, -1]`.

The algorithm must run in **O(log n)** runtime complexity.



## 💡 Intuition & Approach
The goal is to find the boundaries of a target in a sorted array with duplicates. 

### Evolution of the Code:
1. **Initial Thought:** Create two separate methods, `firstOccurrence()` and `lastOccurrence()`.
2. **Refactoring (DRY):** Merged the logic into one helper method `search()` using a boolean flag `isFirstOccurence`.
3. **Optimization:** Added a check `if(ans[0] != -1)`. If the target doesn't exist in the first search, we skip the second search entirely, making the code more efficient for "not found" cases.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝙡𝙤𝙜 𝙣) - Still logarithmic, but optimized to skip the second pass if target is missing.
* **Space Complexity:** 𝙊(𝟭) - Constant space usage.

## 💻 Implementation (Java)
```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        
        // Optimization: Only look for the last occurrence if the first one is found
        ans[0] = search(nums, target, true);
        
        if (ans[0] != -1) {
            ans[1] = search(nums, target, false);
        }

        return ans;
        
        /* Original Thought Process (Two separate methods):
        int first = firstOccurence(nums, target);
        int last = lastOccurence(nums, target);
        return new int[]{first, last};
        */
    }

    // Single helper method for both boundaries
    int search(int[] nums, int target, boolean isFirstOccurence) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                ans = mid;
                if (isFirstOccurence) {
                    end = mid - 1; // Narrow down to the left
                } else {
                    start = mid + 1; // Narrow down to the right
                }
            }
        }
        return ans;
    }

    /*
    // PREVIOUS VERSION (Before merging and optimizing)
    
    int firstOccurrence(int[] nums, int target) { ... }
    int lastOccurrence(int[] nums, int target) { ... }
    */
}
