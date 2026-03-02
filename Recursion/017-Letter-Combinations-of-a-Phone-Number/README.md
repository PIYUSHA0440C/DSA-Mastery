# 17. Letter Combinations of a Phone Number (Medium)

## 📝 Problem Statement
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent based on a standard telephone keypad.

## 💡 Intuition & Approach
This is a **Permutation/Combination** problem that can be visualized as a decision tree. Each digit represents a set of choices (letters), and we need to explore every possible path to a leaf node.

### 🛠️ The Strategy:
1. **Recursive Exploration:** Use a helper function `pad(processed, unprocessed)`.
   - **Base Case:** When the `unprocessed` string is empty, we've formed a complete combination. Add it to a list and return.
   - **Recursive Step:** Take the first digit, find its corresponding letters, and for each letter, call `pad` again with the letter added to `processed` and the rest of the digits as `unprocessed`.
2. **Dynamic Mapping:** Instead of a Map, this solution calculates character offsets:
   - Digits 2-6 follow a 3-letter pattern.
   - Digit 7 (pqrs) and 9 (wxyz) have 4 letters.
   - Digit 8 (tuv) is shifted by the extra letter in 7.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝟰ⁿ) - In the worst case (digits like 7 or 9), each digit has 4 choices. $n$ is the length of digits.
* **Space Complexity:** 𝙊(𝗻) - The recursion stack depth is equal to the number of digits.

## 💻 Implementation (Java)
```java
class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();
        return pad("", digits);
    }

    private List<String> pad(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        int digit = up.charAt(0) - '0';
        ArrayList<String> list = new ArrayList<>();

        // Math-based mapping for the keypad
        int start = (digit - 2) * 3;
        if (digit > 7) start++;
        
        int end = start + 3;
        if (digit == 7 || digit == 9) end++;

        for (int i = start; i < end; i++) {
            char ch = (char) ('a' + i);
            list.addAll(pad(p + ch, up.substring(1)));
        }
        return list;
    }
}
