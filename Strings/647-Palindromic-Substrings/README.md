# 647. Palindromic Substrings (Medium)

## 📝 Problem Statement
Given a string `s`, return the number of palindromic substrings in it. A string is a palindrome when it reads the same backward as forward.

## 💡 Intuition & Approach
The brute-force approach involves checking every possible substring to see if it satisfies the palindrome condition.

### 🛠️ The Strategy:
1. **Substring Generation:** Use nested loops where `i` is the start index and `j` is the end index to capture every contiguous sequence.
2. **Palindrome Validation:** For each substring, use a helper function `isPalindrome`:
   - Compare the character at index `k` with the character at `(length - 1) - k`.
   - If any pair doesn't match, it's not a palindrome.
3. **Counting:** Increment a `result` counter every time `isPalindrome` returns `true`.
4. **Base Cases:** Single characters are always palindromes, which this logic handles naturally.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻³) - $O(n^2)$ to generate all substrings and $O(n)$ to check each one.
* **Space Complexity:** 𝙊(𝗻) - Due to the `s.substring()` method creating new string objects in each iteration.

## 💻 Implementation (Java)
```java
class Solution {
    public int countSubstrings(String s) {
        int result = 0;
        int len = s.length();
        
        // Generate all possible substrings
        for(int i = 0; i < len; i++){
            for(int j = i; j < len; j++){
                // Check if the current substring is a palindrome
                if(isPalindrome(s.substring(i, j + 1))) {
                    result++;
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
            if(s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}
