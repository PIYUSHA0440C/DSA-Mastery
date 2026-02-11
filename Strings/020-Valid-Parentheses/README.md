# 20. Valid Parentheses (Easy)

## 📝 Problem Statement
Given a string `s` containing just the characters `(`, `)`, `{`, `}`, `[` and `]`, determine if the input string is valid.
A string is valid if:
1. Open brackets are closed by the same type.
2. Open brackets are closed in the correct order.
3. Every close bracket has a corresponding open bracket.

## 💡 Intuition & Approach
When dealing with nested structures where the inner-most element must be processed first, a **Stack** is the ideal data structure.

### 🛠️ The Strategy:
1. **Push Openers:** Whenever we see an opening bracket (`(`, `[`, `{`), we push it onto the stack.
2. **Pop & Match Closers:** Whenever we see a closing bracket:
   - Check if the stack is empty. If it is, we have a closer with no opener (return `false`).
   - Pop the top element from the stack.
   - Verify if the popped opener matches the current closer. If they don't match (e.g., `[` vs `)`), return `false`.
3. **Final Check:** After scanning the entire string, the stack must be empty. If any elements remain, it means an opener was never closed.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We traverse the string exactly once. Each stack operation (push/pop) is $O(1)$.
* **Space Complexity:** 𝙊(𝗻) - In the worst case (e.g., all opening brackets `((((`), the stack will store all $n$ characters.

## 💻 Implementation (Java)
```java
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            // If it's an opening bracket, push to stack
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                // If it's a closing bracket but stack is empty, return false
                if (stack.isEmpty()) return false;
                
                char top = stack.pop();
                // Validate if top matches the current closing bracket
                if (ch == ')' && top != '(') return false;
                if (ch == ']' && top != '[') return false;
                if (ch == '}' && top != '{') return false;
            }
        }
        // If stack is empty, all brackets were matched correctly
        return stack.isEmpty();
    }
}
