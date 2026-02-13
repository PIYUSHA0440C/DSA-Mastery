# 925. Long Pressed Name (Easy)

## 📝 Problem Statement
Your friend is typing his `name`. Sometimes, keys get "long pressed," resulting in characters being typed more than once. Given the `name` and the actual `typed` string, return `true` if it's possible that `typed` is just a long-pressed version of `name`.

## 💡 Intuition & Approach
We use two pointers to compare the strings. One pointer `i` tracks our progress through the `name`, while the loop index `j` traverses the `typed` string.

### 🛠️ The Strategy:
1. **Character Match:** If `name[i]` matches `typed[j]`, we move both pointers forward (we found the next character we needed).
2. **Long Press Validation:** If they don't match, we check if `typed[j]` is a "long press" of the previous character. This is true if `typed[j] == typed[j-1]`.
3. **Invalid Character:** If `typed[j]` doesn't match `name[i]` AND it isn't a repeat of the previous character, the string is invalid (return `false`).
4. **Completion Check:** At the end, we must ensure we've gone through all characters in `name` (`i == n`).



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗺) - Where $m$ is the length of the `typed` string. We iterate through it exactly once.
* **Space Complexity:** 𝙊(𝟭) - We only use a few integer pointers regardless of input size.

## 💻 Implementation (Java)
```java
class Solution {
    public boolean isLongPressedName(String name, String typed) { 
        int i = 0, n = name.length(), m = typed.length();

        for (int j = 0; j < m; ++j) {
            // Case 1: Characters match, move name pointer
            if (i < n && name.charAt(i) == typed.charAt(j)) {
                ++i;
            } 
            // Case 2: Character is a long press (matches the previous typed char)
            else if (j == 0 || typed.charAt(j) != typed.charAt(j - 1)) {
                return false;
            }
        }

        // Must have matched every character in name
        return i == n;
    }
}
