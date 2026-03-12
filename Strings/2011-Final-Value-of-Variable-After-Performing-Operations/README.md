# 2011. Final Value of Variable After Performing Operations (Easy)

## 📝 Problem Statement
A programming language has four operations: `++X`, `X++` (increment) and `--X`, `X--` (decrement). Starting with $X = 0$, return the final value after a list of operations.

## 💡 Intuition & Approach
While string comparisons (`equals` or `contains`) work, we can optimize this by observing the structure of the input strings.

### 🛠️ The Strategy:
1. **Index Observation:** In all four possible strings (`++X`, `X++`, `--X`, `X--`), the character at **index 1** is always the operator itself ('+' or '-').
2. **ASCII Math Optimization:**
   - The ASCII value of `+` is 43.
   - The ASCII value of `-` is 45.
   - By using the formula `x += (44 - operation.charAt(1))`, we effectively add `1` for increments and `-1` for decrements without any branching logic (if-statements).
3. **Performance:** This eliminates string pool lookups and branching, making it extremely fast.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We iterate through the array once.
* **Space Complexity:** 𝙊(𝟭) - Only one integer variable `x` is used.

## 💻 Implementation (Java)
```java
class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for(String o : operations) {
            // ASCII of '+' is 43, ASCII of '-' is 45
            // 44 - 43 = 1
            // 44 - 45 = -1
            x += (44 - o.charAt(1));
        }
        return x;
    }
}
