# 268. Missing Number (Easy)

## 📝 Problem Statement
Given an array `nums` containing `n` distinct numbers in the range `[0, n]`, return the only number in the range that is missing from the array.

**Follow-up:** Implement a solution with **O(1)** extra space and **O(n)** runtime complexity.



## 💡 Intuition & Approach
I explored two different ways to achieve the optimal $O(n)$ time and $O(1)$ space complexity.

### 🛠️ The Strategy:
1. **Mathematical Approach (Gauss Sum):**
   - The sum of all numbers in the range $[0, n]$ can be calculated using the formula: $$\frac{n(n+1)}{2}$$
   - By calculating this "ideal" sum and subtracting the actual sum of the elements in the array, the remainder is the missing number.
   
2. **Alternative: Cyclic Sort (Commented in code):**
   - Since the numbers are in a known range $[0, n]$, we can try to place every number at its correct index (e.g., `0` at index `0`, `1` at index `1`).
   - After sorting, the first index `i` where `nums[i] != i` is our missing number.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We traverse the array once to find the sum.
* **Space Complexity:** 𝙊(𝟭) - Only two integer variables are used for the sums.

## 💻 Implementation (Java)
```java
class Solution {
    public int missingNumber(int[] nums) {
        int length = nums.length;
        int totalSum = 0, arraySum = 0;
        
        // Summing up all elements present in the array
        for(int num : nums){
            arraySum += num;
        }
        
        // Gauss Sum Formula: n * (n + 1) / 2
        totalSum = (length) * (length + 1) / 2;
        
        // The difference is the missing number
        return totalSum - arraySum;
    }
}
