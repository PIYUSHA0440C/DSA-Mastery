# 709. To Lower Case (Easy)

## 📝 Problem Statement
Given a string `s`, return the string after replacing every uppercase letter with the same lowercase letter.

## 💡 Intuition & Approach
The most straightforward approach in Java is using the built-in `String.toLowerCase()` method. However, understanding the manual logic is essential for low-level programming.

### 🛠️ Manual Logic (Behind the scenes):
In the ASCII table, uppercase letters 'A'-'Z' range from 65 to 90, and lowercase letters 'a'-'z' range from 97 to 122.
* The difference between 'a' (97) and 'A' (65) is exactly **32**.
* To convert manually, you can iterate through the string and add 32 to any character in the 65-90 range.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - Every character in the string must be checked.
* **Space Complexity:** 𝙊(𝗻) - A new string is created since strings in Java are immutable.

## 💻 Implementation (Java)
```java
class Solution {
    public String toLowerCase(String s) {
        // Built-in efficient method
        return s.toLowerCase();
    }
}
