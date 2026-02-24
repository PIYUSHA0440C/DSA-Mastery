# 1281. Subtract the Product and Sum of Digits of an Integer (Easy)

## 📝 Problem Statement
Given an integer `n`, return the difference between the product of its digits and the sum of its digits.

## 💡 Intuition & Approach
The most efficient way to solve this is to extract digits one by one and update both the sum and product simultaneously.

### 🛠️ The Strategy:
1. **Initialize:** Start `sum = 0` and `product = 1` (since the identity for multiplication is 1).
2. **Digit Extraction:** - Use `n % 10` to get the last digit.
   - Use `n / 10` to remove the last digit.
3. **Accumulate:** In each step of the `while` loop, update both accumulators:
   - `sum += digit`
   - `product *= digit`
4. **Final Step:** Subtract the sum from the product and return the result.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗹𝗼𝗴₁₀ 𝗻) - The number of iterations is equal to the number of digits in $n$.
* **Space Complexity:** 𝙊(𝟭) - Only a few integer variables are used regardless of the input size.

## 💻 Implementation (Java)
```java
class Solution {
    public int subtractProductAndSum(int n) {
        int sum = 0;
        int product = 1;
        
        // Single pass to calculate both sum and product
        while(n != 0){
            int digit = n % 10;
            sum += digit;
            product *= digit;
            n /= 10;
        }

        return product - sum;
    }
}
