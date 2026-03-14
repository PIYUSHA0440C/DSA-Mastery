# 1863. Sum of All Subset XOR Totals (Easy)

## 📝 Problem Statement
The XOR total of an array is the bitwise XOR of all its elements. Given an array `nums`, return the sum of all XOR totals for every subset of `nums`.

## 💡 Intuition & Approach
Since we need to calculate a value for every possible subset, we can use a recursive **inclusion-exclusion** pattern.

### 🛠️ The Strategy:
1. **Recursive Branching:** At each index in the array, we have two choices:
   - **Include** the current number in the XOR sum: `currentXor ^ nums[index]`
   - **Exclude** the current number: Keep `currentXor` as is.
2. **Base Case:** When we reach the end of the array (`index == nums.length`), we return the `currentXor` accumulated for that specific subset.
3. **Aggregation:** The total sum is the result of `withElement + withoutElement` at each level of the recursion tree.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝟮ⁿ) - There are $2^n$ possible subsets, and we visit each one once.
* **Space Complexity:** 𝙊(𝗻) - The maximum depth of the recursion stack is equal to the length of the array.

## 💻 Implementation (Java)
```java
class Solution {
    public int subsetXORSum(int[] nums) {
        return helper(nums, 0, 0);
    }
    
    int helper(int[] nums, int index, int currentXor) {
        // Base case: processed all elements
        if (index == nums.length) return currentXor;
        
        // Choice 1: Include the current element in the XOR sum
        int withElement = helper(nums, index + 1, currentXor ^ nums[index]);
        
        // Choice 2: Exclude the current element
        int withoutElement = helper(nums, index + 1, currentXor);
        
        // Return the sum of both possibilities
        return withElement + withoutElement;
    }
}
