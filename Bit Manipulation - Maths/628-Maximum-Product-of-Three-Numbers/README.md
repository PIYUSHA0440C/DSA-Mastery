# 628. Maximum Product of Three Numbers (Easy)

## 📝 Problem Statement
Given an integer array `nums`, find three numbers whose product is maximum and return the maximum product.

## 💡 Intuition & Approach
The maximum product isn't always just the product of the three largest numbers. If the array contains negative numbers, the product of two very small negative numbers (which becomes a large positive) and the largest positive number could be greater.

### 🛠️ The Strategy:
1. **Sort the Array:** Sorting helps us easily identify the smallest and largest values.
2. **Consider Two Scenarios:**
   - **Scenario 1:** The three largest numbers: `nums[n-1] * nums[n-2] * nums[n-3]`.
   - **Scenario 2:** Two smallest negatives and the largest positive: `nums[0] * nums[1] * nums[n-1]`.
3. **Comparison:** Return the maximum of these two values.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻 𝗹𝗼𝗴 𝗻) - Due to the `Arrays.sort()` function.
* **Space Complexity:** 𝙊(𝗹𝗼𝗴 𝗻) - Sorting algorithms like Dual-Pivot Quicksort used by Java typically use $O(\log n)$ stack space.

## 💻 Implementation (Java)
```java
class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        // Case 1: Product of the three largest numbers
        int option1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
        
        // Case 2: Product of the two smallest (negatives) and the largest
        int option2 = nums[0] * nums[1] * nums[n - 1];

        return Math.max(option1, option2);
    }
}
