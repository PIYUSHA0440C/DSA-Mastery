# 342. Power of Four (Easy)

## 📝 Problem Statement
Given an integer `n`, return `true` if it is a power of four ($n = 4^x$). Otherwise, return `false`.

## 💡 Intuition & Approach
The core idea is to repeatedly "shrink" the number by dividing it by 4. If the number is a power of four, it will eventually reach 1.

### 🛠️ The Strategy:
1. **Sanity Check:** Any number $\leq 0$ cannot be a power of four.
2. **Iterative Division:** As long as `n` is divisible by 4 (`n % 4 == 0`), divide `n` by 4.
3. **The Result:** If the final value of `n` is `1`, then the original number was a power of four. If it's anything else, it had other factors or wasn't perfectly divisible.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗹𝗼𝗴₄(𝗻)) - The number of iterations is proportional to the power of 4.
* **Space Complexity:** 𝙊(𝟭) - No extra space is used beyond a few integer operations.

## 💻 Implementation (Java)
```java
class Solution {
    public boolean isPowerOfFour(int n) {
        // Base case: Powers of 4 must be positive
        if(n <= 0) return false;

        // Keep dividing by 4 if there's no remainder
        while(n % 4 == 0){
            n /= 4;
        }

        // If we reach 1, it's a power of four
        return n == 1;
    }
}
