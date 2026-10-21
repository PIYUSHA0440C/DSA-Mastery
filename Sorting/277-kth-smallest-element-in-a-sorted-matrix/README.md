# 378. Kth Smallest Element in a Sorted Matrix (Medium)

## 📝 Problem Statement

Given an `n x n` matrix with rows and columns sorted in ascending order, return the kth smallest element. Duplicate values count separately.

## 💡 Intuition & Approach

The matrix is sorted by rows and columns, but the elements across the entire matrix are not necessarily in sorted order. Flattening the matrix into a one-dimensional array and sorting it makes finding the kth smallest element straightforward.

### 🛠️ The Strategy:

1. Create an array of size `n * n`.
2. Copy every matrix element into the array.
3. Sort the array using `Arrays.sort()`.
4. Return the element at index `k - 1`.

## 📊 Complexity Analysis

- **Time Complexity:** O(n² log n), where `n` is the matrix dimension.
- **Space Complexity:** O(n²) for the additional array.

**Note:** This approach does not satisfy the problem's requirement of using less than O(n²) memory. A min-heap or binary search approach can improve the auxiliary space usage.

## 💻 Implementation (Java)

```java
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int[] arr = new int[matrix.length * matrix.length];
        int idx = 0;

        for (int[] temp : matrix){
            for (int num: temp){
                arr[idx++] = num;
            }
        }

        Arrays.sort(arr);

        return arr[k - 1];
    }
}
```
