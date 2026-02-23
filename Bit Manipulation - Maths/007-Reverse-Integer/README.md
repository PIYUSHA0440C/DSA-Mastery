# 7. Reverse Integer (Medium)

## 📝 Problem Statement
Given a signed 32-bit integer `x`, return `x` with its digits reversed. If reversing `x` causes the value to go outside the signed 32-bit integer range $[-2^{31}, 2^{31} - 1]$, then return `0`.

## 💡 Intuition & Approach
The logic for reversing a number involves popping the last digit using the modulo operator (`%`) and pushing it onto the new number by multiplying the previous result by 10.

### 🛠️ The Strategy:
1. **Digit Extraction:** In a `while` loop, extract the last digit: `x % 10`.
2. **Reconstruction:** Build the reversed number: `ans = (ans * 10) + digit`.
3. **Overflow Handling:** Since a 32-bit integer reversed can easily exceed $2,147,483,647$, we use a `long` variable for `ans` to safely capture the overflow during the process.
4. **Range Check:** After the loop, compare `ans` against `Integer.MAX_VALUE` and `Integer.MIN_VALUE`. If it's out of bounds, return `0`.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗹𝗼𝗴₁₀ 𝗻) - We process each digit of the number once. For a 32-bit integer, this is at most 10 iterations.
* **Space Complexity:** 𝙊(𝟭) - Only constant extra space is used for the variables.

## 💻 Implementation (Java)
```java
class Solution {
    public int reverse(int x) {
        long ans = 0; // Use long to handle temporary overflow
        while(x != 0){
            int digit = x % 10;
            ans = (ans * 10) + digit;
            x /= 10;
        }

        // Check if the result fits in a 32-bit signed integer
        if(ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) return 0;
        
        return (int) ans;
    }
}
