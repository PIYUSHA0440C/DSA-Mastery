# 371. Sum of Two Integers (Medium)

## 📝 Problem Statement
Calculate the sum of two integers `a` and `b` without using the arithmetic operators `+` and `-`.

## 💡 Intuition & Approach
To add numbers without the standard operators, we use bitwise logic to simulate a digital circuit.

### 🛠️ The Logic:
1. **XOR (`^`)**: This acts as a partial addition. It adds bits but ignores the carry (e.g., $1 + 1 = 0$ in XOR).
2. **AND (`&`)**: This identifies where a carry is generated (where both bits are 1).
3. **Left Shift (`<< 1`)**: The carry must be added to the *next* bit position, so we shift it left.
4. **The Loop**: We continue the process until there are no more carries left (`b == 0`).



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝟭) - Since Java integers are 32-bit, the loop runs at most 32 times.
* **Space Complexity:** 𝙊(𝟭) - Only a few temporary variables used.

## 💻 Implementation (Java)
```java
class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            // Find the carry bits
            int carry = a & b;
            // Sum bits without carry
            a = a ^ b;
            // Shift carry to the left for the next iteration
            b = carry << 1;
        }
        return a;
    }
}
