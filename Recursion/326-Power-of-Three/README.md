# 326. Power of Three (Easy)

## 📝 Problem Statement
Given an integer `n`, return `true` if it is a power of three ($n = 3^x$). Otherwise, return `false`.

## 💡 Intuition & Approach
To determine if a number is a power of three, we can recursively divide the number by 3. If we eventually reach 1 or 3 without encountering a remainder, the number is a power of three.

### 🛠️ The Strategy:
1. **Base Cases:**
   - If `n` reaches `1` or `3`, return `true` (since $3^0 = 1$ and $3^1 = 3$).
2. **Recursive Logic:**
   - Ensure `n > 0` (negative numbers and zero cannot be powers of 3).
   - Check if `n` is divisible by 3 (`n % 3 == 0`).
   - If both conditions are met, recurse with `n / 3`.
3. **Termination:** If at any point the number is not divisible by 3 before reaching the base cases, return `false`.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗹𝗼𝗴₃ 𝗻) - Each recursive call divides the input by 3.
* **Space Complexity:** 𝙊(𝗹𝗼𝗴₃ 𝗻) - The depth of the recursive call stack.

## 💻 Implementation (Java)
```java
class Solution {
    public boolean isPowerOfThree(int n) {
        return helper(n);
    }

    boolean helper(int n) {
        // Base cases: 3^0 = 1 and 3^1 = 3
        if (n == 3 || n == 1) return true;

        // Recursive step: must be positive and divisible by 3
        if (n > 0 && n % 3 == 0) {
            return helper(n / 3);
        } else {
            return false;
        }
    }
}
