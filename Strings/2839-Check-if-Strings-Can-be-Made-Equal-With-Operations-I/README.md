# 2839. Check if Strings Can be Made Equal With Operations I (Easy)

## 📝 Problem Statement
You are given two strings `s1` and `s2` of length 4. You can swap characters at indices `i` and `j` if $|j - i| = 2$. Return `true` if you can make `s1` equal to `s2`.

## 💡 Intuition & Approach
The restriction $|j - i| = 2$ implies that characters at even indices (0, 2) can only be swapped with each other, and characters at odd indices (1, 3) can only be swapped with each other. They exist in two independent "lanes."

### 🛠️ The Strategy:
1. **Identify the Pools:** - Even Pool: Indices 0 and 2.
   - Odd Pool: Indices 1 and 3.
2. **Lane Independence:** If the characters in the even pool of `s1` match the even pool of `s2` (regardless of order), and the same holds for the odd pools, then the strings can be made equal.
3. **Validation:**
   - Extract even characters from both strings and sort them.
   - Extract odd characters from both strings and sort them.
   - Compare the sorted versions. If both lanes match, return `true`.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝟭) - Since the string length is fixed at 4, the number of operations is constant.
* **Space Complexity:** 𝙊(𝟭) - We use small arrays of size 2.

## 💻 Implementation (Java)
```java
class Solution {
    public boolean canBeEqual(String s1, String s2) {
        // Group characters by their "lanes" (indices 0,2 and 1,3)
        char[] s1Even = {s1.charAt(0), s1.charAt(2)};
        char[] s1Odd  = {s1.charAt(1), s1.charAt(3)};
        
        char[] s2Even = {s2.charAt(0), s2.charAt(2)};
        char[] s2Odd  = {s2.charAt(1), s2.charAt(3)};

        // Sort both lanes to check if they contain the same characters
        Arrays.sort(s1Even);
        Arrays.sort(s1Odd);
        Arrays.sort(s2Even);
        Arrays.sort(s2Odd);

        // If both lanes are identical in content, transformation is possible
        return Arrays.equals(s1Even, s2Even) && Arrays.equals(s1Odd, s2Odd);
    }
}
