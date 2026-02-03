# 1528. Shuffle String (Easy)

## 📝 Problem Statement
You are given a string `s` and an integer array `indices` of the same length. The string `s` will be shuffled such that the character at the `ith` position moves to `indices[i]` in the shuffled string. Return the restored string.

## 💡 Intuition & Approach
The problem provides a destination for every character. Instead of trying to sort the string in-place (which is difficult with immutable Strings in Java), we use an auxiliary character array to place each character exactly where it belongs.

### 🛠️ The Strategy:
1. **Target Buffer:** Initialize a `char[]` of the same length as `s`.
2. **Direct Mapping:** Loop through the `indices` array. For each `i`, take the character at `s.charAt(i)` and place it at `ch[indices[i]]`.
3. **Optimized Conversion:** Use `String.valueOf(ch)` to convert the array back into a String. This is faster than manual concatenation or `Arrays.toString()`.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We iterate through the string and the indices array exactly once.
* **Space Complexity:** 𝙊(𝗻) - We use an extra character array to store the shuffled result.

## 💻 Implementation (Java)
```java
class Solution {
    public String restoreString(String s, int[] indices) {
        int len = indices.length;
        char[] ch = new char[len];
        
        for(int i = 0; i < len; i++) {
            // The character at current position 'i' 
            // belongs at position 'indices[i]' in the result
            ch[indices[i]] = s.charAt(i);
        }
        
        return String.valueOf(ch);
    }
}
