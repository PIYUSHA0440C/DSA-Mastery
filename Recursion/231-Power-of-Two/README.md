# 231. Power of Two (Easy)

## 📝 Problem Statement
Given an integer `n`, return `true` if it is a power of two ($n = 2^x$). Otherwise, return `false`.

## 💡 Intuition & Approach
The property of a power of two is that it can be repeatedly divided by 2 until it reaches 1. If at any point the number becomes odd (other than 1), it is not a power of two.

### 🛠️ The Strategy:
1. **Recursive Reduction:** Use a helper function to divide `n` by 2 repeatedly.
2. **Base Cases:**
   - If `n == 1` or `n == 2`, return `true`.
3. **Recursive Step:**
   - If `n` is positive and even, recurse with `n / 2`.
4. **Failure Condition:**
   - If `n` is $\leq 0$ or becomes odd before reaching the base cases, return `false`.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗹𝗼𝗴 𝗻) - The number of divisions is proportional to the logarithm of $n$.
* **Space Complexity:** 𝙊(𝗹𝗼𝗴 𝗻) - Due to the recursion stack depth.

## 💻 Implementation (Java)
```java
class Solution {
    public boolean isPowerOfTwo(int n) {
        return helper(n);
    }

    boolean helper(int n) {
        // Base cases
        if (n == 2 || n == 1) return true;

        // Reduction step
        if (n > 0 && n % 2 == 0) {
            return helper(n / 2);
        }
        
        return false;
    }
}
