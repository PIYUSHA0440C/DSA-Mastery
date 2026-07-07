# 3754. Concatenate Non-Zero Digits and Multiply by Sum I (Easy)

## 📝 Problem Statement
You are given an integer `n`. Form a new integer `x` by concatenating all the non-zero digits of `n` in their original order. If there are no non-zero digits, `x = 0`.

Let `sum` be the sum of digits in `x`. Return an integer representing the value of `x * sum`.

## 💡 Intuition & Approach
Instead of converting the integer to a string or allocating an auxiliary list to isolate the digits, we can solve this problem math-first in a single pass from right to left using standard modulo (`% 10`) and division (`/ 10`) arithmetic operations.

To reconstruct the number `x` with its non-zero digits preserving their original relative order, we process the number from the least significant digit to the most significant digit. When a non-zero digit is found:
1. We add it directly to our running digit sum variable `sum`.
2. We place it into its correct decimal position within our reconstructed value `x` by multiplying it by a positional multiplier `i` (which starts at `1` and scales up by `10` every time a valid digit is appended).

### 🛠️ The Strategy:
1. **Initialize Multipliers and Sums:** Create `ans = 0` to build our target number `x`, `sum = 0` to track the digit sum, and position multiplier `i = 1`.
2. **Digit Extraction Loop:** Extract the last digit using `n % 10` and strip it off via `n /= 10` while `n > 0`.
3. **Filter and Position:** If the digit is zero, skip it. If it is non-zero, append it to `sum` and calculate its weighted placeholder placement via `ans += digit * i`, then step the index weight up by ten (`i *= 10`).
4. **Final Computation:** Cast the values to long type during the calculation to prevent potential arithmetic overflow, returning `(long) ans * sum`.

## 📊 Complexity Analysis
* **Time Complexity:** O(log N) - The loop runs exactly once for each digit inside the given integer `n`. Since the total number of digits scales logarithmically with the value of $N$, the operation is extremely efficient.
* **Space Complexity:** O(1) - No auxiliary strings or dynamic arrays are initialized. The entire solution completes in strict constant memory space.

## 💻 Implementation (Java)
```java
class Solution {
    public long sumAndMultiply(int n) {
        int ans = 0;
        int sum = 0;
        int i = 1; // Tracks the decimal place multiplier (1, 10, 100, ...)

        while (n > 0) {
            int digit = n % 10;
            n /= 10;

            // Skip zero digits as required by the problem statement
            if (digit == 0) continue;

            // Update the running sum of non-zero digits
            sum += digit;

            // Reconstruct the integer from right to left preserving relative order
            ans += digit * i;
            i *= 10;
        }

        // Return the final multiplication product, cast to prevent overflow
        return (long) ans * sum;
    }
}
