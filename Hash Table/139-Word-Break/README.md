# 139. Word Break (Medium)

## 📝 Problem Statement
Given a string `s` and a dictionary `wordDict`, return `true` if `s` can be segmented into a space-separated sequence of one or more dictionary words.

## 💡 Intuition & Approach
This is a Dynamic Programming problem because the solution to the string depends on the solutions to its smaller substrings.

### 🛠️ The Strategy:
1. **DP Array:** Initialize a boolean array `dp` of size `n + 1`. 
   - `dp[0] = true` (an empty string is always "breakable").
   - `dp[i]` will be true if `s.substring(0, i)` can be segmented.
2. **Nested Loops:** - Outer loop `i` iterates through every possible end-length of the prefix.
   - Inner loop `j` looks for a split point.
3. **The Condition:** If `dp[j]` is true (prefix is valid) AND the substring from `j` to `i` exists in the dictionary, then `dp[i]` becomes true.
4. **Optimization:** Converting the `wordDict` to a `HashSet` allows for $O(1)$ average time complexity lookups.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻²) - Due to the nested loops traversing the string length. (Technically $O(n^3)$ if you count the cost of string slicing).
* **Space Complexity:** 𝙊(𝗻) - To store the `dp` array and the `HashSet`.

## 💻 Implementation (Java)
```java
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        
        // Base case: Empty string is valid
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // If prefix s[0...j] is valid and s[j...i] is in dict
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // Move to next i once dp[i] is true
                }
            }
        }

        return dp[n];
    }
}
