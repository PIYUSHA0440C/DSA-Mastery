# 405. Convert a Number to Hexadecimal (Easy)

## 📝 Problem Statement

Given a 32-bit integer `num`, return its hexadecimal representation as a lowercase string.

For negative integers, use the two's complement representation. The solution must not use built-in methods that directly convert a number to hexadecimal.

## 💡 Intuition & Approach

A hexadecimal digit represents exactly 4 bits. Therefore, we can extract the last 4 bits of the number using the bitwise AND operation with `15` (`1111` in binary).

Use a character array as a lookup table to map each extracted value to its corresponding hexadecimal digit.

After extracting the last 4 bits, perform an unsigned right shift (`>>>= 4`) to process the next 4 bits.

For negative numbers, Java stores integers in 32-bit two's complement representation. The unsigned right shift ensures that zeros are shifted in from the left, allowing all 8 hexadecimal digits to be extracted correctly.

### 🛠️ The Strategy:

1. Handle zero separately by returning `"0"`.
2. Create a hexadecimal lookup array containing `0123456789abcdef`.
3. Extract the last 4 bits using `num & 15`.
4. Use the extracted value as an index in the lookup array and append the corresponding character.
5. Apply an unsigned right shift by 4 bits using `num >>>= 4`.
6. Repeat until the number becomes zero.
7. Reverse the result because hexadecimal digits are extracted from right to left.

## 📊 Complexity Analysis

- **Time Complexity:** O(1). A 32-bit integer requires at most 8 iterations, regardless of its value.
- **Space Complexity:** O(1). The lookup array and result contain a fixed maximum of 8 hexadecimal digits.

## 💻 Implementation (Java)

\`\`\`java
class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";

        char[] hexMap = "0123456789abcdef".toCharArray();
        StringBuilder sb = new StringBuilder();

        while (num != 0) {
            int lastFourBits = num & 15;
            sb.append(hexMap[lastFourBits]);

            num >>>= 4;
        }

        return sb.reverse().toString();
    }
}
\`\`\`
