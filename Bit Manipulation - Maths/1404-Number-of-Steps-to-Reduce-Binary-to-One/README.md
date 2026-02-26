# 1404. Number of Steps to Reduce a Number in Binary Representation to One (Medium)

## 📝 Problem Statement
Given a binary string `s`, return the number of steps to reduce it to 1:
- If current is even (ends in 0), divide by 2.
- If current is odd (ends in 1), add 1.

## 💡 Intuition & Approach
Converting the string to an integer will fail due to overflow (string length $\leq$ 500). Instead, we simulate the operations from the Least Significant Bit (LSB) to the Most Significant Bit (MSB).

### 🛠️ The Strategy:
1. **LSB to MSB:** Iterate from the end of the string towards the beginning (excluding the first bit).
2. **Carry Logic:** Keep track of a `carry` from previous additions.
3. **The Scenarios:**
   - **Case 1: (bit + carry == 1):** This represents an odd number. We must add 1 (making it even) and then divide by 2. This counts as **2 steps** and generates a **carry of 1**.
   - **Case 2: (bit + carry == 0 or 2):** This represents an even number. We just divide by 2 (right shift). This counts as **1 step**.
4. **Final Bit:** After the loop, if we have a `carry` of 1, it means the leading '1' became a '10', so we need one last division step.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We traverse the string once.
* **Space Complexity:** 𝙊(𝟭) - Only a few variables for `count` and `carry`.

## 💻 Implementation (Java)
```java
class Solution {
    public int numSteps(String s) {
        int count = 0, carry = 0;
        
        // Loop from right to left, stopping before the first character
        for(int i = s.length() - 1; i > 0; i--){
            // Check if (current bit + carry) is odd
            if((s.charAt(i) - '0') + carry == 1){
                count += 2; // Step 1: Add 1 (Odd to Even), Step 2: Divide by 2
                carry = 1;
            } else {
                count += 1; // Step 1: Divide by 2 (Even)
            }
        }

        return count + carry;
    }
}
