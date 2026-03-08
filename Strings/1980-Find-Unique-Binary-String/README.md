# 1980. Find Unique Binary String (Medium)

## 📝 Problem Statement
Given an array of $n$ unique binary strings each of length $n$, return a binary string of length $n$ that does not appear in the input array.

## 💡 Intuition & Approach
The problem can be solved by generating binary strings and checking their existence in a set. Since $n$ is small (up to 16), a recursive backtracking approach is feasible.

### 🛠️ The Strategy:
1. **Hashing:** Store all input strings in a `HashSet` for $O(1)$ lookup.
2. **Backtracking (The Search):** - Start with an empty string.
   - At each step, try appending '0' and recurse. If that doesn't return a valid string, try '1'.
   - **Base Case:** When the string length equals $n$, check if it exists in the `HashSet`. If it's missing, return it as the answer.
3. **Alternative (Diagonal Argument):** By flipping the $i$-th character of the $i$-th string, you can construct a unique string in $O(n)$ time.



## 📊 Complexity Analysis
* **Time Complexity: -** $O(2^n)$ in the worst case for backtracking, though it usually finds a result much faster since there are only $n$ strings out of $2^n$ possibilities.
* **Space Complexity: -** $O(n)$ for the recursion stack and $O(n^2)$ for the `HashSet`.

## 💻 Implementation (Java)
```java
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> set = new HashSet<>();
        int len = nums[0].length();

        for(String str : nums) {
            set.add(str);
        }
        
        return helper("", set, len);
    }

    String helper(String up, HashSet<String> set, int len) {
        if(up.length() == len) {
            return !set.contains(up) ? up : "";
        }

        // Try adding '0'
        String ans = helper(up + '0', set, len);
        if(!ans.equals("")) return ans;
        
        // Try adding '1'
        return helper(up + '1', set, len);
    }
}
