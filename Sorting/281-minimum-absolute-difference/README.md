# 1200. Minimum Absolute Difference (Easy)

## 📝 Problem Statement

Given an array of distinct integers, find all pairs with the minimum absolute difference. Each pair must be in ascending order, and the resulting list must also be sorted in ascending order.

## 💡 Intuition & Approach

After sorting the array, the minimum absolute difference must occur between adjacent elements. Comparing adjacent pairs allows us to find the smallest difference and collect every pair that achieves it.

### 🛠️ The Strategy:

1. Sort the array in ascending order.
2. Initialize `minDiff` to `Integer.MAX_VALUE` and create an empty result list.
3. Iterate through adjacent elements and calculate their difference.
4. If a smaller difference is found, update `minDiff`, clear the previous results, and add the current pair.
5. If the difference equals `minDiff`, add the current pair to the result.
6. Return the result list.

## 📊 Complexity Analysis

- **Time Complexity:** O(n log n), dominated by sorting.
- **Space Complexity:** O(n) auxiliary space in the worst case for storing the result pairs, excluding sorting space.

## 💻 Implementation (Java)

```java
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        List<List<Integer>> result = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {
            int currentDiff = arr[i + 1] - arr[i];

            if (currentDiff < minDiff) {
                minDiff = currentDiff;
                result.clear();
                result.add(Arrays.asList(arr[i], arr[i + 1]));
            }

            else if (currentDiff == minDiff) {
                result.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }

        return result;
    }
}
```
