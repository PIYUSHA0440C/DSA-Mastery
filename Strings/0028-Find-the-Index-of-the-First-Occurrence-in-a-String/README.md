# 28. Find the Index of the First Occurrence in a String (Easy)

## 📝 Problem Statement
Given two strings `needle` and `haystack`, return the index of the first occurrence of `needle` in `haystack`, or `-1` if `needle` is not part of `haystack`.

## 💡 Intuition & Approach
While a naive substring matching approach checks character by character and resets completely on a mismatch ($O(N \times M)$ worst-case), we can optimize this to linear $O(N + M)$ time using the **Knuth-Morris-Pratt (KMP) Algorithm**.

The core philosophy of KMP is to **never throw away matching work**. When a character mismatch occurs after a partial match, the algorithm uses a precomputed **Longest Prefix Suffix (LPS)** array. The `lps` array tracks the length of the longest proper prefix that is also a suffix for every substring of the pattern. This tells us exactly how many characters we can safely skip backtracking, allowing our primary string text pointer to move strictly forward.

### 🛠️ The Strategy:
1. **LPS Table Construction:** Create an integer array `lps` of size `m` (length of pattern). Use a dual-pointer approach (`prevLPSLen` and `cur`) to find repeating prefix-suffix patterns within the `needle` itself.
2. **Linear Search Execution:** Maintain main text pointer `i` for `haystack` and pattern pointer `j` for `needle`.
3. **Smart Backtracking Handling:** 
   - If characters match, increment both pointers.
   - If a mismatch occurs and `j > 0`, fall back to `j = lps[j - 1]` to reuse the matching prefix info.
   - If a mismatch occurs at `j == 0`, simply advance the text pointer `i++`.
4. **Match Validation:** If `j` matches the full pattern length `m`, a complete match is found starting at index `i - j`.

## 📊 Complexity Analysis
* **Time Complexity:** O(N + M) - Building the LPS array takes $O(M)$ time, and executing the main text scan takes $O(N)$ time. The index pointers step forward linearly without nested rescanning loops.
* **Space Complexity:** O(M) - Auxiliary storage allocated to retain the integer array for the pattern's precomputed `lps` skip data.

## 💻 Implementation (Java)
```java
class Solution {
    public int strStr(String str, String pattern) {
        int n = str.length(), m = pattern.length();

        // Step 1: Precompute the Longest Prefix Suffix (LPS) table
        int[] lps = new int[m];
        int prevLPSLen = 0, cur = 1;

        while (cur < m) {
            if (pattern.charAt(prevLPSLen) == pattern.charAt(cur)) {
                lps[cur++] = ++prevLPSLen;
            } else {
                if (prevLPSLen == 0) {
                    lps[cur++] = 0;
                } else {
                    prevLPSLen = lps[prevLPSLen - 1];
                }
            }
        }

        // Step 2: Traverse the text using the LPS table to avoid backtracking resets
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (str.charAt(i) == pattern.charAt(j)) {
                i++; j++;
            } else {
                if (j == 0) i++;
                else j = lps[j - 1]; // Reset pattern marker to the last safe prefix match
            }
        }

        // Return the starting index if the pattern index matched the full pattern length
        return (j == m) ? (i - j) : -1;
    }
}
