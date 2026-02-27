# 507. Perfect Number (Easy)

## 📝 Problem Statement
A perfect number is a positive integer that is equal to the sum of its positive divisors, excluding the number itself. Given an integer `n`, return `true` if it is a perfect number, otherwise return `false`.

## 💡 Intuition & Approach
To determine if a number is "perfect," we need to find all its factors and sum them up.

### 🛠️ The Strategy:
1. **Edge Case:** 1 is not a perfect number (its only divisor is itself, and the definition requires excluding the number itself), so we return `false`.
2. **Iteration:** Loop from 1 up to `num / 2`. 
3. **Divisibility Check:** If `num % i == 0`, add `i` to the running `sum`.
4. **Final Comparison:** Check if `sum == num`.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - In the current implementation, we check all numbers up to $n/2$. 
  * *Note: This can be optimized to $O(\sqrt{n})$ by adding both $i$ and $num/i$ in a single loop.*
* **Space Complexity:** 𝙊(𝟭) - Only a single integer is used to track the sum.

## 💻 Implementation (Java)
```java
class Solution {
    public boolean checkPerfectNumber(int num) {
        // 1 is not a perfect number
        if(num <= 1) return false;
        
        int sum = 0;
        // Optimization: Divisors cannot exceed num/2
        for(int i = 1; i <= num / 2; i++){
            if(num % i == 0) sum += i;
        }

        return sum == num;
    }
}
