# 720. Longest Word in Dictionary (Medium)

## 📝 Problem Statement

Given an array of strings `words`, return the longest word that can be built one character at a time by adding a character to the end of a previously existing word. If multiple words have the same maximum length, return the lexicographically smallest one. If no valid word exists, return an empty string.

## 💡 Intuition & Approach

Store all words in a `HashSet` for efficient lookup. For each candidate word that could improve the current answer, check whether every prefix of lengths `1` through `word.length() - 1` exists in the set.

If all prefixes exist, the word can be built one character at a time. Update the answer when the word is longer or has the same length but is lexicographically smaller.

### 🛠️ The Strategy:

1. Initialize the answer as an empty string.
2. Add all words to a `HashSet`.
3. Iterate through each word, considering only candidates longer than the current answer or lexicographically smaller candidates of equal length.
4. Check whether every non-empty proper prefix exists in the set.
5. If all prefixes exist, update the answer.
6. Return the final answer.

## 📊 Complexity Analysis

Let `n` be the number of words and `L` be the maximum word length.

- **Time Complexity:** O(n × L²) in the worst case, accounting for prefix creation and string hashing.
- **Space Complexity:** O(n × L), for storing all words in the `HashSet`.

## 💻 Implementation (Java)

```java
class Solution {
    public String longestWord(String[] words) {
        String ans = "";
        Set<String> wordset = new HashSet();
        for (String word: words) {
            wordset.add(word);
        }
        for (String word: words) {
            if (word.length() > ans.length() ||
                    word.length() == ans.length() && word.compareTo(ans) < 0) {
                boolean good = true;
                for (int k = 1; k < word.length(); ++k) {
                    if (!wordset.contains(word.substring(0, k))) {
                        good = false;
                        break;
                    }
                }
                if (good) {
                    ans = word;
                }
            }    
        }
        return ans;
    }
}
```
