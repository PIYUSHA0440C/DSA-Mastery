# 1456. Maximum Number of Vowels in a Substring of Given Length (Medium)

## 📝 Problem Statement

Given a string `s` and an integer `k`, return the maximum number of vowel letters in any substring of `s` with length exactly `k`.

The vowels are `'a'`, `'e'`, `'i'`, `'o'`, and `'u'`.

## 💡 Intuition & Approach

Since every substring has a fixed length `k`, we can use a **sliding window** to maintain the number of vowels in the current substring.

### 🛠️ The Strategy:

1. Count the vowels in the first `k` characters.
2. Store this count as the initial maximum.
3. Slide the window one character at a time:
   - Add the new character if it is a vowel.
   - Remove the character leaving the window if it is a vowel.
   - Update the maximum vowel count.
4. Return the maximum count found.

## 📊 Complexity Analysis

- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(1)`

## 💻 Implementation (Java)

```java
class Solution {
    public int maxVowels(String s, int k) {
        int count = 0;
        for(int i = 0; i < k; i++){
            if(isVowel(s.charAt(i))) count++;
        }

        int maxAns = count;

        for(int i = k; i < s.length(); i++){
            if(isVowel(s.charAt(i))) count++;
            if(isVowel(s.charAt(i - k))) count--;

            maxAns = Math.max(maxAns, count);
        }

        return maxAns;        
    }

    private boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
```
