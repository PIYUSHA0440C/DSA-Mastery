# 500. Keyboard Row (Easy)

## 📝 Problem Statement
Given an array of strings `words`, return the words that can be typed using letters of alphabet on only **one row** of the American keyboard.

## 💡 Intuition & Approach
The core of this problem is to check if all characters of a word belong to the same character set (one of the three keyboard rows).

### 🛠️ The Strategy:
1. **Define Rows:** Store the three rows of the QWERTY keyboard as strings or sets.
2. **Modular Validation:** Create a helper function `isInRow(word, row)` that:
   - Converts the word to lowercase.
   - Iterates through each character.
   - Returns `false` if any character is not found in that specific row string.
3. **Filtering:** Iterate through the input array and check if a word fits into *any* of the three rows.
4. **Collection:** Store valid words in a dynamic list and convert them back to a primitive array for the final result.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗡 × 𝗟) - Where $N$ is the number of words and $L$ is the average length of a word. We check each character against a row string.
* **Space Complexity:** 𝙊(𝗡 × 𝗟) - To store the resulting list of words. The row storage itself is $O(1)$ constant space.

## 💻 Implementation (Java)
```java
class Solution {
    public String[] findWords(String[] words) {
        List<String> res = new ArrayList<>();
        // Define the keyboard rows
        String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        
        for (String word : words) {
            // Check if the word belongs entirely to any one row
            if (isInRow(word, rows[0]) || isInRow(word, rows[1]) || isInRow(word, rows[2])) {
                res.add(word);
            }
        }

        return res.toArray(new String[0]);
    }

    private boolean isInRow(String word, String row) {
        word = word.toLowerCase();
        for (char ch : word.toCharArray()) {
            // If character isn't in the row, this row is invalid for this word
            if (row.indexOf(ch) == -1) return false;
        }
        return true;
    }
}
