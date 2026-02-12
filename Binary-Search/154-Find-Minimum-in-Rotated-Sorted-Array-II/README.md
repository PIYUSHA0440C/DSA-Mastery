# 154. Find Minimum in Rotated Sorted Array II (Hard)

## 📝 Problem Statement
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand. The array may contain duplicates. Find the minimum element.

## 💡 Intuition & Approach
This is an advanced variation of Binary Search. In a standard rotated sorted array, we can compare `mid` with `end` to decide which half to discard. However, with **duplicates**, if `nums[start] == nums[mid] == nums[end]`, we lose the ability to tell which side is sorted.

### 🛠️ The Strategy:
1. **Pivot Search:** We search for the point where the property of ascending order breaks ($nums[i] > nums[i+1]$).
2. **Handling Duplicates:** - If `start`, `mid`, and `end` elements are the same, we check if `start` or `end` are the pivots.
   - If not, we increment `start` and decrement `end` to narrow the window. This is the "Hard" part of the problem.
3. **Binary Search Logic:** - If the left part is sorted ($nums[start] < nums[mid]$), the pivot (and thus the minimum) must be in the right half.
   - Otherwise, search the left half.
4. **Edge Case:** If no pivot is found, the array was rotated $n$ times (meaning it's back to original sorted order), so return `nums[0]`.



## 📊 Complexity Analysis
* **Time Complexity:** - **Average Case:** $O(\log n)$ - Standard binary search performance.
  - **Worst Case:** $O(n)$ - Occurs when almost all elements are duplicates (e.g., `[2, 2, 2, 0, 2]`), forcing us to shrink the array one by one.
* **Space Complexity:** $O(1)$ - Only a few pointers are used.

## 💻 Implementation (Java)
```java
class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        int pivotIndex = findPivot(nums, start, end);
        // If no pivot found, the first element is the minimum
        if (pivotIndex == -1) return nums[0];
        return nums[pivotIndex];
    }

    private int findPivot(int[] nums, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Check if mid or mid+1 is the pivot
            if (mid < end && nums[mid] > nums[mid + 1]) return mid + 1;
            if (mid > start && nums[mid] < nums[mid - 1]) return mid;

            // Handle duplicates: skip them but check if they were the pivot
            if (nums[mid] == nums[start] && nums[mid] == nums[end]) {
                if (start < end && nums[start] > nums[start + 1]) return start + 1;
                start++;
                if (end > start && nums[end] < nums[end - 1]) return end;
                end--;
            } 
            // Standard rotated binary search logic
            else if (nums[start] < nums[mid] || (nums[start] == nums[mid] && nums[mid] > nums[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
