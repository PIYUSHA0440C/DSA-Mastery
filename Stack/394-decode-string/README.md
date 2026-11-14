# 394. Decode String (Medium)

## 📝 Problem Statement

Given an encoded string, decode it using the repetition rule `k[encoded_string]`, where the encoded substring inside square brackets is repeated exactly `k` times.

The encoding can contain nested expressions. The decoded output is guaranteed not to exceed \(10^5\) characters.

## 💡 Intuition & Approach

Use recursion to handle nested encoded strings. Whenever an opening bracket is encountered, recursively decode the substring inside it. When the closing bracket is reached, return the decoded substring to the previous recursive call.

A shared index tracks the current position in the input string, ensuring that each character is processed in sequence.

### 🛠️ The Strategy:

1. Initialize a shared index to track the current position.
2. Traverse the string and build the decoded result using a `StringBuilder`.
3. When a digit is encountered, construct the repetition count.
4. When `[` is encountered, recursively decode the nested substring.
5. Repeat the decoded substring according to the count and append it to the current result.
6. When `]` is encountered, return the current decoded substring.
7. Append ordinary characters directly to the result.

## 📊 Complexity Analysis

- **Time Complexity:** O(n + m), where `n` is the encoded string length and `m` is the decoded output length. Each input character is processed once, and constructing the decoded output takes O(m) time.
- **Space Complexity:** O(m + d), where `m` is the space occupied by the decoded strings and `d` is the maximum recursion depth.

## 💻 Implementation (Java)

\`\`\`java
class Solution {

    private int index;

    public String decodeString(String s) {
        index = 0;
        return decode(s);
    }

    private String decode(String s) {
        StringBuilder res = new StringBuilder();

        int num = 0;
        int len = s.length();

        while (index < len) {
            char ch = s.charAt(index);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
                index++;

            } else if (ch == '[') {
                index++;
                String inner = decode(s);
                for (int k = 0; k < num; k++) res.append(inner);
                num = 0;

            } else if (ch == ']') {
                index++;
                return res.toString();

            } else {
                res.append(ch);
                index++;
            }
        }

        return res.toString();
    }
}
\`\`\`
