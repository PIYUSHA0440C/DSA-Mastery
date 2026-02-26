# 415. Add Strings (Easy)

## 📝 Problem Statement
Given two non-negative integers, `num1` and `num2` represented as strings, return their sum as a string. You cannot use any built-in `BigInteger` libraries or convert the inputs directly to integers.

## 💡 Intuition & Approach
This is a classic "Elementary Math" simulation. We perform addition digit by digit from right to left, just like we were taught in school.

### 🛠️ The Strategy:
1. **Two Pointers:** Start at the end of both strings (`len1` and `len2`).
2. **Carry Management:** Initialize `carry = 0`. In each step, the `sum` is `digit1 + digit2 + carry`.
3. **Loop Condition:** The loop continues as long as there is a digit left in `num1`, `num2`, OR there is a remaining `carry` to be added.
4. **Digit Extraction:** Convert characters to integers using `c - '0'`. 
5. **Building the Result:** Use a `StringBuilder` to append the current digit (`sum % 10`). After the loop, `reverse()` the builder to get the correct order.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗺𝗮𝘅(𝗡, 𝗠)) - We iterate through the longer of the two strings once.
* **Space Complexity:** 𝙊(𝗺𝗮𝘅(𝗡, 𝗠)) - To store the resulting sum in the `StringBuilder`.

## 💻 Implementation (Java)
```java
class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0 || carry > 0) {
            int n1 = (i >= 0) ? num1.charAt(i--) - '0' : 0;
            int n2 = (j >= 0) ? num2.charAt(j--) - '0' : 0;

            int sum = n1 + n2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }

        return sb.reverse().toString();
    }
}
