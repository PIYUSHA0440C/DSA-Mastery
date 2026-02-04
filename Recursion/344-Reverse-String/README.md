# 344. Reverse String (Easy)

## 📝 Problem Statement
Write a function that reverses a string. The input string is given as an array of characters `s`. You must do this by modifying the input array **in-place** with **O(1)** extra memory.

## 💡 Intuition & Approach
To reverse an array in-place, the most intuitive method is the **Two Pointer** technique. By swapping the characters at the `start` and `end` indices and moving inward, we transform the string without needing any additional data structures.

### 🛠️ The Strategy:
1. **Recursive Implementation:** I chose to implement the two-pointer logic using recursion to practice stack-based problem solving.
2. **Base Case:** The recursion stops when `start >= end`.
3. **In-place Swap:** A temporary variable `char temp` is used to swap values, ensuring the modification happens directly on the input array.
4. **Logic:** Swap elements, then recursively call the function for the remaining middle portion of the array (`start + 1`, `end - 1`).



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - Every character is visited once, resulting in $n/2$ swaps.
* **Space Complexity:** 𝙊(𝗻) - Due to the recursion stack. (Note: An iterative `while` loop would reduce this to $O(1)$).

## 💻 Implementation (Java)
```java
class Solution {
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        reverse(s, start, end);
    }
    
    void reverse(char[] s, int start, int end){
        // Base case: Pointers have met or crossed
        if(start >= end) return;
        
        // Swap
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        
        // Move pointers inward via recursion
        reverse(s, start + 1, end - 1);
    }
}
