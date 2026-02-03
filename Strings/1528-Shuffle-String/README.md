# 1528. Shuffle String (Easy)

## 📝 Problem Statement
You are given a string `s` and an integer array `indices` of the same length. The string `s` will be shuffled such that the character at the `i`-th position moves to `indices[i]` in the shuffled string. Return the restored string.

## 💡 Intuition & Approach
The problem gives us a direct mapping. For every character at `s.charAt(i)`, we know its final destination is `indices[i]`. 



### 🛠️ The Strategy:
1. **Auxiliary Array:** Create a character array `ch` of the same length as the input string.
2. **Direct Placement:** Iterate through the string and the indices array simultaneously.
   - The character `s.charAt(i)` belongs at index `indices[i]` in the result array.
   - `ch[indices[i]] = s.charAt(i);`
3. **Conversion:** Convert the character array back to a string using `String.valueOf(ch)`.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We traverse the string once to place characters.
* **Space Complexity:** 𝙊(𝗻) - We use a character array to store the result before converting to a string.

## 💻 Implementation (Java)
```java
class Solution {
    public String restoreString(String s, int[] indices) {
        int len = indices.length;
        char[] ch = new char[len];
        
        for(int i = 0; i < len; i++) {
            // indices[i] tells us WHERE the i-th character of s should go
            int targetIndex = indices[i];
            ch[targetIndex] = s.charAt(i);
        }
        
        return String.valueOf(ch);
    }
}
