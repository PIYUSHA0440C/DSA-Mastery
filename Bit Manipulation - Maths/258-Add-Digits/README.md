# 258. Add Digits (Easy)

## 📝 Problem Statement
Given an integer `num`, repeatedly add all its digits until the result has only one digit, and return it.

## 💡 Intuition & Approach
The goal is to find the "digital root" of a number. 

### 🛠️ The Strategy:
1. **Base Case:** If the number is already less than 10, return it.
2. **Digit Extraction:** Use a `while` loop with `% 10` to extract each digit and `/ 10` to move to the next.
3. **Recursive Step:** Once you have the sum of the digits, if it's still $\geq 10$, call the function again with the new sum.
4. **Follow-up (Mathematical Shortcut):** This can be solved in $O(1)$ using the formula: 
   $dr(n) = 1 + ((n - 1) \pmod 9)$



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗹𝗼𝗴 𝗻) - The number of digits decreases in each step.
* **Space Complexity:** 𝙊(𝗹𝗼𝗴 𝗻) - Due to the recursive call stack.

## 💻 Implementation (Java)
```java
class Solution {
    public int addDigits(int num) {
        if(num < 10) return num;
        
        int sum = 0;
        while(num > 0){
            int digit = num % 10;
            sum += digit;
            num = num / 10;
        }
        
        // If the sum is still multiple digits, recurse
        if(sum < 10){
            return sum;
        } else {
            return addDigits(sum);
        }
    }
}
