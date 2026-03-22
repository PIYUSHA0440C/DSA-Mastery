# 2220. Minimum Bit Flips to Convert Number (Easy)

## 📝 Problem Statement
Given two integers `start` and `goal`, return the minimum number of bit flips to convert `start` to `goal`. A bit flip is changing a `0` to `1` or a `1` to `0`.

## 💡 Intuition & Approach
The number of flips required is exactly equal to the number of positions where the binary representations of `start` and `goal` differ. This is known as the **Hamming Distance**.

### 🛠️ The Strategy:
1. **XOR for Difference:** Perform `start ^ goal`. The resulting integer `num` will have a `1` at every bit position where `start` and `goal` were different.
2. **Count the Set Bits:**
   - Use a `while` loop to process `num`.
   - Check the last bit using `(num & 1)`. If it is `1`, increment the counter.
   - Shift `num` to the right (`num >>= 1`) to check the next bit.
3. **Alternative:** In Java, you could also use `Integer.bitCount(start ^ goal)` for a one-liner!



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗹𝗼𝗴 𝗻) - We iterate through the bits of the XOR result. For a 32-bit integer, this is at most 31-32 iterations.
* **Space Complexity:** 𝙊(𝟭) - No extra data structures used.

## 💻 Implementation (Java)
```java
class Solution {
    public int minBitFlips(int start, int goal) {
        // XOR identifies differing bits
        int num = start ^ goal;
        int result = 0;
        
        // Count how many bits are set to 1
        while (num > 0) {
            if ((num & 1) == 1) {
                result++;
            }
            num >>= 1; // Move to the next bit
        }

        return result;
    }
}
