# 409. Longest Palindrome (Easy)

## 📝 Problem Statement
Given a string `s`, return the length of the longest palindrome that can be built using the characters from that string. Letters are case-sensitive.

## 💡 Intuition & Approach
To form a palindrome, characters must appear in pairs (left and right sides). A single character can also be placed in the middle.

### 🛠️ The Strategy:
1. **Frequency Counting:** Use an integer array of size 128 (to cover ASCII) to count the occurrences of each character.
2. **Greedy Construction:**
   - If a character appears an **even** number of times (e.g., 4), we can use all of them.
   - If a character appears an **odd** number of times (e.g., 5), we can use the largest even number (5 - 1 = 4).
3. **The Center Piece:** If there was at least one character with an odd count, we can take one of those extra characters and place it in the middle of our palindrome.
4. **Final Calculation:** `Result = (Sum of all even contributions) + (1 if any odd count existed)`.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We iterate through the string once and the fixed-size frequency array once.
* **Space Complexity:** 𝙊(𝟭) - The frequency array size is constant (128), regardless of the input string length.

## 💻 Implementation (Java)
```java
class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char ch : s.toCharArray()) {
            count[ch]++;
        }

        int length = 0;
        boolean hasOdd = false;

        for (int v : count) {
            if (v % 2 == 0) {
                length += v;
            } else {
                length += v - 1; // Take the even part
                hasOdd = true;   // Mark that we have a potential center
            }
        }

        return hasOdd ? length + 1 : length;
    }
}
