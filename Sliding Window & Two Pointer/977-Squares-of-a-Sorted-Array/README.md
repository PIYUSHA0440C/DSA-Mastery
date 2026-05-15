# 977. Squares of a Sorted Array (Easy)

## 📝 Problem Statement
Given an integer array `nums` sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

## 💡 Intuition & Approach
The input array is already sorted, but negative numbers become positive when squared, which can flip their relative order (e.g., `-4` becomes `16`, while `3` becomes `9`). 

Since the largest squares will always be at the edges of the original array, we can use a **Two-Pointer** approach to compare the squares at both ends and build the result array from largest to smallest.

### 🛠️ The Strategy:
1. **Initialize Two Pointers:** `left` at the start (0) and `right` at the end (`n-1`).
2. **Result Array:** Create a new array `res` and an index `idx` pointing to the last position.
3. **Compare & Fill:**
   - Square the values at `left` and `right`.
   - Place the larger square at `res[idx]`.
   - Move the pointer (`left++` or `right--`) and decrement `idx`.
4. **Continue** until all elements are processed ($O(n)$).

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - Each element is visited exactly once.
* **Space Complexity:** 𝙊(𝟭) - Excluding the output array, we only use constant extra space for pointers.

## 💻 Implementation (Java)
```java
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 0, right = n - 1;
        int idx = n - 1;

        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                res[idx--] = leftSquare;
                left++;
            } else {
                res[idx--] = rightSquare;
                right--;
            }
        }
        return res;
    }
}
