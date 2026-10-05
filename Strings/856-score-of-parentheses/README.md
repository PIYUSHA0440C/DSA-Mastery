# 856. Score of Parentheses (Medium)

## 📝 Problem Statement

Given a balanced parentheses string `s`, return its score.

The score follows these rules:

- `"()"` has a score of `1`.
- `AB` has a score of `A + B`.
- `(A)` has a score of `2 * A`.

## 💡 Intuition & Approach

The key observation is that the score of `"()"` depends on its nesting depth. A pair of parentheses at depth `d` contributes `2^d` to the total score, where the depth is measured after closing the pair.

We maintain the current nesting depth. Whenever we encounter `')'`, we decrease the depth. If the previous character was `'('`, we have found a primitive `"()"` pair, so we add `2^depth` to the answer.

The bit-shift operation `1 << depth` is equivalent to `2^depth`.

### 🛠️ The Strategy:

1. Maintain the current parentheses depth.
2. Increase the depth when encountering `'('`.
3. Decrease the depth when encountering `')'`.
4. If the current `')'` closes an immediate `"()"` pair, add `2^depth` to the score.
5. Return the accumulated score.

## 📊 Complexity Analysis

- **Time Complexity:** O(n)
- **Space Complexity:** O(1)

## 💻 Implementation (Java)

```java
class Solution {
    public int scoreOfParentheses(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        int score = 0;
        int depth = 0;

        for(int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(') depth++;
            else {
                depth--;
                if(s.charAt(i - 1) == '(') score += 1 << depth;
            }
        }

        return score;
    }
}
```
