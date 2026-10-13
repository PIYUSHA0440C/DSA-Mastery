# 3727. Maximum Alternating Sum of Squares (Medium)

## 📝 Problem Statement

Given an integer array `nums`, rearrange its elements to maximize the alternating score:

`score = arr[0]² - arr[1]² + arr[2]² - arr[3]² + ...`

Return the maximum possible alternating score after rearranging the elements.

## 💡 Intuition & Approach

Squaring every element makes all values non-negative, so the original signs do not affect the result. To maximize the score, place the largest squared values at positive positions and the smallest squared values at negative positions.

After sorting the squared values in ascending order, add the largest half and subtract the smallest half.

### 🛠️ The Strategy:

1. Square every element in the array.
2. Sort the squared values in ascending order.
3. Add the values in the upper half to the score.
4. Subtract the values in the lower half.
5. Return the resulting `long` score.

## 📊 Complexity Analysis

- **Time Complexity:** O(n log n), due to sorting.
- **Space Complexity:** O(log n) auxiliary space for Java primitive-array sorting.

## 💻 Implementation (Java)

```java
class Solution {
    public long maxAlternatingSum(int[] nums) {
        int len = nums.length;
        long score = 0;

        for(int i = 0; i < len; i++){
            nums[i] *= nums[i];
        }

        Arrays.sort(nums);

        for(int i = len / 2; i < len; i++){
            score += nums[i];
        }

        for(int i = 0; i < len / 2; i++){
            score -= nums[i];
        }

        return score;
    }
}
```
