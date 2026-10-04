# 678. Valid Parenthesis String (Medium)

## 📝 Problem Statement

Given a string `s` containing `'('`, `')'`, and `'*'`, determine whether the string is valid.

A `'*'` can be treated as `'('`, `')'`, or an empty string.

## 💡 Intuition & Approach

The main challenge is deciding what each `'*'` should represent.

We use recursion with memoization. At every index, we keep track of `openCount`, which represents the number of unmatched opening parentheses currently available.

For `'*'`, we try all three possibilities: treat it as `'('`, treat it as `')'` if there is an unmatched opening parenthesis, or treat it as empty.

Memoization stores the result for each `(index, openCount)` state so the same state is not solved repeatedly.

At the end of the string, the string is valid only when `openCount` becomes zero.

### 🛠️ The Strategy:

1. Start from index `0` with `openCount = 0`.
2. For `'('`, increase `openCount`.
3. For `')'`, decrease `openCount` only if an unmatched `'('` exists.
4. For `'*'`, try `'('`, `')'`, and empty.
5. Store each state result in the memoization table.
6. Return whether any valid path reaches the end with `openCount = 0`.

## 📊 Complexity Analysis

- **Time Complexity:** O(n²)
- **Space Complexity:** O(n²)

## 💻 Implementation (Java)

```java
class Solution {
    public boolean checkValidString(String s) {
        int len = s.length();
        int[][] memo = new int[len][len];

        for(int[] row: memo) Arrays.fill(row, -1);

        return isValidString(memo, s, 0, 0);
    }

    private boolean isValidString(int[][] memo, String str, int index, int openCount){
        if(index == str.length()) return openCount == 0;

        if(memo[index][openCount] != -1) return memo[index][openCount] == 1;

        boolean isValid = false;

        if (str.charAt(index) == '*') {
            isValid |= isValidString(memo, str, index + 1, openCount + 1);

            if(openCount > 0){
                isValid |= isValidString(memo, str, index + 1, openCount - 1);
            }

            isValid |= isValidString(memo, str, index + 1, openCount);
        } else {
            if (str.charAt(index) == '('){
                isValid = isValidString(memo, str, index + 1, openCount + 1);
            } else if (openCount > 0) {
                isValid = isValidString(memo, str, index + 1, openCount - 1);
            }
        }

        memo[index][openCount] = isValid ? 1 : 0;
        return isValid;
    }
}
```
