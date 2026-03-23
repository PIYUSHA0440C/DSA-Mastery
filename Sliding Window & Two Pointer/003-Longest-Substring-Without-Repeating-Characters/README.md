# 3. Longest Substring Without Repeating Characters (Medium)

## 📝 Problem Statement
Given a string `s`, find the length of the longest substring without duplicate characters.

## 💡 Intuition & Approach
To find the longest substring without repeats, we examine substrings starting at each index and track seen characters to identify where a duplicate occurs.

### 🛠️ The Strategy:
1. **Outer Loop:** Iterate through each character of the string to treat it as the potential start of a unique substring.
2. **Frequency Array:** For each start index `i`, initialize a `hash` array of size 256 (covering all ASCII characters) to keep track of characters encountered in the current window.
3. **Inner Loop:** Expand the substring from `i` to the right (`j`). 
   - If `s.charAt(j)` has already been seen (`hash == 1`), the substring starting at `i` cannot grow further without duplicates. Break the inner loop.
   - Otherwise, mark the character as seen and update the `maxLen`.
4. **Result:** After checking all possible starting positions, `maxLen` will hold the length of the longest valid substring found.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻²) - In the worst case (like "abcdefg"), we iterate through nearly all pairs of indices.
* **Space Complexity:** 𝙊(𝟭) - We use a fixed-size array of 256 integers, which does not grow with the input size.

## 💻 Implementation (Java)
```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int maxLen = 0;

        for (int i = 0; i < len; i++) {
            int[] hash = new int[256]; // Track characters for this specific start point

            for (int j = i; j < len; j++) {
                // If character already seen in this substring, stop
                if (hash[s.charAt(j)] == 1) break;
                
                hash[s.charAt(j)] = 1;
                // Length is current index - start index + 1
                maxLen = Math.max(maxLen, j - i + 1); 
            }
        }

        return maxLen;
    }
}
