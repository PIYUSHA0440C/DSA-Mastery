# 395. Longest Substring with At Least K Repeating Characters (Medium)

## 📝 Problem Statement
Given a string `s` and an integer `k`, return the length of the longest substring where every character in that substring appears at least `k` times.

## 💡 Intuition & Approach
The key observation is that if a character `c` appears in the string fewer than `k` times, no valid substring can contain `c`. This makes `c` a "delimiter" that splits the string into potential candidates.

### 🛠️ The Strategy (Divide and Conquer):
1. **Count Frequencies:** Count the occurrences of every character in the current string.
2. **Identify Split Points:** Iterate through the string. If a character is found that appears fewer than `k` times:
   - This character cannot be part of the result.
   - Split the string at this character into a `left` part and a `right` part.
   - Recursively call the function on both parts and return the maximum length found.
3. **Base Case:** If all characters in the current string appear at least `k` times, the entire string is a valid candidate. Return its length.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗡²) in the worst case (e.g., every split removes only one char), but typically much closer to 𝙊(𝗡 𝗹𝗼𝗴 𝗡) or 𝙊(𝟮𝟲𝗡) as there are only 26 lowercase letters.
* **Space Complexity:** 𝙊(𝗡) - Due to the recursion stack and the creation of substrings.

## 💻 Implementation (Java)
```java
class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() < k) return 0;
        
        int n = s.length();
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        for (int i = 0; i < n; i++) {
            // If this character occurs < k times, it can't be in our substring
            if (freq[s.charAt(i) - 'a'] < k) {
                // Split and conquer
                int left = longestSubstring(s.substring(0, i), k);
                int right = longestSubstring(s.substring(i + 1), k);
                return Math.max(left, right);
            }
        }

        // If we reach here, every character in the current string appears >= k times
        return n;
    }
}
