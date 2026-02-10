# 1071. Greatest Common Divisor of Strings (Easy)

## 📝 Problem Statement
For two strings `str1` and `str2`, we say "t divides s" if and only if `s = t + t + ... + t`. Given `str1` and `str2`, return the largest string `x` such that `x` divides both `str1` and `str2`.

## 💡 Intuition & Approach
This problem bridges the gap between basic string manipulation and number theory. 

### 🛠️ The Strategy:
1. **The Commutative Property:** If `str1` and `str2` share a common divisor string, then concatenating them in different orders must result in the same string:
   $$str1 + str2 = str2 + str1$$
   If this check fails, there is no common divisor string, and we return `""`.
2. **The GCD of Lengths:** If they do share a common divisor, the length of the *greatest* common divisor string must be the Greatest Common Divisor of the lengths of `str1` and `str2`.
3. **Euclidean Algorithm:** We calculate $gcd(len1, len2)$ using the recursive Euclidean method:
   $$gcd(a, b) = \text{if } b = 0 \text{ then } a \text{ else } gcd(b, a \pmod b)$$
4. **Result:** Return the prefix of `str1` with the calculated GCD length.



## 📊 Complexity Analysis
* **Time Complexity:** $O(N + M)$ - We perform string concatenation and comparison, which takes linear time relative to the lengths of the strings. The GCD calculation is $O(\log(\min(N, M)))$.
* **Space Complexity:** $O(N + M)$ - We create new strings during the concatenation check.

## 💻 Implementation (Java)
```java
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // Step 1: Check if a common divisor string even exists
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        // Step 2: Find GCD of the two lengths
        int gcdLength = gcd(str1.length(), str2.length());

        // Step 3: The GCD string is the prefix of that length
        return str1.substring(0, gcdLength);
    }

    // Recursive Euclidean Algorithm
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
