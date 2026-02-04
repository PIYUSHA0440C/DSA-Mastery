# 509. Fibonacci Number (Easy)

## 📝 Problem Statement
The Fibonacci numbers, commonly denoted `F(n)`, form a sequence called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from `0` and `1`.

- `F(0) = 0, F(1) = 1`
- `F(n) = F(n - 1) + F(n - 2)`, for `n > 1`.

Given `n`, calculate `F(n)`.

## 💡 Intuition & Approach
The Fibonacci sequence is the textbook definition of a recursive problem. To find the value of any number in the sequence, you must first find the values of the two numbers before it.

### 🛠️ The Strategy:
1. **Base Case:** If $n$ is 0 or 1, we return $n$ directly because the value is already defined.
2. **Recursive Decomposition:** For any value greater than 1, the function calls itself twice: once for $(n-1)$ and once for $(n-2)$.
3. **The Result:** The values from these recursive calls bubble back up the call stack and are summed together to produce the final result.



## 📊 Complexity Analysis
* **Time Complexity:** $O(2^n)$ - Exponential time. Every call branches into two more calls, creating a massive tree of redundant calculations.
* **Space Complexity:** $O(n)$ - The space is determined by the maximum depth of the recursion stack.

## 💻 Implementation (Java)
```java
class Solution {
    public int fib(int n) {
        return fiboNum(n);
    }

    int fiboNum(int n) {
        // Base Cases
        if (n == 0 || n == 1) {
            return n;
        }
        
        // Recursive Step
        return fiboNum(n - 1) + fiboNum(n - 2);
    }
}
