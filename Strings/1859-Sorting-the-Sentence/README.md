# 1859. Sorting the Sentence (Easy)

## 📝 Problem Statement
A sentence is shuffled by appending a 1-indexed position to each word and rearranging them. Given a shuffled sentence `s`, reconstruct and return the original sentence by sorting the words and removing the numbers.

## 💡 Intuition & Approach
Since the positions are explicitly given as digits at the end of each word, we can use an auxiliary array to place each word directly into its correct position.

### 🛠️ The Strategy:
1. **Splitting:** Break the input string into individual words using `s.split(" ")`.
2. **Indexing:** For each word:
   - Extract the last character: `w.charAt(w.length() - 1)`.
   - Convert it to an integer index (subtracting `'1'` to make it 0-indexed).
   - Strip the digit from the word using `substring(0, len - 1)`.
3. **Placement:** Store the cleaned word in a result array `res` at the calculated index.
4. **Joining:** Use `String.join(" ", res)` to combine the words back into a single sentence.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - where $n$ is the total number of characters in the string. We traverse the string to split it and then iterate through the words once.
* **Space Complexity:** 𝙊(𝗻) - To store the split words and the reconstructed result array.

## 💻 Implementation (Java)
```java
class Solution {
    public String sortSentence(String s) {
        // Split the sentence into words
        String[] words = s.split(" ");
        String[] res = new String[words.length];

        for (String w : words) {
            // Get index from the last character (1-indexed to 0-indexed)
            int idx = w.charAt(w.length() - 1) - '1';
            
            // Remove the digit and place in result array
            res[idx] = w.substring(0, w.length() - 1);
        }

        // Join the array back into a single string
        return String.join(" ", res);
    }
}
