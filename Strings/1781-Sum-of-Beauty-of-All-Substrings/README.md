# 1781. Sum of Beauty of All Substrings (Medium)

## 📝 Problem Statement
The beauty of a string is the difference in frequencies between the most frequent and least frequent characters. Given a string `s`, return the sum of the beauty scores of all of its substrings.

## 💡 Intuition & Approach
To find the total beauty, we must calculate the $max(freq) - min(freq)$ for every possible substring.

### 🛠️ The Strategy:
1. **Nested Loops:** Use a double loop to generate all substrings. The outer loop `i` marks the start, and the inner loop `j` expands the substring.
2. **Frequency Map:** For each new start `i`, initialize a frequency tracker. As `j` moves forward, update the frequency of the character at `s.charAt(j)`.
3. **Calculate Beauty:** - Iterate through the recorded frequencies.
   - Find the maximum and minimum values present.
   - Subtract `min` from `max` and add it to the global `sum`.
4. **Efficiency:** Since there are only 26 possible characters, the innermost loop (finding max/min) runs in constant $O(26)$ time, keeping the overall complexity manageable.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝟮𝟲 ⋅ 𝗻²) - We explore $n^2$ substrings and perform a constant time scan of the character frequencies for each.
* **Space Complexity:** 𝙊(𝟭) - The frequency map stores at most 26 entries regardless of the input size.

## 💻 Implementation (Java)
```java
class Solution {
    public int beautySum(String s) {
        int len = s.length();
        int sum = 0;

        for (int i = 0; i < len; i++) {
            // Frequency tracker for substrings starting at index i
            int[] freq = new int[26];

            for (int j = i; j < len; j++) {
                freq[s.charAt(j) - 'a']++;

                int maxFreq = Integer.MIN_VALUE;
                int minFreq = Integer.MAX_VALUE;

                // Scan 26 characters to find current max and min frequency
                for (int count : freq) {
                    if (count > 0) {
                        maxFreq = Math.max(maxFreq, count);
                        minFreq = Math.min(minFreq, count);
                    }
                }

                sum += (maxFreq - minFreq);
            }
        }

        return sum;
    }
}
