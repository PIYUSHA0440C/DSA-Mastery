# 1009. Complement of Base 10 Integer (Easy)

## 📝 Problem Statement
The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation. Given an integer `n`, return its complement.

## 💡 Intuition & Approach
In Java, the bitwise NOT operator `~` flips all 32 bits of an integer, including the leading zeros. To get the complement of just the significant bits, we need a **Bitmask**.

### 🛠️ The Strategy:
1. **Edge Case:** If $n = 0$, the binary is "0", so the complement is "1".
2. **Build the Mask:** - Start with `mask = 1`.
   - Use a loop: `while (mask < n)`, shift the mask left and OR it with 1 (`mask = (mask << 1) | 1`).
   - This creates a sequence of 1s (e.g., if $n=5$ (101), mask becomes 7 (111)).
3. **The Flip:** Perform `n ^ mask`. 
   - XORing a bit with 1 flips it ($0 \to 1$ and $1 \to 0$).
   - XORing with the mask ensures we only flip the bits that exist in $n$.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗹𝗼𝗴 𝗻) - The loop runs for the number of bits in $n$ (at most 31 times).
* **Space Complexity:** 𝙊(𝟭) - Only one integer variable for the mask.

## 💻 Implementation (Java)
```java
class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) return 1;

        int mask = 1;
        // Build a mask of all 1s with the same bit-length as n
        while (mask < n) {
            mask = (mask << 1) | 1;
        }

        // n XOR mask flips all bits of n within the mask's range
        return n ^ mask;
    }
}
