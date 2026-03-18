# 14. Longest Common Prefix (Easy)

## 📝 Problem Statement
Write a function to find the longest common prefix string amongst an array of strings. If there is no common prefix, return an empty string `""`.

## 💡 Intuition & Approach
The most efficient way to solve this without nested loops for every string is to use **Sorting**.

### 🛠️ The Strategy:
1. **Sort the Array:** Sort the strings lexicographically. This places the most alphabetically different strings at the `0` and `n-1` indices.
2. **Compare Extremes:** The longest common prefix for the entire array must be the common prefix between the **first** and the **last** string.
3. **Character Matching:**
   - Iterate through the characters of the first and last strings simultaneously.
   - If characters match, append to the result.
   - The moment characters differ, stop and return the result.
4. **Efficiency:** Sorting takes $O(N \log N \cdot M)$ where $M$ is the length of the strings, but it simplifies the comparison logic to a single linear pass of one string.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗡 𝗹𝗼𝗴 𝗡 ⋅ 𝗠) - Due to the sorting step, where $N$ is the number of strings and $M$ is the maximum string length.
* **Space Complexity:** 𝙊(𝗠) - To store the resulting prefix in a `StringBuilder`.

## 💻 Implementation (Java)
```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();

        // Sort strings lexicographically
        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length - 1];

        // Only compare the first and last strings
        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }
            ans.append(first.charAt(i));
        }

        return ans.toString();
    }
}
