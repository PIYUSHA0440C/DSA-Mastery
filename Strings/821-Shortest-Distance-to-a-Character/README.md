# 821. Shortest Distance to a Character (Easy)

## 📝 Problem Statement
Given a string `s` and a character `c`, return an array `answer` where `answer[i]` is the absolute distance from index `i` to the closest occurrence of character `c` in `s`.

## 💡 Intuition & Approach
The closest occurrence of a character can either be to the **left** or to the **right** of the current index. 

### 🛠️ The Strategy:
1. **Pointers:** Use `j` to scan for the next occurrence of `c`, and `temp` to remember the last seen occurrence of `c`.
2. **The Comparison:** Whenever `j` hits the target character `c`:
   - Fill all indices `i` up to `j` by comparing the distance to the *previous* `c` (`temp`) and the *current* `c` (`j`).
   - Use `Math.min(abs(j - i), abs(temp - i))` to ensure we get the shortest path.
3. **Updating State:** Move the `temp` pointer to `j` and continue scanning.
4. **Final Tail:** After the last `c` is found, any remaining characters in the string only have one direction to look (backwards to `temp`), so we fill the rest of the array accordingly.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - Even though there is a nested while loop, each index `i` and `j` is visited a constant number of times.
* **Space Complexity:** 𝙊(𝟭) - Excluding the output array, we only use a few integer variables.

## 💻 Implementation (Java)
```java
class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] ar = new int[n];
        int i = 0, j = 0;
        int temp = Integer.MAX_VALUE; // Stores index of previous 'c'

        while (j < n) {
            if (s.charAt(j) == c) {
                while (i <= j) {
                    // Min distance between last seen 'c' and current 'c'
                    ar[i] = Math.min(Math.abs(j - i), Math.abs(temp - i));
                    i++;
                }
                temp = j; // Update 'last seen' to current index
            }
            j++;
        }
        // Handle characters after the last occurrence of 'c'
        while (i < n) {
            ar[i] = Math.abs(temp - i);
            i++;
        }

        return ar;
    }
}
