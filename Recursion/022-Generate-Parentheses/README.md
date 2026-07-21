# 22. Generate Parentheses (Medium)

## 📝 Problem Statement

Given `n` pairs of parentheses, generate all possible combinations of **well-formed** parentheses.

A valid combination must ensure that every opening parenthesis has a corresponding closing parenthesis and that no closing parenthesis appears before its matching opening parenthesis.

---

## 💡 Intuition & Approach

This problem is a classic **Backtracking** problem.

Instead of generating every possible sequence of `'('` and `')'` and validating them afterward, we construct only valid combinations from the beginning.

At any point during recursion:

- We can add an **opening parenthesis** as long as we haven't used all `n` opening brackets.
- We can add a **closing parenthesis** only if the number of closing brackets used is less than the number of opening brackets already placed.

By enforcing these constraints during construction, every generated string is guaranteed to be valid.

### 🛠️ The Strategy

1. **Start with an Empty String**
   - Begin building the current combination recursively.

2. **Add Opening Parenthesis**
   - If fewer than `n` opening brackets have been used, append `'('`.

3. **Add Closing Parenthesis**
   - Append `')'` only when there is an unmatched opening parenthesis available.

4. **Store Complete Combination**
   - Once `n` closing brackets have been placed, a valid combination has been formed.
   - Add it to the result list.

---

## 📊 Complexity Analysis

- **Time Complexity:** **O(4ⁿ / √n)** - Equal to the number of valid parenthesis combinations (Catalan Number), with each combination taking O(n) to construct.

- **Space Complexity:** **O(n)** - Due to the recursion stack (excluding the output list).

---

## 💻 Implementation (Java)

```java
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        generate(combinations, "", 0, 0, n);

        return combinations;
    }

    private void generate(List<String> combinations, String str,
                          int open, int close, int max) {

        if(close == max) {
            combinations.add(str);
            return;
        }

        if(open < max)
            generate(combinations, str + "(", open + 1, close, max);

        if(close < open)
            generate(combinations, str + ")", open, close + 1, max);
    }
}
```
