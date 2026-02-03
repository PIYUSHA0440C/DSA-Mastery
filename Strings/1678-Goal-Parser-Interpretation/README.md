# 1678. Goal Parser Interpretation (Easy)

## 📝 Problem Statement
Design a Goal Parser that interprets a string `command`. The alphabet consists of:
- `G` interpreted as `G`
- `()` interpreted as `o`
- `(al)` interpreted as `al`

Return the interpreted string.

## 💡 Intuition & Approach
The core of this problem is pattern recognition while traversing the string. Since the patterns have different lengths, we need to adjust our pointer as we find matches.

### 🛠️ The Strategy:
1. **Efficient Construction:** Use a `StringBuilder` to build the result string to avoid the overhead of String immutability in Java.
2. **Single Pass Parsing:** Iterate through the string character by character:
   - If we see `G`, append `G`.
   - If we see `(`, look at the very next character:
     - If it's `)`, it's the `o` pattern. Append `o` and skip one index.
     - Otherwise, it's the `(al)` pattern. Append `al` and skip three indices.
3. **Complexity Note:** This manual approach is more memory-efficient than using multiple `.replace()` calls because it doesn't create intermediate String objects.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We visit each character in the command string exactly once.
* **Space Complexity:** 𝙊(𝗻) - The space used by the `StringBuilder` to store the output.

## 💻 Implementation (Java)
```java
class Solution {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'G') {
                sb.append('G');
            } else if (command.charAt(i) == '(') {
                // Peek at the next character to determine the pattern
                if (command.charAt(i + 1) == ')') {
                    sb.append('o');
                    i++; // Skip the ')'
                } else {
                    sb.append("al");
                    i += 3; // Skip 'a', 'l', and ')'
                }
            }
        }
        return sb.toString();
    }
}
