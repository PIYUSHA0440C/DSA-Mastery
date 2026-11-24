
# 3411. Maximum Subarray With Equal Products (Easy)

## Problem Statement

Given an array of positive integers `nums`, find the length of the longest subarray satisfying:

`prod(arr) == lcm(arr) * gcd(arr)`

Where:
- `prod(arr)` is the product of all elements.
- `gcd(arr)` is the greatest common divisor of all elements.
- `lcm(arr)` is the least common multiple of all elements.

Return the maximum length of such a subarray.

## Intuition & Approach

The key observation is that for subarrays of length three or more, the product-equivalent condition holds when all elements are pairwise coprime.

We can use a **sliding window** to maintain a window in which every element is coprime with the product of the previous elements.

Maintain:
- `prodVal`: Product of all elements in the current window.
- `start`: Starting index of the window.
- `end`: Ending index of the window.

For each new element, calculate the GCD of `prodVal` and the current element.

If their GCD is greater than 1, they share a common factor. Remove elements from the beginning of the window by dividing them out of `prodVal` until the current element becomes coprime with the remaining product.

Then include the current element, update the product, and calculate the maximum window length.

The initial answer is set to `2` because any subarray containing exactly two positive integers satisfies the product-equivalent condition.

## Strategy

1. Initialize the maximum length to `2` and the current product to `1`.
2. Expand the window using the `end` pointer.
3. While the GCD of the current product and the incoming element is greater than `1`, shrink the window from the left.
4. Divide the removed element from the current product.
5. Multiply the incoming element into the current product.
6. Update the maximum window length.
7. Return the result.

## Complexity Analysis

- **Time Complexity:** O(n log M), where M is the maximum value of an element. Each element enters and leaves the sliding window at most once, and each GCD calculation takes logarithmic time.
- **Space Complexity:** O(1) - Only a constant amount of extra space is used.

## Java Solution

```java id="d1a4f7"
class Solution {
    public int maxLength(int[] nums) {
        int res = 2;
        int prodVal = 1;
        int n = nums.length;
        int start = 0, end = 0;

        while (end < n) {
            while (gcd(prodVal, nums[end]) > 1) {
                prodVal /= nums[start];
                start++;
            }

            prodVal *= nums[end];
            res = Math.max(res, end - start + 1);
            end++;
        }

        return res;
    }

    private int gcd(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1;
            num1 = num2;
            num2 = temp % num2;
        }

        return num1;
    }
}
```

## Key Takeaway

Combining a sliding window with GCD helps maintain a window of pairwise coprime elements efficiently, avoiding the need to calculate the product, GCD, and LCM separately for every subarray.
