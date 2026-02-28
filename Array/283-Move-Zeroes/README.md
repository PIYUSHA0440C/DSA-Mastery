# 283. Move Zeroes (Easy)

## 📝 Problem Statement
Given an integer array `nums`, move all `0`s to the end of it while maintaining the relative order of the non-zero elements. This must be done in-place.

## 💡 Intuition & Approach
The goal is to effectively "bubble" non-zero elements to the front. We use two pointers: one to explore the array (`i`) and one to track the position of the next non-zero element (`j`).

### 🛠️ The Strategy:
1. **Pointer `j`:** Represents the boundary where the next non-zero number should be placed.
2. **Pointer `i`:** Scans through the entire array.
3. **The Swap/Move:** - When `nums[i]` is non-zero, it needs to move to index `j`.
   - If `i` and `j` are different, we assign `nums[j] = nums[i]` and then "clean up" by setting `nums[i] = 0`.
   - Increment `j` only when a non-zero element is processed.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We traverse the array exactly once.
* **Space Complexity:** 𝙊(𝟭) - Operations are done in-place without extra storage.

## 💻 Implementation (Java)
```java
class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0; // The write pointer
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // If i == j, no need to do anything, just increment j
                if (i != j) {
                    nums[j] = nums[i];
                    nums[i] = 0; // Set current to 0 after moving its value forward
                }
                j++;
            }
        }
    }
}
