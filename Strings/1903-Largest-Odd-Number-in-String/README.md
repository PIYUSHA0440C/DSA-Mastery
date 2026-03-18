# 1903. Largest Odd Number in String (Easy)

## 📝 Problem Statement
You are given a string `num` representing a large integer. Return the largest-valued odd integer (as a string) that is a non-empty substring of `num`, or an empty string `""` if no odd integer exists.

## 💡 Intuition & Approach
The value of a large number is determined to be odd or even solely by its **last digit**. To find the largest odd substring, we want to keep as many significant digits (left-most digits) as possible.

### 🛠️ The Strategy:
1. **Right-to-Left Scan:** Start from the end of the string (the least significant digit).
2. **Identify Odd Digit:** Check if the character at the current index is odd: `(num.charAt(len) - '0') % 2 != 0`.
3. **Substring Return:** The moment an odd digit is found at index `i`, the largest odd number is the entire prefix of the string ending at `i`. We return `num.substring(0, i + 1)`.
4. **Edge Case:** If we loop through the entire string without finding an odd digit, return `""`.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - In the worst case, we check every digit once.
* **Space Complexity:** 𝙊(𝟭) - We only use a pointer for the index (excluding the space for the return string).

## 💻 Implementation (Java)
```java
class Solution {
    public String largestOddNumber(String num) {
        // Start from the end to find the rightmost odd digit
        int len = num.length() - 1;
        while(len >= 0) {
            // Convert char to int and check if odd
            if((num.charAt(len) - '0') % 2 != 0) {
                // If the last digit is odd, the whole number up to this point is odd
                return num.substring(0, len + 1);
            }
            len--;
        }
        return "";
    }
}
