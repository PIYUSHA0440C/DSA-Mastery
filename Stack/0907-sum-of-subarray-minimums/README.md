# 907. Sum of Subarray Minimums (Medium)

## 📝 Problem Statement

Given an integer array `arr`, find the sum of the minimum element of every contiguous subarray.

Since the answer can be very large, return it modulo **10⁹ + 7**.

---

## 💡 Intuition & Approach

A brute-force solution would generate every possible subarray, determine its minimum, and accumulate the result. This requires **O(n²)** or worse, which is too slow for the given constraints.

Instead, we calculate **how many subarrays consider each element as their minimum**.

For every element `arr[i]`, determine:

- The **Previous Smaller Element (PSE)** on its left.
- The **Next Smaller Element (NSE)** on its right.

These boundaries define the range in which `arr[i]` remains the minimum.

The number of subarrays where `arr[i]` is the minimum equals:

```
(i - left[i]) × (right[i] - i)
```

where:

- `left[i]` is the index of the previous smaller element.
- `right[i]` is the index of the next smaller element.

To efficiently compute these boundaries, we use **Monotonic Increasing Stacks**.

To correctly handle duplicate values:

- For the **left boundary**, remove elements **greater than or equal (`>=`)** to the current element.
- For the **right boundary**, remove elements **strictly greater (`>`)** than the current element.

This ensures every subarray is counted exactly once.

### 🛠️ The Strategy

1. **Find Previous Smaller Elements**
   - Traverse from left to right using a monotonic increasing stack.

2. **Find Next Smaller Elements**
   - Traverse from right to left using another monotonic increasing stack.

3. **Compute Contribution**
   - For every element, calculate:
     ```
     Left Choices × Right Choices × Current Value
     ```
   - Add the contribution to the final answer under modulo arithmetic.

4. **Return the Result**
   - Return the accumulated sum modulo `10⁹ + 7`.

---

## 📊 Complexity Analysis

- **Time Complexity:** **O(n)** - Each index is pushed and popped from the stack at most once.

- **Space Complexity:** **O(n)** - Arrays for previous/next smaller indices and the monotonic stack.

---

## 💻 Implementation (Java)

```java
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int length = arr.length;
        int[] left = new int[length];
        int[] right = new int[length];

        Arrays.fill(left, -1);
        Arrays.fill(right, length);

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < length; ++i) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();

        for (int i = length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                right[i] = stack.peek();
            }
            stack.push(i);
        }

        int mod = (int) 1e9 + 7;
        long answer = 0;

        for (int i = 0; i < length; ++i) {
            answer += (long) (i - left[i]) * (right[i] - i) % mod * arr[i] % mod;
            answer %= mod;
        }

        return (int) answer;
    }
}
```
