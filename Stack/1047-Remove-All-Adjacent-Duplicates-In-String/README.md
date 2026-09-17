# 1047. Remove All Adjacent Duplicates In String (Easy)

## 📝 Problem Statement

Given a string `s` consisting of lowercase English letters, repeatedly remove pairs of adjacent and equal characters until no such pair remains.

Return the final string.

## 💡 Intuition & Approach

A `StringBuilder` can be used like a stack. For each character, compare it with the last character currently stored.

### 🛠️ The Strategy:

1. Traverse the string character by character.
2. Check whether the `StringBuilder` is non-empty and its last character equals the current character.
3. If they are equal, remove the last character because the pair forms an adjacent duplicate.
4. Otherwise, append the current character.
5. Continue until all characters are processed.
6. Return the resulting string.

Removing the last character can expose another duplicate with the next incoming character, which naturally handles repeated removals.

## 📊 Complexity Analysis

- **Time Complexity:** O(n), where `n` is the length of the string.
- **Space Complexity:** O(n) for the `StringBuilder`.

## 💻 Implementation (Java)

```java
class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();

        for(char ch: s.toCharArray()){
            int len = sb.length();

            if (len > 0 && sb.charAt(len - 1) == ch) {
                sb.deleteCharAt(len - 1);

            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
```
