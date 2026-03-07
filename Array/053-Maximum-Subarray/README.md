# 53. Maximum Subarray (Medium)

## 📝 Problem Statement
Given an integer array `nums`, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

## 💡 Intuition & Approach: Kadane's Algorithm
This problem is a classic application of **Dynamic Programming/Greedy logic**. Instead of checking all $O(n^2)$ possible subarrays, we make an optimal decision at each index in $O(n)$.

### 🛠️ The Strategy:
1. **Initialize:** Start both `maxSum` and `currentSum` with the first element of the array.
2. **Iterate:** Starting from the second element, for each `nums[i]`:
   - **Local Decision:** Decide whether to add the current element to the existing sequence or start a new sequence from the current element. 
   - `currentSum = Math.max(nums[i], currentSum + nums[i])`
3. **Global Update:** Update the `maxSum` if the `currentSum` we just calculated is the highest we've seen so far.
4. **Efficiency:** This allows us to find the maximum sum in a single pass without nested loops.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We traverse the array exactly once.
* **Space Complexity:** 𝙊(𝟭) - Only two variables are used to store the state.

## 💻 Implementation (Java)
```java
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            // Local Optimal: Should we start fresh or carry the previous sum?
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            
            // Global Optimal: Is our current streak the best one yet?
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
