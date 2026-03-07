# 29. Divide Two Integers (Medium)

## 📝 Problem Statement
Divide two integers without using multiplication, division, or the modulo operator. Handle 32-bit signed integer overflow cases and truncate results toward zero.

## 💡 Intuition & Approach
Since we can't divide directly, we use **Exponential Subtraction**. Instead of subtracting the divisor one by one, we subtract it in powers of 2 ($divisor \times 1, \times 2, \times 4, \dots$) to speed up the process.

### 🛠️ The Strategy:
1. **Edge Case:** Handle the overflow case where `Integer.MIN_VALUE` is divided by `-1`.
2. **Sign Handling:** Use the XOR operator (`^`) to determine if the result should be negative.
3. **Negative Logic:** Convert both numbers to negative. This is safer than positive conversion because the range of negative integers in 32-bit systems is larger by one ($2^{31}$ vs $2^{31}-1$).
4. **The Inner Loop:** - While the current `dividend` is smaller than or equal to the `divisor` (in negative terms):
   - Double the `divisor` and the `multiple` (initially 1) as long as it doesn't exceed the dividend.
   - Subtract the largest doubled divisor from the dividend and add the multiple to the result.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗹𝗼𝗴² 𝗻) - We have two nested loops where the inner loop reduces the dividend exponentially.
* **Space Complexity:** 𝙊(𝟭) - No extra data structures used.

## 💻 Implementation (Java)
```java
class Solution {
    public int divide(int dividend, int divisor) {
        // Handle overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Work with negative values to avoid overflow issues with Integer.MIN_VALUE
        int a = dividend < 0 ? dividend : -dividend;
        int b = divisor < 0 ? divisor : -divisor;

        int result = 0;
        while (a <= b) {
            int tempMultiple = b;
            int count = 1;
            
            // Exponentially increase the subtrahend (tempMultiple)
            while (tempMultiple >= (Integer.MIN_VALUE >> 1) && a <= (tempMultiple + tempMultiple)) {
                tempMultiple += tempMultiple;
                count += count;
            }
            
            a -= tempMultiple;
            result += count;
        }

        return isNegative ? -result : result;
    }
}
