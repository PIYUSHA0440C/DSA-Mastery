# 1967. Number of Strings That Appear as Substrings in Word (Easy)

## 📝 Problem Statement
Given an array of strings `patterns` and a string `word`, return the number of strings in `patterns` that exist as a substring in `word`.

A **substring** is a contiguous sequence of characters within a string.

## 💡 Intuition & Approach
The problem asks us to check each individual string template from the `patterns` array and count how many of them are present as a contiguous block inside the target string `word`.

Since the constraints on the lengths of both the string array and the individual strings are small ($\le 100$), a direct evaluation approach is highly efficient. We can iterate through each pattern string sequentially and check for its presence within `word` using built-in substring matching primitives (like Java's `String.contains()`). 

### 🛠️ The Strategy:
1. **Initialize Count:** Set up a simple scalar accumulator variable `count = 0`.
2. **Linear Matching Loop:** Iterate through each string `str` inside the `patterns` array.
3. **Substring Verification:** Check if `word.contains(str)` evaluates to true. If it does, increment the `count` tracker by 1.
4. **Return Results:** Return the total aggregated `count`.

## 📊 Complexity Analysis
* **Time Complexity:** O(N * M) - Where $N$ is the number of elements inside the `patterns` array and $M$ is the length of the string `word`. For each pattern, the underlying `contains()` method scans the `word` string using matching patterns.
* **Space Complexity:** O(1) - No extra custom objects or auxiliary structural buffers are allocated in memory.

## 💻 Implementation (Java)
```java
class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;
        
        // Loop through each pattern and verify its existence inside word
        for (String str : patterns) {
            if (word.contains(str)) {
                count++;
            }
        }

        return count;
    }
}
