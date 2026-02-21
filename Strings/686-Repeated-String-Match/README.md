# 686. Repeated String Match (Medium)

## 📝 Problem Statement
Given two strings `a` and `b`, return the minimum number of times you should repeat string `a` so that string `b` is a substring of it. If it is impossible, return -1.

## 💡 Intuition & Approach
The core idea is to find the minimum repetitions of `a` that could possibly contain `b`. 

### 🛠️ The Strategy:
1. **Initial Building:** Use a `StringBuilder` to repeat string `a` until its length is at least as long as string `b`. Keep a `count` of repetitions.
2. **First Check:** At each step in the `while` loop, check if `b` is a substring of the current repeated `a` using `indexOf()`.
3. **The "Plus One" Rule:** Even if the repeated `a` is longer than `b`, `b` might still be split across the boundary.
   - Example: `a = "abcd"`, `b = "cdabcdab"`.
   - 2 repeats: `"abcdabcd"` (Length 8, same as `b`, but doesn't contain `b`).
   - 3 repeats: `"abcdabcdabcd"` (Contains `b`).
4. **Conclusion:** If `b` isn't found after repeating `a` until its length is $\geq b.length$ plus one more extra repetition, it will never be found.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻 * 𝗺) :- where $n$ is the length of `a` and $m$ is the length of `b`. `StringBuilder.indexOf()` (the underlying search) typically takes $O(\text{total\_length} \times b.length)$.
* **Space Complexity:** 𝙊(𝗻 + 𝗺) :- To store the repeated string in the `StringBuilder`.

## 💻 Implementation (Java)
```java
class Solution {
    public int repeatedStringMatch(String a, String b) {
        int count = 0;
        int bLen = b.length();
        StringBuilder sb = new StringBuilder("");
        
        // Repeat until sb is at least as long as b
        while(sb.length() < bLen) {
            sb.append(a);
            count++;
        }
        
        // Check if b is already there
        if(sb.indexOf(b) >= 0) return count;
        
        // Add one more 'a' to handle cases where b starts at the end of a
        sb.append(a);
        count++;
        if(sb.indexOf(b) >= 0) return count;

        return -1;
    }
}
