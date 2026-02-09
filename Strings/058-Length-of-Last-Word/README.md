# 58. Length of Last Word (Easy)

## 📝 Problem Statement
Given a string `s` consisting of words and spaces, return the length of the last word in the string. A word is a maximal substring consisting of non-space characters only.

## 💡 Intuition & Approach
The most efficient way to find the last word is to look at the string from the **end** rather than the beginning.

### 🛠️ The Strategy:
1. **Trim Trailing Spaces:** Use `.trim()` to remove any trailing whitespace that might interfere with identifying the last character of the last word.
2. **Backward Iteration:** Start from the end of the trimmed string and move toward the beginning.
3. **Space Detection:** The moment we encounter a space `' '`, we know the last word has ended. The length is calculated based on the current index relative to the total length.
4. **Single Word Case:** If the loop finishes without finding a space, it means the entire string (after trimming) is one word.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - `.trim()` takes linear time, and the backward scan takes at most linear time.
* **Space Complexity:** 𝙊(𝗻) - In Java, `.trim()` creates a new string object. 
  *(Note: For $O(1)$ space, you could manually skip trailing spaces with a loop instead of using `.trim()`)*.

## 💻 Implementation (Java)
```java
class Solution {
    public int lengthOfLastWord(String s) {
        // Step 1: Remove trailing and leading spaces
        s = s.trim();
        int length = s.length();
        
        // Step 2: Scan from right to left
        for(int i = length - 1; i >= 0; i--){
            // When we hit a space, the word is over
            if(s.charAt(i) == ' ') return length - i - 1;
        }
        
        // Step 3: If no space is found, the whole string is the last word
        return length;
    }
}
