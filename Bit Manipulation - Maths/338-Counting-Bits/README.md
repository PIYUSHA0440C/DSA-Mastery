# 338. Counting Bits (Easy)

## 📝 Problem Statement
Given an integer `n`, return an array `ans` of length `n + 1` where `ans[i]` is the number of 1's in the binary representation of `i`.

## 💡 Intuition & Approach
The goal is to solve this in linear time $O(n)$ without using built-in pop-count functions. We use **Dynamic Programming** to build the solution for `i` based on previously computed values.

### 🛠️ The Strategy:
1. **The Relation:** Any number `i` can be seen as `i >> 1` (which is $i/2$) with one extra bit shifted in.
2. **Right Shift:** `ans[i >> 1]` gives us the number of set bits in the number excluding the last bit.
3. **Last Bit Check:** `(i & 1)` tells us if the current number's last bit is a `1` (odd) or `0` (even).
4. **The Formula:** `ans[i] = ans[i >> 1] + (i & 1)`.
   - If `i = 5` (101), `i >> 1` is `2` (10). 
   - `ans[5] = ans[2] + (5 & 1)` $\to$ `1 + 1 = 2`.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We traverse from 1 to $n$ exactly once.
* **Space Complexity:** 𝙊(𝗻) - To store the resulting array of size $n+1$.

## 💻 Implementation (Java)
```java
class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        
        // ans[0] is naturally 0
        for (int i = 1; i <= n; i++) {
            // DP state: bits in i = bits in (i/2) + (1 if i is odd)
            ans[i] = ans[i >> 1] + (i & 1);
        }
        
        return ans;
    }
}
