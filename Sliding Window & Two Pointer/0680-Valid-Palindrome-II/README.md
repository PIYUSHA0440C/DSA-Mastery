# 680. Valid Palindrome II (Easy)

## 📝 Problem Statement
Given a string `s`, return `true` if the `s` can be a palindrome after deleting **at most one** character from it.

## 💡 Intuition & Approach
A classic palindrome check uses two pointers moving toward the center. If all characters match, it's a valid palindrome. 

For *Valid Palindrome II*, we are allowed a single deletion. We can run our two-pointer approach greedily:
1. As long as `s.charAt(left) == s.charAt(right)`, we confidently move our pointers inward because these characters *must* match in any valid palindromic configuration.
2. The moment a mismatch happens (`s.charAt(left) != s.charAt(right)`), we reach a crossroads. We must utilize our single deletion allowance. We check both paths:
   - Skip the left character: Check if the substring from `left + 1` to `right` is a palindrome.
   - Skip the right character: Check if the substring from `left` to `right - 1` is a palindrome.
3. If either branch returns `true`, then the string is valid under the problem constraints. If both fail, it's impossible to fix with a single deletion.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - In the worst-case scenario, we scan the string up to the mismatch point, and then scan the remaining substring elements once more. Since we look at each character a maximum of two times, the runtime scales linearly with $n$.
* **Space Complexity:** 𝙊(𝟭) - The check is done entirely in-place utilizing index pointers without allocating any extra string copies.

## 💻 Implementation (Java)
```java
class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Mismatch detected: try skipping either the left or right character
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }

        return true;
    }

    // Helper method to validate a strict palindrome range
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
