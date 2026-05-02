# 788. Rotated Digits (Medium)

## 📝 Problem Statement
An integer `x` is **good** if, after rotating each digit 180 degrees, it forms a valid different number.
- `0, 1, 8` rotate to themselves.
- `2, 5` rotate to each other.
- `6, 9` rotate to each other.
- `3, 4, 7` are invalid.
Given `n`, return the count of good integers in the range `[1, n]`.

## 💡 Intuition & Approach
The problem can be solved by checking each number individually. A number is "good" if:
1. It contains **no** invalid digits ($3, 4, 7$).
2. It contains **at least one** digit that changes upon rotation ($2, 5, 6, 9$).

### 🛠️ The Strategy:
1. **Iterate:** Loop from $1$ to $n$.
2. **Digit Extraction:** For each number, use `% 10` and `/ 10` to inspect each digit.
3. **Flag System:**
   - Use a boolean `isValid` to ensure we don't hit $3, 4,$ or $7$.
   - Use a boolean `isChanged` to track if we've seen $2, 5, 6,$ or $9$.
4. **Validation:** If the number is valid and has at least one changing digit, increment the count.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗡 × 𝗹𝗼𝗴₁₀𝗡) - We iterate $N$ times, and for each number, we check its digits (approximately $\log_{10}N$ digits).
* **Space Complexity:** 𝙊(𝟭) - No extra data structures are used.

## 💻 Implementation (Java)
```java
class Solution {
    public int rotatedDigits(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isGood(i)) count++;
        }
        return count;
    }

    private boolean isGood(int i) {
        boolean isChanged = false;
        while (i > 0) {
            int digit = i % 10;
            // If it contains 3, 4, or 7, it's invalid
            if (digit == 3 || digit == 4 || digit == 7) return false;
            // If it contains 2, 5, 6, or 9, the number will change value
            if (digit == 2 || digit == 5 || digit == 6 || digit == 9) isChanged = true;
            i /= 10;
        }
        return isChanged;
    }
}
