# 2000. Reverse Prefix of Word (Easy)

## 📝 Problem Statement
Given a string `word` and a character `ch`, reverse the segment of the word that starts at index 0 and ends at the first occurrence of `ch`. If `ch` doesn't exist, return the original word.

## 💡 Intuition & Approach
The goal is to identify a specific "pivot" point and reverse everything before it.

### 🛠️ The Strategy:
1. **Locate the Pivot:** Use `word.indexOf(ch)` to find the index of the first occurrence.
2. **Early Exit:** If the character isn't found (`-1`) or is already at the start (`0`), return the word as is.
3. **In-Place Reverse:** - Convert the string to a `char[]`.
   - Use two pointers: `start = 0` and `end = pivotIndex`.
   - Swap the characters at these pointers and move them toward each other until they meet.
4. **Reconstruct:** Return the modified array as a new String.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We traverse the string once to find the index, and at most once more to reverse a portion of it.
* **Space Complexity:** 𝙊(𝗻) - To store the character array for the modified string.

## 💻 Implementation (Java)
```java
class Solution {
    public String reversePrefix(String word, char ch) {
        int end = word.indexOf(ch);

        // If ch is not found or is the first character, no change needed
        if (end <= 0) {
            return word;
        }

        char[] chars = word.toCharArray();
        int start = 0;
        
        // Classic two-pointer swap for reversal
        while (start < end) {
            char tmp = chars[end];
            chars[end] = chars[start];
            chars[start] = tmp;

            start++;
            end--;
        }

        return new String(chars);
    }
}
