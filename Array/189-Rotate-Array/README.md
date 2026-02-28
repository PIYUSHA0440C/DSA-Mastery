# 189. Rotate Array (Medium)

## 📝 Problem Statement
Given an integer array `nums`, rotate the array to the right by `k` steps, where `k` is non-negative.

## 💡 Intuition & Approach
Rotating an array can be thought of as moving a suffix of the array to the front. The "Reversal Algorithm" is a three-step process that achieves this in-place.

### 🛠️ The Strategy:
1. **Handle k:** Since rotating an array of length `n` by `n` steps results in the same array, we use `k %= n` to handle cases where `k > n`.
2. **The Reversal Logic:**
   - **Step 1:** Reverse the entire array. This moves the elements that should be at the front to the beginning, but in the wrong order.
   - **Step 2:** Reverse the first `k` elements to restore their original relative order.
   - **Step 3:** Reverse the remaining `n - k` elements to restore their relative order.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We traverse each element exactly twice (once in the full reverse, once in the partial reverse).
* **Space Complexity:** 𝙊(𝟭) - No extra space is used; the rotation happens in-place.

## 💻 Implementation (Java)
```java
class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len; // Optimization for k > length

        // 1. Reverse the whole array
        reverse(nums, 0, len - 1);
        // 2. Reverse the first k elements
        reverse(nums, 0, k - 1);
        // 3. Reverse the rest
        reverse(nums, k, len - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
