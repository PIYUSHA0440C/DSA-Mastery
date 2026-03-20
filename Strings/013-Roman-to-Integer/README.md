# 13. Roman to Integer (Easy)

## 📝 Problem Statement
Roman numerals are represented by seven symbols: `I, V, X, L, C, D, M`. Usually, they are written largest to smallest. However, if a smaller numeral precedes a larger one, the smaller value is subtracted (e.g., `IV` is 4, `IX` is 9). Given a roman numeral, convert it to an integer.

## 💡 Intuition & Approach
The logic relies on a single pass through the string, comparing each character with its neighbor to the right.

### 🛠️ The Strategy:
1. **Map Values:** Use a `Map` to store the integer values of each Roman symbol.
2. **Look-Ahead Comparison:** Iterate from the start of the string up to the second-to-last character:
   - If the current character's value is **less than** the next character's value, it's a subtraction case (like `IV`). Subtract the current value from the total.
   - Otherwise, it's a standard addition case. Add the current value to the total.
3. **Handle the Last Character:** Since the loop stops before the last index, always add the value of the final character at the end.
4. **Efficiency:** This approach processes the string in $O(n)$ time with a single pass.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We traverse the string once.
* **Space Complexity:** 𝙊(𝟭) - The map size is constant (7 symbols), and we only use one integer for the result.

## 💻 Implementation (Java)
```java
class Solution {
    private static final Map<Character, Integer> roman = Map.of(
        'I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000
    );

    public int romanToInt(String s) {
        int result = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            // Check if current value is smaller than the next (Subtraction Rule)
            if (roman.get(s.charAt(i)) < roman.get(s.charAt(i + 1))) {
                result -= roman.get(s.charAt(i));
            } else {
                result += roman.get(s.charAt(i));
            }
        }

        // Always add the last character's value
        return result + roman.get(s.charAt(s.length() - 1));
    }
}
