# 2351. First Letter to Appear Twice (Easy)

## 📝 Problem Statement

Given a string `s` consisting of lowercase English letters, return the first letter to appear twice.

The answer is the character whose second occurrence appears earliest in the string.

## 💡 Intuition & Approach

Since the string contains only lowercase English letters, a boolean array of size `26` can track whether each character has already appeared.

### 🛠️ The Strategy:

1. Create a boolean array of size `26` to track previously seen characters.
2. Traverse the string from left to right.
3. For each character, check whether it has already been seen.
4. If it has, return that character because its second occurrence is the earliest possible at the current position.
5. Otherwise, mark the character as seen.
6. Since the string is guaranteed to contain a repeated character, a valid answer will always be found.

## 📊 Complexity Analysis

- **Time Complexity:** O(n), where `n` is the length of the string.
- **Space Complexity:** O(1), since the boolean array always contains 26 elements.

## 💻 Implementation (Java)

```java
class Solution {
    public char repeatedCharacter(String s) {
        boolean[] seen = new boolean[26];

        for(char ch : s.toCharArray()) {
            if(seen[ch - 'a']) return ch;
            seen[ch - 'a'] = true;
        }

        return ' ';
    }
}
```
