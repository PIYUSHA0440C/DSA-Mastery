# 3105. Longest Strictly Increasing or Strictly Decreasing Subarray (Easy)

## 📝 Problem Statement

Given an integer array `nums`, find the length of the longest contiguous subarray that is either strictly increasing or strictly decreasing.

## 💡 Intuition & Approach

Use a single traversal while maintaining three variables:

- `incLength`: Length of the current strictly increasing subarray.
- `decLength`: Length of the current strictly decreasing subarray.
- `maxLength`: Maximum length found so far.

Compare each element with its previous element:

- If the current element is greater, increment `incLength` and reset `decLength` to 1.
- If the current element is smaller, increment `decLength` and reset `incLength` to 1.
- If both elements are equal, reset both lengths to 1 because neither strict trend can continue.

After each comparison, update `maxLength` using the larger of the increasing and decreasing lengths.

## 🛠️ The Strategy:

1. Initialize all three lengths to 1.
2. Traverse the array from index 1.
3. Compare each element with its previous element.
4. Extend the corresponding increasing or decreasing subarray.
5. Reset the opposite length, or both lengths when elements are equal.
6. Update the maximum length and return it.

## 📊 Complexity Analysis

- **Time Complexity:** O(n), where n is the array length. Each element is processed once.
- **Space Complexity:** O(1), as only three variables are used.

## 💻 Implementation (Java)

```java
class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int maxLength = 1;
        int incLength = 1;
        int decLength = 1;

        for (int index = 1; index < nums.length; index++) {
            if (nums[index] > nums[index - 1]) {
                incLength++;
                decLength = 1;
            } else if (nums[index] < nums[index - 1]) {
                decLength++;
                incLength = 1;
            } else {
                incLength = 1;
                decLength = 1;
            }

            maxLength = Math.max(maxLength, Math.max(incLength, decLength));
        }

        return maxLength;
    }
}
```
