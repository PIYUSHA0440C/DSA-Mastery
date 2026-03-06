# 201. Bitwise AND of Numbers Range (Medium)

## 📝 Problem Statement
Given two integers `left` and `right`, return the bitwise AND of all numbers in this range, inclusive.

## 💡 Intuition & Approach
The key insight is that as numbers increment, the lower bits flip frequently between 0 and 1. When you perform a bitwise AND over a range, any bit that flips at least once will eventually become 0. Therefore, the result of a bitwise AND over a range is simply the **Common Binary Prefix** of the two boundary numbers.

### 🛠️ The Strategy:
1. **Right Shift:** While `left` is not equal to `right`, shift both numbers to the right (`>> 1`). 
2. **Count Shifts:** Keep track of how many times you shift in a `count` variable. This effectively removes the bits that change within the range.
3. **Left Shift:** Once `left == right`, we have found the common prefix. Shift the remaining value back to the left (`<< count`) to restore the zeros in the trailing positions.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗹𝗼𝗴 𝗻) - At most 31 iterations (the number of bits in an integer).
* **Space Complexity:** 𝙊(𝟭) - Only two integer variables are used.

## 💻 Implementation (Java)
```java
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int count = 0;
        
        // Find the common prefix by shifting right until numbers match
        while(left != right){
            left >>= 1;
            right >>= 1;
            count++;
        }
        
        // Shift back to the left to append the zeros
        return (left << count);
    }
}
