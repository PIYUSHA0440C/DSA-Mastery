# 191. Number of 1 Bits (Easy)

## 📝 Problem Statement
Given a positive integer `n`, return the number of set bits (1s) in its binary representation (Hamming weight).

## 💡 Intuition & Approach
The logic remains focused on examining the last bit of the integer and shifting it out until the entire number has been processed.

### 🛠️ The Strategy:
1. **Masking:** Use `n & 1` to check if the least significant bit is a `1`.
2. **Counting:** Increment the `result` counter if the masked bit is `1`.
3. **Right Shift:** Use the signed right shift `>>` to move the next bit into the check position. Because $n$ is guaranteed to be positive, this effectively reduces the number toward zero.
4. **Termination:** The loop exits once `n` reaches `0`.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝟭) - The loop runs at most 31 times given the positive integer constraint.
* **Space Complexity:** 𝙊(𝟭) - Constant space usage.

## 💻 Implementation (Java)
```java
class Solution {
    public int hammingWeight(int n) {
        int result = 0;
        while(n != 0){
            // Check the last bit
            int bit = n & 1;
            if(bit == 1) result++;
            // Shift right (signed)
            n >>= 1;
        }

        return result;
    }
}
