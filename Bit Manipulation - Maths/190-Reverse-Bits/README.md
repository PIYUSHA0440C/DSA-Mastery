# 190. Reverse Bits (Easy)

## 📝 Problem Statement
Reverse the bits of a given 32-bit signed integer.

## 💡 Intuition & Approach
The goal is to treat the integer as a collection of 32 individual bits and flip their order (the 1st bit becomes the 32nd, the 2nd becomes the 31st, and so on).

### 🛠️ The Strategy:
1. **The Result Holder:** Initialize `result = 0`.
2. **The 32-Bit Loop:** Since we are dealing with a 32-bit integer, we iterate exactly 32 times.
3. **Extraction:** Use `n & 1` to grab the least significant bit (the bit at the very end) of `n`.
4. **Placement:** Shift the `result` to the left (`result << 1`) to make room and then use the OR operator (`|`) to place the extracted bit into that new spot.
5. **Unsigned Shift:** Use `n >>>= 1`. The `>>>` operator is critical here because it performs an **unsigned** right shift, preventing the sign bit from interfering with the reversal.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝟭) - The loop always runs exactly 32 times.
* **Space Complexity:** 𝙊(𝟭) - No extra data structures used.

## 💻 Implementation (Java)
```java
class Solution {
    public int reverseBits(int n) {
        int result = 0;

        for(int i = 0; i < 32; i++){
            int bit = n & 1;                // Last bit of the current n
            result = (result << 1) | bit;   // Store the calculation of result and the bit in result
            n >>>= 1;                       // Unsigned right-shift so work for both positive and negative
        }
        
        return result;
    }
}
