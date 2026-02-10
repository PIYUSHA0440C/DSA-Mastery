# 796. Rotate String (Easy)

## 📝 Problem Statement
Given two strings `s` and `goal`, return `true` if and only if `s` can become `goal` after some number of shifts on `s`. A shift consists of moving the leftmost character to the rightmost position.

## 💡 Intuition & Approach
The brute-force way is to manually shift the string $n$ times and check if it matches the goal. However, there is a mathematical property we can exploit:

**Property:** If we concatenate a string with itself ($s + s$), the resulting string contains **every possible rotation** of the original string as a substring.



### 🛠️ The Strategy:
1. **Length Check:** If the lengths of `s` and `goal` are different, it's impossible for one to be a rotation of the other. Return `false`.
2. **Concatenation:** Create a new string `doubledS = s + s`.
3. **Containment:** Check if `goal` exists within `doubledS`.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻²) - Concatenating two strings takes $O(n)$, and the `.contains()` method (which uses a naive search in most Java versions) takes $O(n \times m)$. Since $m = n$, it's $O(n^2)$.
* **Space Complexity:** 𝙊(𝗻) - We create a new string that is twice the length of `s`.

## 💻 Implementation (Java)
```java
class Solution {
    public boolean rotateString(String s, String goal) {
        // Step 1: Rotations must have the same length
        if(s.length() != goal.length()) return false;
        
        // Step 2: Goal must be a substring of s + s
        return (s + s).contains(goal);
    }
}
