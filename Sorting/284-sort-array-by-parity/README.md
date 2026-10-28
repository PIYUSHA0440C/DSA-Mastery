# 905. Sort Array By Parity (Easy)

## 📝 Problem Statement

Given an integer array `nums`, move all even integers to the beginning and all odd integers to the end. Return any array that satisfies this condition.

## 💡 Intuition & Approach

Use two pointers starting at opposite ends of the array. Move the left pointer past even numbers and the right pointer past odd numbers. When both pointers stop at misplaced elements, swap them.

### 🛠️ The Strategy:

1. Initialize `i` at the beginning and `j` at the end of the array.
2. Move `i` forward while it points to an even number.
3. Move `j` backward while it points to an odd number.
4. If `i` is still less than `j`, swap the elements at these positions.
5. Repeat until the pointers meet or cross, then return the modified array.

## 📊 Complexity Analysis

- **Time Complexity:** O(n), as each pointer traverses the array at most once overall.
- **Space Complexity:** O(1), since the array is rearranged in place using constant extra space.

## 💻 Implementation (Java)

```java
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i = 0, j = nums.length - 1;
        
        while (i < j) {
            while (i < j && nums[i] % 2 == 0) i++;
            while (i < j && nums[j] % 2 == 1) j--;

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        return nums;
    }
}
```
