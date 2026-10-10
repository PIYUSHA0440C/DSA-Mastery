# 16. 3Sum Closest (Medium)

## 📝 Problem Statement

Given an integer array `nums` and an integer `target`, find three integers at distinct indices whose sum is closest to `target`.

Return the sum of those three integers.

## 💡 Intuition & Approach

Sorting the array allows us to use the two-pointer technique to efficiently search for sums.

For each element, we fix it as the first number and initialize two pointers: `left` immediately after the fixed element and `right` at the end of the array.

We calculate the sum of the three numbers and update `result` whenever the current sum is closer to the target than the best sum found so far.

If the sum is smaller than the target, we move `left` forward to increase the sum. Otherwise, we move `right` backward to decrease it. If the sum equals the target, we return it immediately.

### 🛠️ The Strategy:

1. Sort the array.
2. Initialize `result` with the sum of the first three elements.
3. Iterate through the array, fixing one element at a time.
4. Use two pointers to find the closest sum from the remaining elements.
5. Update `result` whenever a closer sum is found.
6. Move `left` forward if the sum is below the target; otherwise, move `right` backward.
7. Return immediately if the target is matched, or return the closest sum after the search.

## 📊 Complexity Analysis

- **Time Complexity:** O(n²), dominated by the two-pointer search.
- **Space Complexity:** O(log n) auxiliary space for Java's primitive-array sorting implementation, excluding sorting implementation details.

## 💻 Implementation (Java)

```java
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int result = nums[0] + nums[1] + nums[2];
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == target) return target;

                if (Math.abs(target - sum) < Math.abs(target - result)) {
                    result = sum;
                }

                if (sum < target) left++;
                else right--;
            }
        }

        return result;
    }
}
```
