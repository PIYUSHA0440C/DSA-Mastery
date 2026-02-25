# 1323. Maximum 69 Number (Easy)

## 📝 Problem Statement
Given a positive integer `num` consisting only of digits `6` and `9`, return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).

## 💡 Intuition & Approach
Since we want to maximize the number, we should aim to change a `6` to a `9` at the highest possible power of 10. This means scanning the number from left to right and flipping the very first `6` we encounter.

### 🛠️ The Strategy:
1. **Conversion:** Convert the integer to a `char[]` or `StringBuilder` to allow index-based modification.
2. **Greedy Scan:** Iterate through the digits from index `0` (leftmost).
3. **The Flip:** The moment we see a `'6'`, change it to a `'9'` and immediately `break` the loop. 
4. **Result:** Convert the modified character array back into an integer. If no `6` was found, the number is already at its maximum.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗱) - where $d$ is the number of digits in `num`. Since the maximum value is 10,000, $d$ is at most 5.
* **Space Complexity:** 𝙊(𝗱) - To store the character array representation of the number.

## 💻 Implementation (Java)
```java
class Solution {
    public int maximum69Number(int num) {
        // Convert to char array for easy modification
        char[] digits = String.valueOf(num).toCharArray();  
        
        for (int i = 0; i < digits.length; i++) {
            // Greedy: change the leftmost '6' to '9'
            if (digits[i] == '6') {
                digits[i] = '9';
                break; 
            }
        }
        
        // Convert back to integer
        return Integer.parseInt(new String(digits));
    }
}
