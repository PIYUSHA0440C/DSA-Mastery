# 1190. Reverse Substrings Between Each Pair of Parentheses (Medium)

## 📝 Problem Statement

Given a string `s` containing lowercase English letters and balanced parentheses, reverse the strings inside each pair of matching parentheses, starting from the innermost pair.

Return the resulting string without any parentheses.

## 💡 Intuition & Approach

Instead of repeatedly reversing substrings, we can first identify the matching position of every parenthesis.

Then, while traversing the string, whenever a parenthesis is encountered, jump directly to its matching parenthesis and reverse the traversal direction. This allows the required reversals to be performed implicitly.

### 🛠️ The Strategy:

1. Use a stack to find the matching pair for every parenthesis.
2. Store each matching position in the `pair` array.
3. Traverse the string using `idx` and a `direction`.
4. When a parenthesis is encountered:
   - Jump to its matching parenthesis.
   - Reverse the traversal direction.
5. Append only lowercase characters to the result.
6. Return the resulting string.

## 📊 Complexity Analysis

- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(n)`

## 💻 Implementation (Java)

```java
class Solution {
    public String reverseParentheses(String s) {
        int len = s.length();
        int[] pair = new int[len];

        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < len; i++){
            if (s.charAt(i) == '(') stack.push(i);
            else if (s.charAt(i) == ')') {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }

        StringBuilder res = new StringBuilder();
        int idx = 0, direction = 1;

        while (idx >= 0 && idx < len){
            if (s.charAt(idx) == '(' || s.charAt(idx) == ')') {
                idx = pair[idx];
                direction = - direction;
            } else {
                res.append(s.charAt(idx));
            }

            idx += direction;
        }

        return res.toString();
    }
}
```
