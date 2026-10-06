# 921. Minimum Add to Make Parentheses Valid (Medium)

## 📝 Problem Statement

Given a parentheses string `s`, return the minimum number of parentheses that must be inserted to make the string valid.

## 💡 Intuition & Approach

We keep track of unmatched opening and closing parentheses while scanning the string.

When we encounter `'('`, we increase the count of unmatched opening parentheses.

When we encounter `')'`, we use an available unmatched `'('` if one exists. Otherwise, this `')'` is unmatched and requires an additional `'('` to be inserted before it.

At the end, any remaining unmatched `'('` requires a corresponding `')'`.

Therefore, the answer is the total number of unmatched opening and closing parentheses.

### 🛠️ The Strategy:

1. Maintain `open` for unmatched opening parentheses.
2. Maintain `close` for unmatched closing parentheses.
3. For `'('`, increment `open`.
4. For `')'`, decrement `open` if an unmatched opening parenthesis exists.
5. Otherwise, increment `close`.
6. Return `open + close`.

## 📊 Complexity Analysis

- **Time Complexity:** O(n)
- **Space Complexity:** O(1)

## 💻 Implementation (Java)

```java
class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0, close = 0;

        for(char ch: s.toCharArray()){
            if (ch == '(') open++;
            else if(open > 0) open--;
            else close++;
        }

        return open + close;
    }
}
```
