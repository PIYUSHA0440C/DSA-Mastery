# 1358. Number of Substrings Containing All Three Characters (Medium)

## 📝 Problem Statement
Given a string `s` consisting only of characters `a`, `b` and `c`, return the number of substrings containing at least one occurrence of all these characters `a`, `b` and `c`.

## 💡 Intuition & Approach
A brute-force solution would check every possible substring, running in slow $O(N^2)$ time. To optimize this to linear $O(N)$ time, we can track the **last seen positions** of each character as we scan the string from left to right.

For any character at the current index `i`, we identify the most recent indices where `a`, `b`, and `c` were seen. The minimum index among these three positions, let's call it `minIdx`, marks the end of the shortest valid prefix starting from the left that completes our set of `a`, `b`, and `c`. 

If `minIdx` is valid (greater than `-1`), then any substring starting from index `0` up to `minIdx`, and ending exactly at `i`, is also guaranteed to contain all three characters. Therefore, the number of valid substrings ending at the current index `i` is exactly `minIdx + 1`.

### 🛠️ The Strategy:
1. **Track Last Positions:** Maintain a small 3-element array `p` initialized to `[-1, -1, -1]` to record the last seen index for `a`, `b`, and `c`.
2. **Bitwise Character Mapping:** As we loop through the string, map characters efficiently using `(s.charAt(i) & 31) - 1`. The bitwise AND operation with `31` extracts the 1-based alphabetic position (`a=1, b=2, c=3`), which converts perfectly into array indices `0`, `1`, and `2` by subtracting 1.
3. **Accumulate Substrings:** Find the minimum index in `p` via `Math.min(p[0], Math.min(p[1], p[2]))`. Add `minIdx + 1` directly to our total counts accumulation variable `res`.

## 📊 Complexity Analysis
* **Time Complexity:** O(N) - We perform a single sequential pass across the string of length $N$. The index lookup and minimum value comparisons complete in constant time per step.
* **Space Complexity:** O(1) - Only a fixed-size array of 3 integers is allocated to track the letter positions.

## 💻 Implementation (Java)
```java
class Solution {
    public int numberOfSubstrings(String s) {
        int res = 0;
        int[] p = {-1, -1, -1}; // Stores the last seen index of 'a', 'b', and 'c'

        for (int i = 0; i < s.length(); i++) {
            // (s.charAt(i) & 31) extracts alphabetic position: 'a'->1, 'b'->2, 'c'->3
            p[(s.charAt(i) & 31) - 1] = i;
            
            // The smallest index among the three marks the valid left boundary split
            res += Math.min(p[0], Math.min(p[1], p[2])) + 1;
        }

        return res;
    }
}
