# 1614. Maximum Nesting Depth of the Parentheses (Easy)

## 📝 Problem Statement
Given a valid parentheses string `s`, return the nesting depth of `s`. The nesting depth is the maximum number of nested parentheses at any point in the string.

## 💡 Intuition & Approach
Since the input is guaranteed to be a Valid Parentheses String (VPS), we can represent the depth as a simple counter that increments with every opening bracket and decrements with every closing bracket.

### 🛠️ The Strategy:
1. **Depth Counter:** Initialize `tempMax` (current depth) and `ans` (global maximum depth).
2. **Linear Scan:** Traverse the string character by character.
   - If the character is `(`, increment `tempMax`.
   - If the character is `)`, decrement `tempMax`.
3. **Record Maximum:** After each operation, update `ans` using `Math.max(ans, tempMax)` to capture the deepest level reached during the traversal.
4. **Ignore Non-Parentheses:** Digits and operators (`+`, `-`, `*`, `/`) do not affect the depth level, so they are simply skipped.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We iterate through the string exactly once.
* **Space Complexity:** 𝙊(𝟭) - We only store two integer variables, regardless of string length.

## 💻 Implementation (Java)
```java
class Solution {
    public int maxDepth(String s) {
        int ans = 0;
        int tempMax = 0;
        
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                tempMax++;
                // Update global max whenever we go deeper
                ans = Math.max(ans, tempMax);
            } else if (ch == ')') {
                tempMax--;
            }
        }
        
        return ans;
    }
}
