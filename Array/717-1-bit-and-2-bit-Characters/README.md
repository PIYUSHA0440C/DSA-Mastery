# 717. 1-bit and 2-bit Characters (Easy)

## 📝 Problem Statement
We have two special characters:
1. A 1-bit character represented by `0`.
2. A 2-bit character represented by `10` or `11`.

Given a binary array `bits` ending in `0`, return `true` if the last character must be a 1-bit character.

## 💡 Intuition & Approach
The decoding is linear because the first bit of any character tells us its total length. If we see a `1`, we are forced to consume the next bit as part of a 2-bit character. If we see a `0`, it stands alone.

### 🛠️ The Strategy:
1. **Linear Scan:** Start a pointer `i` at index 0.
2. **Jump Logic:** - If `bits[i] == 1`, the character is 2-bits long. Jump to `i + 2`.
   - If `bits[i] == 0`, the character is 1-bit long. Jump to `i + 1`.
   - This can be written concisely as `i += 1 + bits[i]`.
3. **The Target:** We only iterate while `i < n - 1` (stopping before the last bit).
4. **Validation:** After the loop, if `i` is exactly `n - 1`, it means we successfully landed on the last bit as a fresh start, making it a 1-bit character. If `i == n`, we jumped over it, meaning it was the second half of a 2-bit character.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We traverse the array at most once.
* **Space Complexity:** 𝙊(𝟭) - Only one pointer variable is used.

## 💻 Implementation (Java)
```java
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        int i = 0;
        
        // Traverse until we reach the last bit or jump over it
        while (i < n - 1) {
            // bits[i] is 0 -> move 1 step
            // bits[i] is 1 -> move 2 steps
            i += 1 + bits[i];
        }
        
        // If we landed exactly at n-1, the last 0 is a 1-bit character
        return i == n - 1;
    }
}
