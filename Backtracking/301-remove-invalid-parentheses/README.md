# 301. Remove Invalid Parentheses (Hard)

## 📝 Problem Statement

Given a string `s` containing parentheses and lowercase English letters, remove the minimum number of invalid parentheses to make the string valid.

Return all unique valid strings that can be obtained using the minimum number of removals.

## 💡 Intuition & Approach

First, determine the minimum number of unmatched opening and closing parentheses that must be removed.

We scan the string to calculate `leftRem` and `rightRem`. Then, using DFS, we try removing only the required number of each type of parenthesis.

To avoid generating duplicate results, consecutive identical parentheses at the same recursion level are skipped.

Once all required removals have been made, the resulting string is checked for validity. If valid, it is added to the result.

### 🛠️ The Strategy:

1. Scan the string and calculate the minimum unmatched `'('` and `')'`.
2. Use DFS to explore possible removals.
3. Remove only `'('` when `leftRem > 0`.
4. Remove only `')'` when `rightRem > 0`.
5. Skip consecutive identical parentheses at the same recursion level to avoid duplicate states.
6. When all required removals are completed, check whether the string is valid.
7. Add every unique valid string to the result.

## 📊 Complexity Analysis

- **Time Complexity:** O(n · 2^n) in the worst case.
- **Space Complexity:** O(n · 2^n) in the worst case, including generated strings and recursion-related storage.

## 💻 Implementation (Java)

```java
public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        int leftRem = 0, rightRem = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                leftRem++;
            } else if (c == ')') {
                if (leftRem > 0) {
                    leftRem--;
                } else {
                    rightRem++;
                }
            }
        }

        dfs(s, 0, result, leftRem, rightRem);
        return result;
    }

    private void dfs(String s, int startIndex, List<String> result, int leftRem, int rightRem) {
        
        if (leftRem == 0 && rightRem == 0) {
            if (isValid(s)) {
                result.add(s);
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            char c = s.charAt(i);

            if (i > startIndex && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            
            if (leftRem > 0 && c == '(') {
                dfs(s.substring(0, i) + s.substring(i + 1), i, result, leftRem - 1, rightRem);
            }
            
            if (rightRem > 0 && c == ')') {
                dfs(s.substring(0, i) + s.substring(i + 1), i, result, leftRem, rightRem - 1);
            }
        }
    }
    
    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
                if (count < 0) return false;
            }
        }
        return count == 0;
    }
}
```
