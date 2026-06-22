# 1189. Maximum Number of Balloons (Easy)

## 📝 Problem Statement
Given a string `text`, you want to use the characters of `text` to form as many instances of the word **"balloon"** as possible. You can use each character in `text` at most once. Return the maximum number of instances that can be formed.

## 💡 Intuition & Approach
The problem asks us to find the maximum number of times the word `"balloon"` can be formed using the characters from a given string. This can be modeled as finding the **limiting reagent** or bottleneck among the required characters.

The character requirements for a single instance of `"balloon"` are:
* `'b'` $\rightarrow$ 1
* `'a'` $\rightarrow$ 1
* `'l'` $\rightarrow$ 2
* `'o'` $\rightarrow$ 2
* `'n'` $\rightarrow$ 1

Instead of tracking all 26 lowercase English letters, we allocate a localized frequency table of size 5 to specifically map out the occurrences of characters `'b'`, `'a'`, `'l'`, `'o'`, and `'n'`. Because `'l'` and `'o'` appear twice per word, their total counts must be divided by 2 (achieved efficiently using a bitwise right shift `>> 1`). The maximum number of complete words we can form is determined by the minimum available frequency among these normalized counts.

### 🛠️ The Strategy:
1. **Frequency Counting:** Iterate through the string and use a switch statement to populate a 5-element array tracking only the specific target characters.
2. **Frequency Normalization:** Apply a right-shift operation (`>> 1`) to indices representing `'l'` and `'o'` to account for their double-count requirements.
3. **Bottleneck Extraction:** Find the minimum value across all 5 indices in the frequency table to determine the maximum full words achievable.

## 📊 Complexity Analysis
* **Time Complexity:** O(N) - We perform a single linear pass over the input string of length $N$ to compile character counts.
* **Space Complexity:** O(1) - The memory footprint remains fixed using a primitive 5-element frequency array regardless of the input string size.

## 💻 Implementation (Java)
```java
class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] frequencies = new int[5];
        int minimum = text.length();
        
        // Count frequencies of characters 'b', 'a', 'l', 'o', 'n'
        for (int i = 0; i < text.length(); i++) {
            switch (text.charAt(i)) {
                case 'b': frequencies[0]++; break;
                case 'a': frequencies[1]++; break;
                case 'l': frequencies[2]++; break;
                case 'o': frequencies[3]++; break;
                case 'n': frequencies[4]++; break;
            }
        }

        // Normalize counts for characters that appear twice in "balloon"
        frequencies[2] >>= 1; // 'l'
        frequencies[3] >>= 1; // 'o'

        // Find the limiting character bottleneck
        for (int frequency : frequencies) {
            if (frequency < minimum) minimum = frequency;
        }

        return minimum;
    }
}
