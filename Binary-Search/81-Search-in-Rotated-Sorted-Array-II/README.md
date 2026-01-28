# 81. Search in Rotated Sorted Array II (Medium)

## 📝 Problem Statement
There is an integer array `nums` sorted in non-decreasing order that is rotated at an unknown pivot index. Unlike the first version of this problem, **nums may contain duplicates**.

Given the rotated array and a `target`, return `true` if the target is in `nums`, or `false` otherwise.



## 💡 Intuition & Approach
The presence of duplicates introduces a specific edge case: what if `nums[start] == nums[mid] == nums[end]`? In this scenario, we cannot determine which half of the array is sorted.

### 🛠️ The Strategy:
1. **Handle Duplicates:** If `start`, `mid`, and `end` elements are equal, we simply shrink the search space from both ends (`start++`, `end--`) until we find a clear slope.
2. **Identify Sorted Half:** - If `nums[start] <= nums[mid]`, the **left** side is sorted. We check if the target lies within this range.
   - Otherwise, the **right** side must be sorted. We check if the target lies within the right range.
3. **Binary Search:** Continue narrowing the search space in $O(\log n)$ time for most cases.

## 📊 Complexity Analysis
* **Time Complexity:** - **Average Case:** 𝙊(𝙡𝙤𝙜 𝙣)
  - **Worst Case:** 𝙊(𝙣) - This happens when all elements are duplicates (e.g., `[1, 1, 1, 1, 1]`), forcing the algorithm to check every element.
* **Space Complexity:** 𝙊(𝟭) - No extra data structures are used.

## 💻 Implementation (Java)
```java
class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) return true;

            // EDGE CASE: Handling duplicate values at start, mid, and end
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start++;
                end--;
            }
            // Check if the left side is sorted
            else if (nums[start] <= nums[mid]) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            // Otherwise, the right side is sorted
            else {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }
}
