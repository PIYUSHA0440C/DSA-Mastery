# 744. Find Smallest Letter Greater Than Target

## 📝 Problem Statement
You are given an array of characters `letters` sorted in non-decreasing order, and a character `target`.
Return the smallest character in `letters` that is lexicographically greater than `target`. If such a character does not exist, return the first character in `letters`.



## 💡 Intuition & Approach
This problem is a variation of finding the **Ceiling** of a value in a sorted array. Since the array is sorted, Binary Search is the most efficient approach ($O(\log n)$).

1. **Binary Search Logic:** We want to find the first character that is strictly greater than the `target`.
2. **The "Wrap-Around" Condition:** The problem states that if no such character exists, we should return the first character in the array. 
3. **The Modulo Trick:** Instead of using an `if-else` statement to check if the `start` pointer exceeded the array length, we return `letters[start % len]`.
   - If `start` is within bounds, `start % len` is just `start`.
   - If `start` equals `len` (meaning no character was found), `start % len` becomes `0`, correctly returning the first element.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝙡𝙤𝙜 𝙣) — Standard Binary Search.
* **Space Complexity:** 𝙊(𝟭) — No extra space used.

## 💻 Code (Java)
```java
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int len = letters.length;
        int start = 0;
        int end = len - 1;

        while (start <= end){
            int mid = start + (end - start) / 2;

            if(target < letters[mid]){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        // Using modulo to wrap around if no character is greater than target
        return letters[start % len];
    }
}
