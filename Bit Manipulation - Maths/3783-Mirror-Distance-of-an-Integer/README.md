# 3783. Mirror Distance of an Integer (Easy)

## 📝 Problem Statement
Given an integer `n`, define its **mirror distance** as the absolute difference between the number and its reverse: $|n - reverse(n)|$. Leading zeros in the reversed number are omitted (e.g., $reverse(10) = 1$).

## 💡 Intuition & Approach
The heart of this problem is the digit reversal algorithm. Instead of using string manipulation, which involves extra memory allocation, we can reverse an integer mathematically.

### 🛠️ The Strategy:
1. **Reversal Logic:** - Initialize `ans = 0`.
   - While `n > 0`:
     - Extract the last digit: `pop = n % 10`.
     - Append it to the result: `ans = (ans * 10) + pop`.
     - Remove the last digit from $n$: `n /= 10`.
2. **Calculation:** Once the reverse is obtained, use `Math.abs()` to find the non-negative difference between the original $n$ and its reversed version.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗹𝗼𝗴₁₀ 𝗻) - The number of iterations is equal to the number of digits in $n$.
* **Space Complexity:** 𝙊(𝟭) - Only a few integer variables are used.

## 💻 Implementation (Java)
```java
class Solution {
    public int mirrorDistance(int n) {
        int original = n;
        int reversed = 0;
        
        // Step 1: Reverse the digits mathematically
        while (n > 0) {
            reversed = (reversed * 10) + (n % 10);
            n /= 10;
        }

        // Step 2: Return absolute difference
        return Math.abs(original - reversed);
    }
}
