# 1679. Max Number of K-Sum Pairs (Medium)

## 📝 Problem Statement

Given an integer array `nums` and an integer `k`, in one operation, you can pick two numbers from the array whose sum equals `k` and remove them.

Return the maximum number of operations that can be performed.

## 💡 Intuition & Approach

After sorting the array, we can use the **two-pointer technique** to efficiently find pairs whose sum equals `k`.

### 🛠️ The Strategy:

1. Sort the array.
2. Initialize two pointers:
   - `left` at the beginning.
   - `right` at the end.
3. Calculate the sum of the two pointed elements.
4. If the sum equals `k`, a valid pair is found:
   - Increment `left`.
   - Decrement `right`.
   - Increment the operation count.
5. If the sum is less than `k`, move `left` forward to increase the sum.
6. If the sum is greater than `k`, move `right` backward to decrease the sum.
7. Continue until the two pointers meet.

## 📊 Complexity Analysis

- **Time Complexity:** `O(n log n)` due to sorting.
- **Space Complexity:** `O(log n)` for the sorting implementation's stack space.

## 💻 Implementation (Java)

```java
class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        int operations = 0;

        while(left < right){
            int currentSum = nums[left] + nums[right];

            if (currentSum == k){
                operations++;
                left++;
                right--;
            } else if (currentSum < k){
                left++;
            } else {
                right--;
            }
        }

        return operations;
    }
}
```
