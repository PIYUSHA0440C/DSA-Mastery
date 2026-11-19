
# 2567. Minimum Score by Changing Two Elements (Medium)

## 📝 Problem Statement

Given an integer array, the score is defined as the sum of:

- **High Score:** Maximum absolute difference between any two elements.
- **Low Score:** Minimum absolute difference between any two elements.

We can change at most two elements to any integer values. Return the minimum possible score after these changes.

## 💡 Intuition & Approach

The key observation is that sorting the array allows us to calculate the minimum possible range after modifying two elements.

Since we can change two elements, there are only three optimal possibilities to consider:

1. Change the two largest elements, leaving the range from `nums[0]` to `nums[n-3]`.
2. Change the smallest and largest elements, leaving the range from `nums[1]` to `nums[n-2]`.
3. Change the two smallest elements, leaving the range from `nums[2]` to `nums[n-1]`.

We can calculate all three possibilities and return the minimum range.

The minimum possible low score is always zero because we can make at least two elements equal. Therefore, minimizing the overall score comes down to minimizing the remaining range.

## 🛠️ The Strategy

1. Sort the array in ascending order.
2. Calculate the range after changing the two largest elements.
3. Calculate the range after changing the smallest and largest elements.
4. Calculate the range after changing the two smallest elements.
5. Return the minimum of these three differences.

## 📊 Complexity Analysis

- **Time Complexity:** O(n log n) - Sorting the array dominates the execution time.
- **Space Complexity:** O(1) auxiliary space, excluding the sorting implementation's internal space requirements.

## 💻 Implementation (Java)

```java
class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        return Math.min(
            Math.min(
                nums[n - 3] - nums[0],
                nums[n - 2] - nums[1]
            ),
            nums[n - 1] - nums[2]
        );
    }
}
```
