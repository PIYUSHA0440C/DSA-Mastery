# 2574. Left and Right Sum Differences (Easy)

## 📝 Problem Statement
You are given a 0-indexed integer array `nums`. Define two arrays `leftSum` and `rightSum` where `leftSum[i]` is the sum of elements to the left of index `i` and `rightSum[i]` is the sum of elements to the right of index `i` (excluding the element at `i` itself). Return an integer array `answer` where `answer[i] = |leftSum[i] - rightSum[i]|`.

## 💡 Intuition & Approach
The literal interpretation of the problem asks you to construct two independent prefix and suffix sum arrays, which costs extra $O(N)$ memory. However, we can optimize this to constant auxiliary space using a **Prefix Running Sum** technique.

The total sum of the array is composed of three sections at any index `i`: the elements to the left (`leftSum`), the current element (`nums[i]`), and the elements to the right (`rightSum`). 

### 🛠️ The Strategy:
1. **Precompute Total:** Run an initial fast loop to accumulate all values into `rightSum`. At this point, `rightSum` represents the sum of the entire array.
2. **Dynamic Transfer:** Iterate through the array sequentially:
   - Before evaluating index `i`, subtract `nums[i]` from `rightSum`. Now, `rightSum` holds exactly the sum of all elements to the strict right of index `i`.
   - Calculate the absolute difference between our running `leftSum` and updated `rightSum`, storing it directly in `answer[i]`.
   - Add the current `nums[i]` to `leftSum` so it is ready to act as a valid prefix boundary for the next index.

## 📊 Complexity Analysis
* **Time Complexity:** O(N) - We perform two consecutive linear passes over the array: one to compute the total sum and one to update the running segments.
* **Space Complexity:** O(1) - Excluding the output array `answer` required by the problem description, the calculations are managed entirely with a few primitive tracking variables.

## 💻 Implementation (Java)
```java
class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int rightSum = 0;
        int leftSum = 0;
        int[] answer = new int[n];

        // Step 1: Calculate the total sum of all elements initially
        for (int num : nums) {
            rightSum += num;
        }

        // Step 2: Dynamically balance left and right sums in a single pass
        for (int i = 0; i < n; i++) {
            // Remove current element from right side to make it strict suffix
            rightSum -= nums[i];

            // Compute absolute delta
            answer[i] = Math.abs(leftSum - rightSum);

            // Add current element to left side to prepare for next prefix step
            leftSum += nums[i];
        }

        return answer;
    }
}
