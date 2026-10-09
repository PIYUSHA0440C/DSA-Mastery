# 1541. Minimum Insertions to Balance a Parentheses String (Medium)

## 📝 Problem Statement

Given a string `s` containing only `'('` and `')'`, find the minimum number of insertions required to make it balanced.

Each `'('` must have two consecutive closing parentheses `'))'` to match it.

## 💡 Intuition & Approach

We track unmatched opening parentheses using `leftCount` and count the required insertions using `insertions`.

When we encounter `'('`, we increase `leftCount` because it needs two consecutive closing parentheses.

When we encounter `')'`, we first check whether an unmatched opening parenthesis exists. If not, we need to insert an opening parenthesis.

Next, we check whether the current `')'` is followed by another `')'`. If it is, both closing parentheses form a pair. Otherwise, we insert a missing `')'`.

After processing the string, each unmatched opening parenthesis requires two closing parentheses, so we add `leftCount * 2` to the answer.

### 🛠️ The Strategy:

1. Initialize `insertions` and `leftCount` to zero.
2. For `'('`, increment `leftCount`.
3. For `')'`, insert `'('` if no unmatched opening parenthesis exists; otherwise, match it with an opening parenthesis.
4. Check whether the current `')'` is followed by another `')'`. Skip the next character if it completes the pair; otherwise, count one insertion for the missing `')'`.
5. Add two insertions for each unmatched opening parenthesis remaining.
6. Return the total insertions.

## 📊 Complexity Analysis

- **Time Complexity:** O(n)
- **Space Complexity:** O(1)

## 💻 Implementation (Java)

```java
class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int leftCount = 0;
        int length = s.length();
        int index = 0;

        while(index < length){
            char ch = s.charAt(index);

            if (ch == '(') leftCount++;
            else {
                if (leftCount > 0) leftCount--;
                else insertions++;

                if (index < length - 1 && s.charAt(index + 1) == ')') index++;
                else insertions++;
            }

            index++;
        }

        insertions += leftCount * 2;

        return insertions;
    }
}
```
