# 136. Single Number (Easy)

## 📝 Problem Statement
Given a non-empty array of integers `nums`, every element appears twice except for one. Find that single one. You must implement a solution with a linear runtime complexity and use only constant extra space.

## 💡 Intuition & Approach
The constraints (Linear time $O(n)$ and Constant space $O(1)$) rule out sorting or using a Hashmap. The secret weapon here is **Bit Manipulation** using the XOR operator.

### 🛠️ The Strategy:
**The Properties of XOR (`^`):**
1. **Commutative:** $A \oplus B = B \oplus A$
2. **Self-Inverse:** $A \oplus A = 0$
3. **Identity:** $A \oplus 0 = A$



By XORing every number in the array together:
- All numbers that appear twice will pair up and result in `0` (because $x \oplus x = 0$).
- The single number will eventually be XORed with `0`, leaving it as the final result (because $x \oplus 0 = x$).

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We iterate through the array exactly once.
* **Space Complexity:** 𝙊(𝟭) - We only store one integer (`ans`), regardless of array size.

## 💻 Implementation (Java)
```java
class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        // XOR all elements in the array
        for(int i : nums){
            ans ^= i; 
        }
        // Duplicates cancel out, leaving the single number
        return ans;
    }
}
