# 43. Multiply Strings (Medium)

## 📝 Problem Statement
Given two non-negative integers `num1` and `num2` represented as strings, return their product as a string. You cannot use `BigInteger` or direct string-to-integer conversions.

## 💡 Intuition & Approach
The core idea is to simulate the **Standard Long Multiplication** algorithm we learned in school, but adapted for a programmatic approach.

### 🛠️ The Strategy:
1. **Result Size:** The product of two numbers with lengths $L_1$ and $L_2$ will have at most $L_1 + L_2$ digits.
2. **Index Mapping:** When multiplying `num1[i]` and `num2[j]`, the product results in two digits that contribute to positions `i + j` (carry) and `i + j + 1` (sum) in our result array.
3. **Carries:** - Multiply the digits: `mul = digit1 * digit2`.
   - Add to the existing value at `res[i + j + 1]`.
   - Store the unit digit at `res[i + j + 1]` using `% 10`.
   - Add the carry to `res[i + j]` using `/ 10`.
4. **Cleanup:** Convert the array back to a string, skipping any leading zeros that were not filled.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗺 × 𝗻) - We multiply every digit of `num1` with every digit of `num2`.
* **Space Complexity:** 𝙊(𝗺 + 𝗻) - To store the result array of size $m + n$.

## 💻 Implementation (Java)
```java
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        
        int n1 = num1.length(), n2 = num2.length();
        int[] res = new int[n1 + n2];

        // Multiply from right to left
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + res[i + j + 1];

                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10; // Carry over
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : res) {
            // Skip leading zeros
            if (!(sb.length() == 0 && num == 0)) sb.append(num);
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
