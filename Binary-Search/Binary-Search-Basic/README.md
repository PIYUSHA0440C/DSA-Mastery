# 704. Binary Search (Easy)

## 📝 Problem Statement
Given an array of integers `nums` which is sorted in ascending order, and an integer `target`, write a function to search `target` in `nums`. If `target` exists, then return its index. Otherwise, return `-1`.

You must write an algorithm with **O(log n)** runtime complexity.



## 💡 Intuition & Approach
Since the array is **sorted**, we can find the target much faster than a linear scan by using **Binary Search**.

1. **Initialize:** Set two pointers, `start` at 0 and `end` at the last index.
2. **Calculate Mid:** Find the middle index using `mid = start + (end - start) / 2` (this prevents integer overflow).
3. **Compare:**
   - If `nums[mid]` is the target, return the index.
   - If the target is larger than `mid`, discard the left half (`start = mid + 1`).
   - If the target is smaller than `mid`, discard the right half (`end = mid - 1`).
4. **Result:** If the loop ends and we haven't found the target, return `-1`.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝙡𝙤𝙜 𝙣) — The search space is halved every time.
* **Space Complexity:** 𝙊(𝟭) — Only a few variables are used.

## 💻 Code (Java)
```java
class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        
        while(start <= end){
            int mid = start + (end - start) / 2;
            
            if (target > nums[mid]) {
                start = mid + 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
