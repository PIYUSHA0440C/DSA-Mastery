# 567. Permutation in String (Medium)

## 📝 Problem Statement
Given two strings `s1` and `s2`, return `true` if `s2` contains a permutation of `s1`. In other words, check if one of `s1`'s permutations is a substring of `s2`.

## 💡 Intuition & Approach
A permutation of a string is simply another string with the same character frequencies. Therefore, the problem becomes: "Is there a window in `s2` of length `s1.length()` that has the same character counts as `s1`?"

### 🛠️ The Strategy:
1. **Frequency Arrays:** Use two integer arrays of size 26 (for lowercase English letters) to store character counts for `s1` and the current window in `s2`.
2. **Fixed Sliding Window:** 
   - Initialize the first window of size `len1` in both strings.
   - Slide the window across `s2` one character at a time.
3. **Efficient Updates:** 
   - When the window moves, remove the character that is sliding out (decrement count) and add the character that is sliding in (increment count).
4. **Comparison:** After each shift, compare the two frequency arrays. If they match, a permutation exists.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - Where $n$ is the length of $s2$. We traverse $s2$ once, and the array comparison takes constant time ($O(26)$).
* **Space Complexity:** 𝙊(𝟭) - We use fixed-size arrays of length 26, regardless of the input size.

## 💻 Implementation (Java)
```java
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        
        // Initialize the first window
        for (int i = 0; i < len1; i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        // Slide the window
        for (int i = 0; i < len2 - len1; i++) {
            if (isEquals(s1Count, s2Count)) return true;

            // Shift window: remove left char, add right char
            s2Count[s2.charAt(i) - 'a']--;
            s2Count[s2.charAt(i + len1) - 'a']++;
        }

        // Check the last window
        return isEquals(s1Count, s2Count);
    }

    private boolean isEquals(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
