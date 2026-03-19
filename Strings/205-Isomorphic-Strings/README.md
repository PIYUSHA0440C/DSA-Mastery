# 205. Isomorphic Strings (Easy)

## 📝 Problem Statement
Two strings `s` and `t` are isomorphic if the characters in `s` can be replaced to get `t`. All occurrences of a character must be replaced with another character while preserving the order. No two characters may map to the same character, but a character may map to itself.

## 💡 Intuition & Approach
The core idea is to verify if both strings follow the same structural pattern. Instead of explicit character-to-character mapping, we track the **last seen position** of each character.

### 🛠️ The Strategy:
1. **Last-Seen Arrays:** Create two arrays `m1` and `m2` of size 256 (to cover all ASCII characters).
2. **Synchronized Iteration:** Iterate through both strings simultaneously.
3. **Pattern Validation:** - Check if the last recorded position of `s.charAt(i)` matches the last recorded position of `t.charAt(i)`. 
   - If they differ, it means one character is trying to map to a new value or a different character is trying to map to an already used value.
4. **Update Positions:** Store `i + 1` as the new position. We use `i + 1` because the array is initialized with `0`, and we need to distinguish between "not seen yet" and "seen at index 0."



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We traverse the strings exactly once.
* **Space Complexity:** 𝙊(𝟭) - We use two fixed-size arrays (256 each), which does not depend on the input size $n$.

## 💻 Implementation (Java)
```java
class Solution {
    public boolean isIsomorphic(String s, String t) {
        // Use arrays to store the last seen position of characters
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        int len = s.length();

        for (int i = 0; i < len; i++) {
            // If the last seen positions don't match, they aren't isomorphic
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) {
                return false;
            }

            // Record the current index (+1 to avoid conflict with default 0)
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }

        return true;
    }
}
