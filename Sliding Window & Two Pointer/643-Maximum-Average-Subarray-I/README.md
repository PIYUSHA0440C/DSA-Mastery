# 643. Maximum Average Subarray I (Easy)

## 📝 Problem Statement

You are given an integer array `nums` and an integer `k`. Find a contiguous subarray whose length is exactly `k` that has the maximum average value and return this value.

## 💡 Intuition & Approach

Since the required subarray always has a fixed length `k`, we can use a **sliding window** to efficiently calculate the sum of every possible subarray of length `k`.

### 🛠️ The Strategy:

1. Calculate the sum of the first `k` elements.
2. Store it as the maximum sum.
3. Slide the window across the array:
   - Subtract the element leaving the window.
   - Add the new element entering the window.
   - Update the maximum sum.
4. Divide the maximum sum by `k` to get the maximum average.

## 📊 Complexity Analysis

- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(1)`

## 💻 Implementation (Java)

```java
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxSum;
        int currentSum = 0;

        int left = 0;
        int right = 0;

        while(right < k){
            currentSum += nums[right++];
        }
        
        maxSum = currentSum;

        while(right < nums.length){
            currentSum -= nums[left++];
            currentSum += nums[right++];

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum / k;
    }
}
```
