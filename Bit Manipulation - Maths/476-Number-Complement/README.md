# 476. Number Complement (Easy)

## 📝 Problem Statement
The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation. Given an integer `num`, return its complement.

## 💡 Intuition & Approach
A simple bitwise NOT (`~`) in Java flips all 32 bits of an integer. To get the complement of just the significant bits, we need a "mask" that matches the length of the binary representation of the input.

### 🛠️ The Strategy:
1. **Edge Case:** If `num` is 0, the complement is 1.
2. **Build the Mask:** - We iterate while `n > 0`.
   - In each step, we shift the mask left and add a `1`: `mask = (mask << 1) | 1`.
   - This creates a sequence of 1s (e.g., if `num` is 5 (101), the `mask` becomes 7 (111)).
3. **Invert and Filter:** - `~num` flips all bits (including the leading 0s to 1s).
   - `(~num) & mask` keeps only the bits where the mask is `1`, effectively discarding the leading 32-bit overhead.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗹𝗼𝗴 𝗻) - The loop runs once for every bit in the number (max 31 times).
* **Space Complexity:** 𝙊(𝟭) - Only two integer variables are used.

## 💻 Implementation (Java)
```java
class Solution {
    public int findComplement(int num) {
        int n = num;
        int mask = 0;
        
        if (num == 0) return 1;

        // Create a mask of 1s the same length as num's binary
        while (n > 0) {
            mask = (mask << 1) | 1;
            n = n >> 1;
        }

        // Bitwise NOT and then AND with mask to remove leading 1s
        return (~num) & mask;
    }
}
