# 50. Pow(x, n) (Medium)

## 📝 Problem Statement
Implement `pow(x, n)`, which calculates $x$ raised to the power $n$ ($x^n$). The solution must handle large exponents and negative powers efficiently.

## 💡 Intuition & Approach
A naive approach of multiplying $x$, $n$ times would be $O(n)$, which is too slow for $n = 2^{31}-1$. Instead, we use **Binary Exponentiation** (Divide and Conquer).

### 🛠️ The Strategy:
1. **Handling Negative Exponents:** If $n < 0$, we transform the problem: $x^n = (1/x)^{-n}$. We use a `long` to store $n$ to avoid overflow when negating `Integer.MIN_VALUE`.
2. **Recursive Logic (Binary Exponentiation):**
   - **Base Case:** $x^0 = 1$.
   - **Recursive Step:** Calculate $half = x^{n/2}$.
   - **Combine:** - If $n$ is even: $result = half \times half$.
     - If $n$ is odd: $result = half \times half \times x$.
3. **Efficiency:** This reduces the number of multiplications from $n$ to $\log n$.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗹𝗼𝗴 𝗻) - Each recursive call halves the exponent.
* **Space Complexity:** 𝙊(𝗹𝗼𝗴 𝗻) - The depth of the recursion stack.

## 💻 Implementation (Java)
```java
class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(x == 0 || x == 1) return x;
        
        long N = n; // Use long to handle Integer.MIN_VALUE overflow
        if(N < 0){
            N = -N;
            x = 1 / x;
        }

        return pow(x, N);
    }

    private double pow(double x, long n){
        if(n == 0) return 1;
        if(n == 1) return x;

        double half = pow(x, n / 2);

        // If even: (x^(n/2))^2
        if(n % 2 == 0) return half * half;
        
        // If odd: (x^(n/2))^2 * x
        return half * half * x;
    }
}
