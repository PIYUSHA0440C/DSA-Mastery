# 1768. Merge Strings Alternately (Easy)

## 📝 Problem Statement
You are given two strings `word1` and `word2`. Merge the strings by adding letters in alternating order, starting with `word1`. If a string is longer than the other, append the additional letters onto the end of the merged string.

## 💡 Intuition & Approach
This is a classic "Two-Pointer" simulation. We need to traverse both strings simultaneously and pick one character from each until one string runs out.

### 🛠️ The Strategy:
1. **Efficiency First:** Use a `StringBuilder` to avoid the overhead of String concatenation in Java.
2. **The Alternating Phase:** Use two pointers (`i` and `j`) to track the current index of `word1` and `word2`. Loop while both pointers are within bounds.
3. **The Cleanup Phase:** After the main loop, one string might still have characters left. Use two separate `while` loops (or conditions) to append the remaining tail of whichever string was longer.
4. **Final Conversion:** Convert the `StringBuilder` back to a `String` and return.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻 + 𝗺) - We visit every character in both strings exactly once.
* **Space Complexity:** 𝙊(𝗻 + 𝗺) - We store the merged result in a `StringBuilder` which grows to the sum of both string lengths.

## 💻 Implementation (Java)
```java
class Solution {
    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int i = 0, j = 0;

        StringBuilder sb = new StringBuilder();
        
        // Phase 1: Alternate characters
        while(i < len1 && j < len2){
            sb.append(word1.charAt(i++));
            sb.append(word2.charAt(j++));
        }
        
        // Phase 2: Append remaining from word1
        while(i < len1){
            sb.append(word1.charAt(i++));
        }
        
        // Phase 3: Append remaining from word2
        while(j < len2){
            sb.append(word2.charAt(j++));
        }
        
        return sb.toString();
    }
}
