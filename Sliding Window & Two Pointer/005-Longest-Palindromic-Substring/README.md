# 5. Longest Palindromic Substring (Medium)

## 📝 Problem Statement
Given a string `s`, return the longest palindromic substring in `s`.

## 💡 Intuition & Approach
A palindrome mirrors around its center. There are $2n - 1$ such centers in a string of length $n$ (one for each character and one for each gap between characters).

### 🛠️ The Strategy:
1. **Iterate through Centers:** Loop through the string, treating each index `i` as the center.
2. **Expand Odd Palindromes:** Start with `left = i, right = i`. Expand outwards as long as characters match.
3. **Expand Even Palindromes:** Start with `left = i, right = i + 1`. Expand outwards as long as characters match.
4. **Update Maximum:** Every time a larger palindrome is found during expansion, store it in the `res` variable.
5. **Efficiency:** This approach avoids checking every possible substring by only expanding valid palindromic patterns.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻²) - We visit each of the $2n-1$ centers and expand.
* **Space Complexity:** 𝙊(𝟭) - (Excluding the space for the result string) We only use pointers for expansion.

## 💻 Implementation (Java)
```java
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int len = s.length();
        String res = "";

        for (int i = 0; i < len; i++) {
            // Case 1: Odd length (Center is a character)
            res = getLongest(s, i, i, res);
            
            // Case 2: Even length (Center is between characters)
            res = getLongest(s, i, i + 1, res);
        }

        return res;
    }

    private String getLongest(String s, int left, int right, String currentMax) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Extract the valid palindrome (indices are start+1 to end)
        String found = s.substring(left + 1, right);
        return found.length() > currentMax.length() ? found : currentMax;
    }
}
