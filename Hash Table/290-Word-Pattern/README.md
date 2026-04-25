# 290. Word Pattern (Easy)

## 📝 Problem Statement
Given a `pattern` string and a string `s`, determine if `s` follows the same pattern. A full match exists if there is a **bijection** between a letter in the pattern and a non-empty word in `s`.

## 💡 Intuition & Approach
A bijection means:
1. Every character in `pattern` maps to exactly one word in `s`.
2. Every word in `s` maps back to exactly one character in `pattern`.

### 🛠️ The Strategy:
1. **Split the String:** Convert `s` into an array of words using `split(" ")`.
2. **Length Check:** If the number of characters in `pattern` doesn't match the number of words in `s`, a bijection is impossible.
3. **HashMap Mapping:**
   - Iterate through the pattern and words simultaneously.
   - If the character isn't in the map:
     - Check if the current word is already "owned" by another character using `map.containsValue()`. If it is, return `false`.
     - Otherwise, create the new mapping.
   - If the character is in the map:
     - Verify that the stored word matches the current word. If not, return `false`.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗡 + 𝗠) - where $N$ is the length of the pattern and $M$ is the number of characters in $s$. Note: `containsValue()` is $O(K)$ where $K$ is the number of unique entries in the map, making the worst case slightly higher, but for small constraints (300), it remains very efficient.
* **Space Complexity:** 𝙊(𝗠) - To store the split words and the mapping in the HashMap.

## 💻 Implementation (Java)
```java
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;

        Map<Character, String> map = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];

            if (map.containsKey(ch)) {
                // Existing char must match the current word
                if (!map.get(ch).equals(word)) return false;
            } else {
                // New char must map to a word not already in use
                if (map.containsValue(word)) return false;
                map.put(ch, word);
            }
        }
        return true;
    }
}
