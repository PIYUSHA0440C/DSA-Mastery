# 9. Palindrome Number (Easy)

## 📝 Problem Statement
Given an integer `x`, return `true` if `x` is a palindrome, and `false` otherwise. An integer is a palindrome when it reads the same forward and backward.

**Follow-up:** Solve it without converting the integer to a string.

## 💡 Intuition & Approach
To check for a palindrome without using strings, we can reverse the integer mathematically and compare it to the original value.

### 🛠️ The Strategy:
1. **Handle Negatives:** Negative numbers (like -121) can never be palindromes because the negative sign at the front won't exist at the back.
2. **Copy the Original:** Since we will be destroying the number to extract digits, we store a copy of `x` in `xCopy`.
3. **Mathematical Reversal:** - Use `% 10` to get the last digit.
   - Build the `newNum` by multiplying the current `newNum` by 10 and adding the digit.
   - Use `/ 10` to remove the last digit from the copy.
4. **Final Check:** Return `true` if the original `x` is equal to our `newNum`.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗹𝗼𝗴₁₀(𝗻)) - We process each digit of the number once.
* **Space Complexity:** 𝙊(𝟭) - We only use a few integer variables regardless of the size of the input.

## 💻 Implementation (Java)
```java
class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers are not palindromes
        if(x < 0){
            return false;
        }
        
        int newNum = 0;
        int xCopy = x;
        
        while(xCopy > 0){
            int digit = xCopy % 10;
            // Build the reversed number
            newNum = (newNum * 10) + digit;
            xCopy /= 10;
        }
        
        // If reversed equals original, it's a palindrome
        return x == newNum;
    }
}
