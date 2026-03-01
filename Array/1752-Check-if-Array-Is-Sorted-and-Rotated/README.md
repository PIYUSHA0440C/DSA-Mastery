# 1752. Check if Array Is Sorted and Rotated (Easy)

## 📝 Problem Statement
Given an array `nums`, return `true` if the array was originally sorted in non-decreasing order and then rotated some number of positions. Otherwise, return `false`.

## 💡 Intuition & Approach
In a sorted array, every element is $\leq$ the next element. When you rotate that array, you create exactly one point where the order "breaks" (the largest element is followed by the smallest).

### 🛠️ The Strategy:
1. **Count the Breaks:** Iterate through the array and compare `nums[i]` with the next element `nums[i+1]`.
2. **Circular Check:** To check if the last element is $\leq$ the first element (the final wrap-around of the rotation), use the modulo operator: `nums[(i + 1) % len]`.
3. **The Rule:** - If the count of breaks is **0**, the array is sorted and not rotated (or rotated by 0).
   - If the count of breaks is **1**, the array is sorted and rotated.
   - If the count of breaks is **> 1**, it's impossible for it to have been a single sorted array.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We perform a single pass through the array.
* **Space Complexity:** 𝙊(𝟭) - Only a few integer variables are used.

## 💻 Implementation (Java)
```java
class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            // Check if current element is greater than the next (circularly)
            if (nums[i] > nums[(i + 1) % len]) {
                count++;
            }
        }

        // A sorted and rotated array can have at most one such "drop"
        return count <= 1;
    }
}
