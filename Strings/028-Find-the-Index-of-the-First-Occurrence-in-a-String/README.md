# 28. Find the Index of the First Occurrence in a String (Easy)

## 📝 Problem Statement
Given two strings `needle` and `haystack`, return the index of the first occurrence of `needle` in `haystack`, or `-1` if the needle is not part of the haystack.

## 💡 Intuition & Approach
This is a pattern-matching problem. The goal is to slide a window of the same size as the `needle` across the `haystack` and check for equality at each position.

### 🛠️ The Strategy:
1. **Window Definition:** The window starts at index `i` and ends at `j` (where `j = i + needle.length()`).
2. **Sliding mechanism:** We move the window one character at a time from the start of the `haystack` to the point where the window would exceed the haystack's bounds.
3. **Comparison:** At each step, extract the substring and use `.equals()` to check if it matches the `needle`.
4. **Early Return:** As soon as a match is found, return the current starting index `i`. If the loop finishes without a match, return `-1`.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻 × 𝗺) - where $n$ is the length of the haystack and $m$ is the length of the needle. In the worst case, we perform a substring comparison at every possible starting point.
* **Space Complexity:** 𝙊(𝗺) - The `substring` method creates a new string of length $m$ for each comparison.

## 💻 Implementation (Java)
```java
class Solution {
    public int strStr(String haystack, String needle) {
        int nLen = needle.length();
        int hLen = haystack.length();

        // Slide the window across the haystack
        for (int i = 0, j = nLen; j <= hLen; i++, j++) {
            // Check if the current window matches the needle
            if (haystack.substring(i, j).equals(needle)) {
                return i;
            }
        }
        
        return -1;
    }
}
