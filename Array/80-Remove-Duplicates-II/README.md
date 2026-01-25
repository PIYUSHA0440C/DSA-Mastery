# Remove Duplicates from Sorted Array II (LeetCode 80)

## 📝 Problem Description
Given an integer array `nums` sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears **at most twice**. The relative order of the elements should be kept the same.

You must do this by modifying the input array **in-place** with $O(1)$ extra memory.



## 💡 Intuition
Since the array is already sorted, all duplicates are adjacent. To allow a maximum of two occurrences, we only need to check if the current element we want to add is different from the element placed **two positions ago**.

## 🚀 Approach: Two-Pointer Technique
1. Use a pointer `k` to track the position of the next "valid" element.
2. Iterate through the array with pointer `i`.
3. For each element `nums[i]`, check if:
   - `k < 2`: We haven't filled the first two slots yet.
   - `nums[i] != nums[k-2]`: The current element is not a "third" duplicate.
4. If either condition is true, update `nums[k]` and increment `k`.

## 📊 Complexity Analysis
- **Time Complexity:** $O(n)$ - We iterate through the array once.
- **Space Complexity:** $O(1)$ - No extra space used, modifications are in-place.

## 💻 Implementation (Java)
```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (k < 2 || nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
