# 345. Reverse Vowels of a String (Easy)

## 📝 Problem Statement
Given a string `s`, reverse only all the vowels in the string and return it. The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases.

## 💡 Intuition & Approach
To reverse only specific characters (vowels) while keeping others in place, the **Two-Pointer** approach is the most efficient.

### 🛠️ The Strategy:
1. **Convert to Array:** Strings in Java are immutable, so we convert `s` to a `char[]` for in-place swapping.
2. **Initialize Pointers:** `left` starts at 0, and `right` starts at the last index.
3. **The Search:**
   - Move the `left` pointer forward until it hits a vowel.
   - Move the `right` pointer backward until it hits a vowel.
4. **The Swap:** Once both pointers are on vowels, swap them and move both pointers inward.
5. **Efficiency:** By using `vowels.indexOf(char) == -1`, we easily identify non-vowel characters.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - Each character is visited at most once by the pointers.
* **Space Complexity:** 𝙊(𝗻) - To store the character array.

## 💻 Implementation (Java)
```java
class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        String vowels = "aeiouAEIOU";
        
        while (left < right) {
            // Find vowel from left
            if (vowels.indexOf(arr[left]) == -1) {
                left++;
            } 
            // Find vowel from right
            else if (vowels.indexOf(arr[right]) == -1) {
                right--;
            } 
            // Both are vowels, so swap
            else {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return new String(arr);
    }
}
