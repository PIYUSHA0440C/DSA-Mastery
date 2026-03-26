# 38. Count and Say (Medium)

## 📝 Problem Statement
The "Count and Say" sequence is defined recursively:
- `countAndSay(1) = "1"`
- `countAndSay(n)` is the run-length encoding (RLE) of `countAndSay(n - 1)`.

Run-length encoding involves replacing consecutive identical characters with the count of the character followed by the character itself (e.g., "332" becomes "2312").

## 💡 Intuition & Approach
The problem asks for the $n^{th}$ term, which means we need to generate each term starting from "1" up to $n$.

### 🛠️ The Strategy:
1. **Iterative Generation:** Start with the base string `result = "1"`.
2. **Outer Loop:** Run $n-1$ times to reach the desired term.
3. **Inner Loop (RLE logic):** - Traverse the current `result` string.
   - Keep a `count` of identical consecutive characters.
   - When the character changes, append the `count` and the character to a `StringBuilder`.
4. **Final Append:** After the inner loop, append the last group of characters that were being counted.
5. **Update:** Set `result` to the newly built string and repeat.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝟮ⁿ) - While the exact growth is complex (related to Conway's constant), the length of the string roughly doubles with each step.
* **Space Complexity:** 𝙊(𝟮ⁿ) - To store the generated string for the next iteration.

## 💻 Implementation (Java)
```java
class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String result = "1";

        for (int i = 1; i < n; i++) {
            StringBuilder current = new StringBuilder();
            int count = 1;

            // Perform Run-Length Encoding on the previous result
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    current.append(count).append(result.charAt(j - 1));
                    count = 1; // Reset count for the new character
                }
            }
            // Append the last character group
            current.append(count).append(result.charAt(result.length() - 1));
            result = current.toString();
        }

        return result; 
    }
}
