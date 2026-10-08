# 1963. Minimum Number of Swaps to Make the String Balanced (Medium)

## 📝 Problem Statement

Given a string `s` containing an equal number of opening brackets `'['` and closing brackets `']'`, return the minimum number of swaps needed to make the string balanced.

A swap can exchange the brackets at any two indices.

## 💡 Intuition & Approach

We scan the string while tracking the number of currently unmatched opening brackets using `stackSize`.

When we encounter `'['`, it can balance a future `']'`, so we increase `stackSize`.

When we encounter `']'`, we use an available unmatched `'['` if one exists. Otherwise, this closing bracket is unbalanced, so we increment `unbalanced`.

Because the string contains an equal number of opening and closing brackets, every swap can resolve two unmatched closing brackets. Therefore, the minimum number of swaps is `(unbalanced + 1) / 2`.

### 🛠️ The Strategy:

1. Maintain `stackSize` for unmatched `'['`.
2. For `'['`, increment `stackSize`.
3. For `']'`, decrement `stackSize` when an unmatched `'['` exists.
4. Otherwise, increment `unbalanced`.
5. Each swap fixes two unmatched brackets, so return `(unbalanced + 1) / 2`.

## 📊 Complexity Analysis

- **Time Complexity:** O(n)
- **Space Complexity:** O(1)

## 💻 Implementation (Java)

```java
class Solution {
    public int minSwaps(String s) {
        int stackSize = 0;
        int unbalanced = 0;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if (ch == '[') stackSize++;
            else {
                if (stackSize > 0) stackSize--;
                else unbalanced++;
            }
        }

        return (unbalanced + 1) / 2;
    }
}
```
