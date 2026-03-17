# 1021. Remove Outermost Parentheses (Easy)

## 📝 Problem Statement
A valid parentheses string can be decomposed into "primitive" valid strings. For example, `(()())(())` is decomposed into `(()())` and `(())`. The goal is to remove the outermost parentheses of every primitive string and return the result.

## 💡 Intuition & Approach
Instead of using a Stack to find matches, we can use a single integer `level` to keep track of the nesting depth.

### 🛠️ The Strategy:
1. **Track Level:** Use a variable `level` to count open parentheses.
2. **Opening Bracket `(`:** - If `level > 0`, it means this bracket is NOT the outermost one. Append it to the result.
   - Increment `level`.
3. **Closing Bracket `)`:**
   - Decrement `level`.
   - If `level > 0`, it means this bracket is NOT the outermost one. Append it to the result.
4. **Result:** By only appending when the depth is greater than 0, the outermost layer (where `level` starts or ends at 0) is naturally excluded.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We iterate through the string exactly once.
* **Space Complexity:** 𝙊(𝗻) - To store the final result in a `StringBuilder`.

## 💻 Implementation (Java)
```java
class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int level = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                // If level > 0, this '(' is not the outermost one
                if (level > 0) result.append(ch);
                level++;
            } else {
                level--;
                // If level > 0, this ')' is not the outermost one
                if (level > 0) result.append(ch);
            }
        }

        return result.toString();
    }
}
