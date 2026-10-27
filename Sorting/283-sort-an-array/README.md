# 912. Sort an Array (Medium)

## 📝 Problem Statement

Given an integer array `nums`, sort it in ascending order without using built-in sorting functions. The solution must achieve O(n log n) time complexity with minimal additional space.

## 💡 Intuition & Approach

Merge sort follows the divide-and-conquer approach. It repeatedly divides the array into smaller halves, sorts them recursively, and merges the sorted halves into a single sorted section.

### 🛠️ The Strategy:

1. Recursively divide the array until each subarray contains one element.
2. Find the middle index to split the current range into two halves.
3. Sort both halves using recursive calls.
4. Merge the sorted halves into a temporary array by comparing their elements.
5. Copy the merged elements back into the original array.
6. Return the sorted array.

## 📊 Complexity Analysis

- **Time Complexity:** O(n log n), as the array is divided into logarithmic levels and each level requires O(n) work.
- **Space Complexity:** O(n) for temporary merge arrays, plus O(log n) recursion stack space.

## 💻 Implementation (Java)

```java
class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void mergeSort(int[] nums, int start, int end) {
        if (start >= end) return;

        int mid = start + (end - start) / 2;

        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, end, mid);
    }

    public static void merge(int[] nums, int start, int end, int mid) {
        int temp[] = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= end) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) temp[k++] = nums[i++];

        while (j <= end) temp[k++] = nums[j++];

        for (k = 0, i = start; k < temp.length; k++, i++) {
            nums[i] = temp[k];
        }
    }
}
```
