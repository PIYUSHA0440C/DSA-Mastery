# 1392. Longest Happy Prefix (Hard)

## 📝 Problem Statement
A string is called a **happy prefix** if it is a non-empty prefix which is also a suffix (excluding the string itself). Given a string `s`, return the longest happy prefix.

## 💡 Intuition & Approach
This problem is a direct application of the **LPS (Longest Prefix Suffix)** array construction from the KMP string-matching algorithm.

### 🛠️ The Strategy:
1. **LPS Array:** We maintain an array `lps` where `lps[i]` stores the length of the longest proper prefix of `s[0...i]` that is also a suffix of `s[0...i]`.
2. **Two Pointers:** - `i` moves forward through the string.
   - `len` tracks the length of the current matching prefix.
3. **Matching Logic:**
   - If `s.charAt(i) == s.charAt(len)`, we have extended our match. We increment `len` and store it in `lps[i]`.
   - If they don't match and `len != 0`, we "fall back" to the previous best match: `len = lps[len - 1]`. We don't increment `i` yet (the `i--` in your code effectively retries the current character against the smaller prefix).
4. **Final Result:** The last value in the LPS array (`lps[n-1]`) gives the length of the longest prefix that is also a suffix for the entire string.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - Each character is visited at most twice (once by `i` and potentially during the `len` fallback).
* **Space Complexity:** 𝙊(𝗻) - To store the LPS array.

## 💻 Implementation (Java)
```java
class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int len = 0; // Length of the previous longest prefix suffix

        // Loop calculates lps[i] for i = 1 to n-1
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
            } else if (len != 0) {
                // Fallback to the previous longest prefix suffix
                len = lps[len - 1];
                i--; // Stay at the same 'i' to re-compare
            }
            // If len == 0 and no match, lps[i] remains 0 (default)
        }

        // lps[n-1] is the length of the longest happy prefix
        return s.substring(0, lps[n - 1]);
    }
}
