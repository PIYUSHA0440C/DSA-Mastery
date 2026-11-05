# 1385. Find the Distance Value Between Two Arrays (Easy)

## 📝 Problem Statement

Given two integer arrays `arr1` and `arr2`, and an integer `d`, find the number of elements in `arr1` whose absolute difference from every element in `arr2` is strictly greater than `d`.

## 💡 Intuition & Approach

Sort `arr2` to efficiently check whether any element falls within the range `[val - d, val + d]` for each element in `arr1`.

Binary search helps determine whether such an element exists without checking every element individually.

## 🛠️ The Strategy:

1. Sort `arr2` in ascending order.
2. Traverse each element `val` in `arr1`.
3. Use binary search to check whether `arr2` contains an element in the range `[val - d, val + d]`.
4. If no element exists within that range, increment the distance value count.
5. Return the final count.

**Important:** Use `return distanceValue;` rather than `return distanceValue++;`, because post-increment returns the original value.

## 📊 Complexity Analysis

Let `n` be the length of `arr1` and `m` be the length of `arr2`.

- **Time Complexity:** O(m log m + n log m), for sorting `arr2` and performing binary search for each element of `arr1`.
- **Space Complexity:** O(log m) auxiliary space for Java's primitive array sorting implementation.

## 💻 Implementation (Java)

```java
class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int distanceValue = 0;

        Arrays.sort(arr2);

        for (int val: arr1) {
            if (isValid(arr2, val - d, val + d)) distanceValue++;
        }

        return distanceValue;
    }

    private boolean isValid(int[] arr, int low, int high) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] >= low && arr[mid] <= high) return false;
            else if (arr[mid] < low) left = mid + 1;
            else right = mid - 1;
        }

        return true;
    }
}
```
