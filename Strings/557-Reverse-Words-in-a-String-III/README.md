# 557. Reverse Words in a String III (Easy)

## 📝 Problem Statement
Given a string `s`, reverse the order of characters in each word within a sentence while still preserving whitespace and the initial word order.

## 💡 Intuition & Approach
The goal is to reverse words individually without changing their sequence in the sentence. Instead of splitting the string into an array of words (which uses extra space), we can process the string as a character array and identify word boundaries by looking for spaces.

### 🛠️ The Strategy:
1. **Convert to Char Array:** Since Strings are immutable in Java, converting to `char[]` allows for in-place modification.
2. **Identify Boundaries:** Use a loop to find the `start` and `end` of each word.
   - A word ends when we hit a space `' '` or the end of the array.
3. **In-Place Reverse:** Once a word's boundaries are found, use a two-pointer `reverse` function to flip the characters between `start` and `end - 1`.
4. **Skip Spaces:** Update the `start` pointer to `end + 1` to begin the next word.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - Each character is visited at most twice (once to find the space and once during the swap).
* **Space Complexity:** 𝙊(𝗻) - We use a character array of size `n` to store and modify the string.

## 💻 Implementation (Java)
```java
class Solution {
    // Helper function to reverse a portion of the array in-place
    static void reverse(char[] charArray, int start, int end){
        while(start < end){
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start++;
            end--;
        }
    }

    public String reverseWords(String s) {
        char[] charArray = s.toCharArray();
        int len = s.length();
        int start = 0;

        for(int end = 0; end <= len; end++){
            // Check for space or end of string to identify a full word
            if(end == len || charArray[end] == ' '){
                reverse(charArray, start, end - 1);
                start = end + 1; // Move start to the beginning of next word
            }
        }
        return new String(charArray);
    }
}
