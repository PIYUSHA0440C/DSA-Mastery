# 231. Power of Two (Easy)

## 📝 Problem Statement
Given an integer `n`, return `true` if it is a power of two ($n = 2^x$). Otherwise, return `false`.

## 💡 Intuition & Approach
A power of two in binary representation has exactly one bit set to `1`. 

### 🛠️ The Strategy:
1. **The Bitwise Property:** For any power of two `n`:
   - `n` in binary: `100...0`
   - `n - 1` in binary: `011...1`
2. **The Test:** When we perform `n & (n - 1)`, the result will be exactly `0` if and only if `n` has only one bit set.
3. **Edge Cases:** We must ensure `n > 0`, as zero and negative numbers cannot be powers of two.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝟭) - No loops, no recursion. Just a single bitwise comparison.
* **Space Complexity:** 𝙊(𝟭) - No extra memory used.

## 💻 Implementation (Java)
```java
class Solution {
    public boolean isPowerOfTwo(int n) {
        // A power of two must be positive and have exactly one set bit
        return n > 0 && (n & (n - 1)) == 0;
    }
}
