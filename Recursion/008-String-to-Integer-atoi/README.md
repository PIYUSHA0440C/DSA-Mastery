# 8. String to Integer (atoi) (Medium)

## 📝 Problem Statement
Implement the `myAtoi(string s)` function, which converts a string to a 32-bit signed integer. The function must handle leading whitespace, signs (+/-), non-digit characters, and overflow/underflow conditions.

## 💡 Intuition & Approach
The problem requires a sequential state-machine-like approach to process the string.

### 🛠️ The Strategy:
1. **Preprocessing:** Skip all leading spaces using a pointer.
2. **Sign Determination:** Check for '+' or '-' to set the multiplier (1 or -1).
3. **Recursive Conversion:**
   - **Base Case:** Stop if we hit a non-digit character or the end of the string.
   - **Accumulation:** Multiply the current sum by 10 and add the new digit: $num = num \times 10 + (char - '0')$.
   - **Overflow Check:** Use a `long` to store the result during calculation. If the value exceeds `Integer.MAX_VALUE` or `Integer.MIN_VALUE`, return the clamped limit immediately.
4. **Final Result:** Return the accumulated number multiplied by the sign.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We traverse the string at most once.
* **Space Complexity:** 𝙊(𝗻) - Due to the recursion stack depth in the worst-case (all digits).

## 💻 Implementation (Java)
```java
class Solution {
    public int myAtoi(String s) {
        int i = 0, len = s.length();
        
        // 1. Skip Whitespace
        while(i < len && s.charAt(i) == ' ') i++;

        // 2. Handle Sign
        int sign = 1;
        if(i < len && (s.charAt(i) == '+' || s.charAt(i) == '-')){
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // 3. Convert via Recursive Helper
        return helper(s, i, 0L, sign, len);
    }

    private int helper(String s, int i, long num, int sign, int len){
        if(i >= len || !Character.isDigit(s.charAt(i))){
            return (int) (sign * num);
        }

        num = num * 10 + (s.charAt(i) - '0');

        // 4. Handle Overflow/Underflow
        if(num * sign >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(num * sign <= Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return helper(s, i + 1, num, sign, len);
    }
}
