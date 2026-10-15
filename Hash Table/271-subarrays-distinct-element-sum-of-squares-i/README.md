# 2913. Subarrays Distinct Element Sum of Squares I (Easy)

## 📝 Problem Statement

Given an integer array `nums`, find the sum of the squares of the number of distinct elements in every non-empty contiguous subarray.

## 💡 Intuition & Approach

Start a subarray at each index and extend it one element at a time. Use a `HashSet` to track the distinct elements in the current subarray.

Whenever a new element is added, the set automatically handles duplicates. Add the square of the set's size to the result for every subarray.

### 🛠️ The Strategy:

1. Initialize the result to `0`.
2. Iterate through each index as the starting point of a subarray.
3. Create an empty `HashSet` for each starting index.
4. Extend the subarray by moving the ending index forward and add each element to the set.
5. Add `set.size() * set.size()` to the result for every subarray.
6. Return the final result.

## 📊 Complexity Analysis

- **Time Complexity:** O(n²), where `n` is the number of elements. The nested loops visit every subarray, and `HashSet` operations take O(1) on average.
- **Space Complexity:** O(n), for the `HashSet` in the worst case.

## 💻 Implementation (Java)

```java
class Solution {
    public int sumCounts(List<Integer> nums) {
        int res = 0;
        int n = nums.size();

        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();

            for (int j = i; j < n; j++) {
                set.add(nums.get(j));

                res += set.size() * set.size();
            }
        }

        return res;
    }
}
```
