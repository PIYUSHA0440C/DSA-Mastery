# 414. Third Maximum Number (Easy)

## 📝 Problem Statement

Given an integer array `nums`, return the third distinct maximum number. If the third distinct maximum does not exist, return the maximum number.

## 💡 Intuition & Approach

First, sort the array in ascending order so the largest values appear at the end.

We start from the last index and track distinct values using `ans`. The variable `count` tracks how many additional distinct values are needed to reach the third maximum.

Whenever we encounter a value different from `ans`, we update `ans` and decrease `count`. Once two additional distinct values have been found, `ans` holds the third distinct maximum.

If fewer than three distinct values exist, we return the maximum element instead.

### 🛠️ The Strategy:

1. Sort the array in ascending order.
2. Initialize `ans` to the maximum element and `count` to `2`.
3. Traverse backward, skipping duplicate values.
4. Update `ans` and decrement `count` whenever a new distinct value is found.
5. If two additional distinct values are not found, return the maximum element.
6. Otherwise, return `ans`.

## 📊 Complexity Analysis

- **Time Complexity:** O(n log n), due to sorting.
- **Space Complexity:** O(log n) auxiliary space for Java's primitive-array sorting implementation.

## 💻 Implementation (Java)

```java
class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);

        int index = nums.length - 1;
        int count = 2;

        int ans = nums[index];

        if(index < 2) return ans;

        while(index >= 0 && count > 0){
            if(nums[index] != ans){
                ans = nums[index];
                count--;
            }

            index--;
        }

        if(count > 0) return nums[nums.length - 1];

        return ans;
    }
}
```
