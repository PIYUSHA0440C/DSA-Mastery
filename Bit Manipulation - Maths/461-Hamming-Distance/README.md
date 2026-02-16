# 461. Hamming Distance (Easy)

## 📝 Problem Statement
The Hamming distance between two integers is the number of positions at which the corresponding bits are different. Given two integers `x` and `y`, return the Hamming distance.

## 💡 Intuition & Approach
To find differing bits, the **XOR (`^`)** operator is the perfect tool because it returns `1` only when the bits are different and `0` when they are the same.

### 🛠️ The Strategy:
1. **XOR the inputs:** `int z = x ^ y` creates a number where every set bit (`1`) represents a position where `x` and `y` differed.
2. **Count the Set Bits:** Instead of checking all 32 bits, we use **Brian Kernighan’s Algorithm**.
3. **The Trick:** The expression `z & (z - 1)` always clears the least significant set bit of `z`. 
4. **Efficiency:** By repeating this in a `while(z > 0)` loop, the number of iterations equals exactly the Hamming distance, skipping all the `0` bits entirely.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗸) - Where $k$ is the Hamming distance (number of set bits). In the worst case, this is $O(31)$, but it is often much faster.
* **Space Complexity:** 𝙊(𝟭) - Only constant extra space is used.

## 💻 Implementation (Java)
```java
class Solution {
    public int hammingDistance(int x, int y) {
        // Step 1: Get the difference via XOR
        int z = x ^ y;
        int count = 0;
        
        // Step 2: Brian Kernighan's Algorithm to count set bits
        while (z > 0) {
            z = z & (z - 1); // Clears the lowest set bit
            count++;
        }
        
        return count;
    }
}
