# 686. Repeated String Match (Medium)

## 📝 Problem Statement
Given two strings `a` and `b`, return the minimum number of times `a` should be repeated so that `b` is a substring of it. If it is impossible, return -1.

## 💡 Intuition & Approach
The challenge lies in knowing exactly how many times to repeat `a`. Since `b` must fit inside the repeated version of `a`, the resulting string must at least be as long as `b`.

### 🛠️ The Strategy:
1. **The Minimum Baseline:** Repeat `a` using a `StringBuilder` until its length is $\geq$ the length of `b`. 
2. **The "Plus One" Edge Case:** Even if `repeated_a` is longer than `b`, `b` could be "wrapped" around. 
   - *Example:* `a = "abcd"`, `b = "cdabcdab"`. 
   - After 2 repeats: `"abcdabcd"` (length 8, same as `b`, but `b` isn't there).
   - After 3 repeats: `"abcdabcdabcd"` (Now `b` is found!).
3. **The Limit:** If `b` isn't found after repeating `a` enough times to exceed `b.length` plus one extra copy of `a`, it's mathematically impossible.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗡 * 𝗠) - where $N$ is the length of `a` and $M$ is the length of `b`. The `indexOf` method performs a substring search on the accumulated string.
* **Space Complexity:** 𝙊(𝗡 + 𝗠) - To store the repeated string in a `StringBuilder`.

## 💻 Implementation (Java)
```java
class Solution {
    public int repeatedStringMatch(String a, String b) {
        int count = 0;
        int bLen = b.length();
        StringBuilder sb = new StringBuilder("");
        
        // Repeat 'a' until its length is at least the length of 'b'
        while(sb.length() < bLen){
            sb.append(a);
            count++;
        }
        
        // Check if b is currently a substring
        if(sb.indexOf(b) >= 0) return count;
        
        // One extra repeat to catch wrap-around cases
        sb.append(a);
        count++;
        if(sb.indexOf(b) >= 0) return count;

        return -1;
    }
}
