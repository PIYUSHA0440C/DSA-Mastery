# 67. Add Binary (Easy)

## 📝 Problem Statement
Given two binary strings `a` and `b`, return their sum as a binary string.

## 💡 Intuition & Approach
Binary addition follows the same rules as decimal addition but carries over at 2 instead of 10. Since the strings can be very long, we process them from right to left (least significant bit to most significant bit).

### 🛠️ The Strategy:
1. **Pointers & Carry:** Use two pointers (`i`, `j`) starting at the ends of the strings and a `carry` variable initialized to 0.
2. **The Loop:** Continue as long as there are characters left in either string OR there is a remaining carry of 1.
3. **Bit Summation:**
   - Add the digit from `a` (if `i >= 0`) to `carry`.
   - Add the digit from `b` (if `j >= 0`) to `carry`.
4. **Append & Update:**
   - The bit to append to our result is `carry % 2`.
   - The new carry for the next position is `carry / 2`.
5. **Reverse:** Since we appended bits from right to left, the `StringBuilder` must be reversed before returning.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗺𝗮𝘅(𝗡, 𝗠)) - We traverse the length of the longer string once.
* **Space Complexity:** 𝙊(𝗺𝗮𝘅(𝗡, 𝗠)) - To store the resulting sum string.

## 💻 Implementation (Java)
```java
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        // Process both strings and the final carry
        while (i >= 0 || j >= 0 || carry == 1) {
            if (i >= 0) {
                carry += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                carry += b.charAt(j--) - '0';
            }

            // Append the current bit (0 or 1)
            result.append(carry % 2);
            // Update carry for the next position (0 or 1)
            carry /= 2;
        }

        return result.reverse().toString();
    }
}
