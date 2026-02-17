# 263. Ugly Number (Easy)

## 📝 Problem Statement
An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5. Given an integer `n`, return `true` if `n` is an ugly number.

## 💡 Intuition & Approach
The core idea is to "drain" the number of all its allowable prime factors (2, 3, and 5). If we are left with `1`, it means there were no other prime factors involved.

### 🛠️ The Strategy:
1. **Initial Check:** If $n \leq 0$, it cannot be an ugly number by definition.
2. **Successive Division:** - While $n$ is divisible by 2, divide by 2.
   - While $n$ is divisible by 3, divide by 3.
   - While $n$ is divisible by 5, divide by 5.
3. **The Verdict:** If $n$ becomes `1`, it is an Ugly Number. If it stops at any other value, that value must be a prime factor (or contains a prime factor) other than 2, 3, or 5.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗹𝗼𝗴 𝗻) - The number of divisions is proportional to the number of prime factors of $n$.
* **Space Complexity:** 𝙊(𝟭) - Only the input variable is modified.

## 💻 Implementation (Java)
```java
class Solution {
    public boolean isUgly(int n) {
        if(n <= 0) return false;
        
        // Repeatedly divide by the allowed prime factors
        while(n > 1) {
            if(n % 2 == 0) n /= 2;
            else if(n % 3 == 0) n /= 3;
            else if(n % 5 == 0) n /= 5;
            // If not divisible by 2, 3, or 5, it's not "ugly"
            else return false;
        }
        
        return n == 1;
    }
}
