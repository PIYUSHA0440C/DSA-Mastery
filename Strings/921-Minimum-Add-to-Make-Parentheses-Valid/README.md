# 921. Minimum Add to Make Parentheses Valid (Medium)

## 📝 Problem Statement
Given a parentheses string `s`, return the minimum number of insertions (moves) required to make the string valid. A string is valid if all opening brackets have corresponding closing brackets in the correct order.

## 💡 Intuition & Approach
Instead of a Stack, we use two counters to track "unbalanced" parentheses in a single pass.

### 🛠️ The Strategy:
1. **Counters:**
   - `open`: Tracks how many `(` are currently waiting for a matching `)`.
   - `close`: Tracks how many `)` appeared without a matching `(` before them.
2. **The Logic:**
   - If we see `(`: Increment `open`.
   - If we see `)`: 
     - If `open > 0`: We use one of the waiting openers to balance this closer (`open--`).
     - If `open == 0`: This closer is unmatched and "orphaned" (`close++`).
3. **Result:** The total number of characters to add is `open + close`.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - A single linear scan through the string.
* **Space Complexity:** 𝙊(𝟭) - Only two integer variables are used.

## 💻 Implementation (Java)
```java
class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;   // Net open parentheses needing a ')'
        int close = 0;  // Net close parentheses needing a '('
        
        for(char ch : s.toCharArray()){
            if(ch == '(') {
                open++;
            } else {
                if(open > 0) {
                    // This ')' balances a previous '('
                    open--;
                } else {
                    // No '(' to balance this ')', so we must "add" a '(' later
                    close++;
                }
            }
        }
        
        // Total moves = orphaned '(' + orphaned ')'
        return open + close;
    }
}
