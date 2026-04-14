# 70. Climbing Stairs (Easy)

## 📝 Problem Statement
You are climbing a staircase that takes `n` steps to reach the top. Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

## 💡 Intuition & Approach
This is a classic Dynamic Programming problem. To reach the $n^{th}$ step, you could have only come from:
1. The $(n-1)^{th}$ step (by taking a 1-step jump).
2. The $(n-2)^{th}$ step (by taking a 2-step jump).

Therefore: $Ways(n) = Ways(n-1) + Ways(n-2)$.
This is exactly the **Fibonacci sequence** pattern.

### 🛠️ The Strategy:
1. **Base Cases:** If $n=1$, return 1. If $n=2$, return 2.
2. **Iterative Summation:** Instead of recursion (which is $O(2^n)$), we use an iterative approach to calculate the next value based on the previous two.
3. **Space Optimization:** Since we only ever need the last two values, we use two variables (`n1` and `n2`) to keep track of the progress, avoiding the need for an $O(n)$ array.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We iterate from 3 to $n$ exactly once.
* **Space Complexity:** 𝙊(𝟭) - We only store two integer variables regardless of $n$.

## 💻 Implementation (Java)
```java
class Solution {
    public int climbStairs(int n) {
        // Base cases for 1 and 2 steps
        if (n <= 2) return n;

        int n1 = 1; // Ways to reach step 1
        int n2 = 2; // Ways to reach step 2
        
        // Calculate ways for step 3 up to n
        while (n - 2 > 0) {
            int current = n2 + n1;
            n1 = n2;
            n2 = current;
            n--;
        }

        return n2;
    }
}
