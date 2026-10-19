# 2089. Find Target Indices After Sorting Array (Easy)

## 📝 Problem Statement

Given an integer array `nums` and a target value `target`, return the indices where `target` appears after sorting the array in non-decreasing order. Return the indices in increasing order.

## 💡 Intuition & Approach

Instead of sorting the array, count how many elements are smaller than the target and how many elements equal the target.

All elements smaller than the target appear before it in the sorted array. Therefore, the first target index equals the count of elements smaller than the target. If the target appears multiple times, its indices are consecutive.

### 🛠️ The Strategy:

1. Traverse the array and count elements smaller than `target`.
2. Count how many elements equal `target`.
3. Create an empty result list.
4. Starting from the count of smaller elements, add `targetCount` consecutive indices to the result.
5. Return the result list.

## 📊 Complexity Analysis

- **Time Complexity:** O(n), where `n` is the length of the array.
- **Space Complexity:** O(k), where `k` is the number of occurrences of the target, for the result list. The auxiliary space excluding the output is O(1).

## 💻 Implementation (Java)

```java
class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int lessThanTargetCount = 0;
        int targetCount = 0;

        for (int num: nums) {
            if (num == target) targetCount++;
            else if (num < target) lessThanTargetCount++;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < targetCount; i++) {
            result.add(lessThanTargetCount + i);
        }

        return result;
    }
}
```
