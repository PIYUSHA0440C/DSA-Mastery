# 34. Find First and Last Position of Element in Sorted Array (Medium)

## 📝 Problem Statement
Given an array of integers `nums` sorted in non-decreasing order, find the starting and ending position of a given `target` value. If the target is not found, return `[-1, -1]`.

The algorithm must run in **O(log n)** runtime complexity.



## 💡 Intuition & Approach
To find the range of a target in a sorted array with duplicates, we perform two modified binary searches. 

Initially, I considered writing two separate functions: `firstOccurrence()` and `lastOccurrence()`. However, I realized the logic was nearly identical, so I refactored the code into a single, cleaner helper function using a boolean flag.

1. **First Occurrence:** When `nums[mid] == target`, we record the index and continue searching the left half (`end = mid - 1`).
2. **Last Occurrence:** When `nums[mid] == target`, we record the index and continue searching the right half (`start = mid + 1`).
3. **Refactoring:** By passing a `boolean isFirstOccurence`, we toggle which half to search next, keeping the code **DRY (Don't Repeat Yourself)**.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝙡𝙤𝙜 𝙣) — Two binary search passes.
* **Space Complexity:** 𝙊(𝟭) — Constant space used for pointers and indices.

## 💻 Implementation (Java)
```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        // Refactored approach: Using a single helper method with a boolean toggle
        ans[0] = search(nums, target, true);
        ans[1] = search(nums, target, false);

        return ans;
        
        /* Original Thought Process (Two separate methods):
        int first = firstOccurrence(nums, target);
        int last = lastOccurrence(nums, target);
        return new int[]{first, last};
        */
    }

    // Helper method to handle both first and last occurrence logic
    int search(int[] nums, int target, boolean isFirstOccurence) {
        int len = nums.length;
        int start = 0;
        int end = len - 1;
        int ans = -1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                // Potential answer found
                ans = mid;
                if (isFirstOccurence) {
                    end = mid - 1; // Keep searching left for the start
                } else {
                    start = mid + 1; // Keep searching right for the end
                }
            }
        }
        return ans;
    }

    /*
    // PREVIOUS VERSION (Before Refactoring)
    
    int firstOccurrence(int[] nums, int target) {
        int start = 0, end = nums.length - 1, res = -1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) { res = mid; end = mid - 1; }
            else if(nums[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return res;
    }

    int lastOccurrence(int[] nums, int target) {
        int start = 0, end = nums.length - 1, res = -1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) { res = mid; start = mid + 1; }
            else if(nums[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return res;
    }
    */
}
